package nl.mawoo.jerome.engine;

import java.util.Map;

public interface PluginLoaderInterface {

    void loadPlugins();

    Map<String, Plugin> getPluginMap();

}
