package nl.mawoo.jerome.engine;

import nl.mawoo.jerome.connectors.FileSystem;
import org.apache.log4j.Logger;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Load custom connectors into the system
 */
public class PluginLoader {
    private Logger logger = Logger.getLogger(PluginLoader.class);

    private String packageLocation;

    public PluginLoader(String packageLocation) {
        this.packageLocation = packageLocation;
    }

    public Map<String, Plugin> mapPlugins() {
        Map<String, Plugin> map = new HashMap<>();
        int i = 0;
        for (Class<?> c : runReflections()) {
            i++;
            try {
                Plugin o = (Plugin) c.newInstance();
                map.put(o.getName(), o);
            } catch (InstantiationException | IllegalAccessException e) {
                logger.error("Can't get instance of: "+ c.getName(), e);
            }
        }
        return map;
    }

    /**
     * Get all connectors
     * Connectors extends the plugin class
     * @return Set of classes that extends the plugin class
     */
    private Set<Class<? extends Plugin>> runReflections() {
        Reflections reflections = new Reflections(packageLocation);
        return reflections.getSubTypesOf(Plugin.class);
    }
}
