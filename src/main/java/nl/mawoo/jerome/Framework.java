package nl.mawoo.jerome;

import com.google.gson.Gson;
import nl.mawoo.jerome.engine.BootLoader;
import nl.mawoo.jerome.engine.Engine;
import nl.mawoo.jerome.model.MainDataModel;
import nl.mawoo.jerome.protocol.CurrentQuery;
import nl.mawoo.jerome.protocol.Protocol;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.List;

/**
 * Jerome - Connector Framework
 * The last data source you'll ever need.
 *
 * This framework is build to have many connections as one data source
 */
public class Framework {

    private static Logger logger = Logger.getLogger(Framework.class);
    private BootLoader bootLoader;
    private Engine engine;

    public Framework(String packageLocation) {
        logger.info("Mawoo Jerome (c) 2017");
        logger.info("----------------------------------");
        logger.info("Booting up");
        logger.info("initialize the injector");
        logger.info("Starting bootloader");
        this.bootLoader = new BootLoader();
        bootLoader.setPackageLocation(packageLocation);
        bootLoader.pluginLoader();
        bootLoader.scanPlugins();
        logger.info("Add protocol to system..");
        connection();
    }

    private void connection() {
        URL.setURLStreamHandlerFactory(protocol -> "maid".equals(protocol) ? new URLStreamHandler() {
            protected URLConnection openConnection(URL url) throws IOException {
                return new URLConnection(url) {
                    public void connect() throws IOException {
                        logger.info("Accepted request");
                        Protocol protocol = new Protocol(url);
                        CurrentQuery query = new CurrentQuery(protocol.getSelectedPlugins(), url.getPath(), url.getQuery());
                        engine = new Engine(query, bootLoader.getPluginMap());
                    }
                };
            }
        } : null);
    }

    public List<MainDataModel> run(String url) {
        try {
            bootLoader.visitUrl(url);
            List<MainDataModel> model = engine.run();
            logger.info(new Gson().toJson(model));
            return model;
        } catch (IOException e) {
            logger.error("cannot open url", e);
        }
        return null;
    }
}
