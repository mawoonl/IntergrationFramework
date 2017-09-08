package nl.mawoo.intergrationframework.engine;

import java.util.Map;

public interface PluginLoaderInterface {

    void loadPlugins();

    Map<String, Plugin> getPluginMap();

}
