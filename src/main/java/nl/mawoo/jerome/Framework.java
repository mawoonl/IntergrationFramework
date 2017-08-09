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
        System.out.println("    __  ___                                  __                             \n" +
                "   /  |/  /___ __      ______  ____         / /__  _________  ____ ___  ___ \n" +
                "  / /|_/ / __ `/ | /| / / __ \\/ __ \\   __  / / _ \\/ ___/ __ \\/ __ `__ \\/ _ \\\n" +
                " / /  / / /_/ /| |/ |/ / /_/ / /_/ /  / /_/ /  __/ /  / /_/ / / / / / /  __/\n" +
                "/_/  /_/\\__,_/ |__/|__/\\____/\\____/   \\____/\\___/_/   \\____/_/ /_/ /_/\\___/ \n" +
                "                                                                            ");
        logger.info("Booting up");
        logger.info("initialize the injector");
        logger.info("Starting bootloader");
        this.bootLoader = new BootLoader();
        bootLoader.setPackageLocation(packageLocation);
        bootLoader.pluginLoader();
        bootLoader.scanPlugins();
    }

    /**
     * This method will register a protocol that java.net.URL can reach when you open a new connection.
     * The protocol is defined as "maid://"
     *
     * example format: maid://[plugin]+[plugin]/path/to/file?query=parameters
     * example url: maid://filesystem/home/username/Documents/temp.txt
     */
    public void registerProtocol() {
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
