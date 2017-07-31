package nl.mawoo.jerome;

import com.google.inject.Guice;
import com.google.inject.Injector;
import nl.mawoo.jerome.engine.AppInjector;
import nl.mawoo.jerome.engine.BootLoader;
import nl.mawoo.jerome.engine.Plugin;
import nl.mawoo.jerome.engine.PluginLoader;
import nl.mawoo.jerome.protocol.MawStreamHandlerFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Scanner;

/**
 * Jerome - Connector Framework
 * The last data source you'll ever need.
 *
 * This framework is build to have many connections as one data source
 */
public class Framework {
    private static Logger logger = Logger.getLogger(Framework.class);

    public static void main(String[] args) throws IOException {
        logger.info("Mawoo Connector framework (c) 2017");
        logger.info("----------------------------------");
        logger.info("Booting up");
        logger.info("Add protocol to system..");
        URL.setURLStreamHandlerFactory(new MawStreamHandlerFactory());

        logger.info("initialize the injector");
        Injector injector = Guice.createInjector(new AppInjector());
        logger.info("Starting bootloader");
        BootLoader bootLoader = injector.getInstance(BootLoader.class);
        bootLoader.setPackageLocation("nl.mawoo.jerome.connectors");
        bootLoader.run();
    }
}
