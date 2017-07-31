package nl.mawoo.jerome;

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

        logger.info("Scanning for plugins");
        PluginLoader loader = new PluginLoader("");
        Map<String, Plugin> pluginMap = loader.mapPlugins();
        for(Object o : pluginMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Plugin plugin = (Plugin) entry.getValue();
            logger.info("plugin: "+ plugin.getName() +" - "+ plugin.getDescription());
        }


        Scanner in = new Scanner(System.in);
        logger.info("Ready for input");
        while(in.hasNext()) {
            String input = in.next();
            visitUrl(input);
        }

    }

    private static void visitUrl(String url) throws IOException {
        try {
            URLConnection connection = new URL(url).openConnection();
            connection.connect();
        } catch (MalformedURLException ex) {
            logger.error("protocol not recognised.", ex);
        }

    }
}
