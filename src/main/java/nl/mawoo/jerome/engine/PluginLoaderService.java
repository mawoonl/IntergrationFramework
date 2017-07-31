package nl.mawoo.jerome.engine;

import com.google.inject.Singleton;
import org.apache.log4j.Logger;

import java.util.Map;

@Singleton
public class PluginLoaderService implements PluginLoaderInterface {
    private Logger logger = Logger.getLogger(PluginLoaderService.class);
    private Map<String, Plugin> pluginMap;
    private PluginLoader pluginLoader;

    public PluginLoaderService() {

    }

    public void setPackageLocation(String packageLocation) {
        pluginLoader = new PluginLoader(packageLocation);
    }

    @Override
    public void loadPlugins() {
        pluginMap = pluginLoader.mapPlugins();
    }

    @Override
    public Map<String, Plugin> getPluginMap() {
        return pluginMap;
    }
}
