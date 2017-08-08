package nl.mawoo.jerome.engine;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class BootLoader {
    private Logger logger = Logger.getLogger(BootLoader.class);

    private String packageLocation;
    private PluginLoaderService loaderService;
    private Map<String, Plugin> pluginMap;

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

    /**
     * Visit the custom Mawoo URL
     *
     * @param url visisting address
     * @throws IOException
     */
    public void visitUrl(String url) throws IOException {
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
