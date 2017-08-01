package nl.mawoo.jerome.engine;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Scanner;

public class BootLoader {
    private Logger logger = Logger.getLogger(BootLoader.class);

    private String packageLocation;
    private PluginLoaderService loaderService;
    private Injector injector;
    private Map<String, Plugin> pluginMap;

//    @Inject
//    public BootLoader(PluginLoaderService loaderService, Injector injector) {
//        this.loaderService = loaderService;
//        this.injector = injector;
//    }

    public void setPackageLocation(String packageLocation) {
        this.packageLocation = packageLocation;
    }

    public void pluginLoader() {
        loaderService = new PluginLoaderService();
        loaderService.setPackageLocation(packageLocation);
        loaderService.loadPlugins();
    }

    public void scanPlugins() {
        this.setPluginMap(loaderService.getPluginMap());
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        logger.info("Ready for input");
        while(in.hasNext()) {
            String input = in.next();
            try {
                visitUrl(input);
            } catch (IOException e) {
                logger.error("Something went wrong", e);
            }
        }
    }

    private void visitUrl(String url) throws IOException {
        try {
            URLConnection connection = new URL(url).openConnection();
            connection.connect();
        } catch (MalformedURLException ex) {
            logger.error("protocol not recognised.", ex);
        }

    }

    public Map<String, Plugin> getPluginMap() {
        return pluginMap;
    }

    private void setPluginMap(Map<String, Plugin> pluginMap) {
        this.pluginMap = pluginMap;
    }
}
