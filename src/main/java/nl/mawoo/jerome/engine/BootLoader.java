package nl.mawoo.jerome.engine;

import java.util.Map;

public class BootLoader {
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

    public Map<String, Plugin> getPluginMap() {
        return pluginMap;
    }

    private void setPluginMap(Map<String, Plugin> pluginMap) {
        this.pluginMap = pluginMap;
    }
}
