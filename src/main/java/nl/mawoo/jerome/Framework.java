package nl.mawoo.jerome;

import nl.mawoo.jerome.engine.BootLoader;
import nl.mawoo.jerome.protocol.MawStreamHandlerFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;

/**
 * Jerome - Connector Framework
 * The last data source you'll ever need.
 *
 * This framework is build to have many connections as one data source
 */
public class Framework {
    private static Logger logger = Logger.getLogger(Framework.class);

    public static void main(String[] args) throws IOException {
        logger.info("Mawoo Jerome (c) 2017");
        logger.info("----------------------------------");
        logger.info("Booting up");
        logger.info("initialize the injector");
        logger.info("Starting bootloader");
        BootLoader bootLoader = new BootLoader();
        bootLoader.setPackageLocation("nl.mawoo.jerome");
        bootLoader.pluginLoader();
        bootLoader.scanPlugins();
        logger.info("Add protocol to system..");
        URL.setURLStreamHandlerFactory(new MawStreamHandlerFactory(bootLoader.getPluginMap()));
        bootLoader.run();
    }
}
