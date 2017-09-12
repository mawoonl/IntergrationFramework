import nl.mawoo.intergrationframework.engine.Plugin;
import nl.mawoo.intergrationframework.engine.PluginLoader;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Map;

/**
 * Map all plug-ins to see if the mapper is working.
 */
public class PluginLoaderTest {

    private static Logger logger = Logger.getLogger(PluginLoaderTest.class);

    /**
     * Test if the plugin mapper works
     */
    @Test
    public void pluginMapperTest() {
        PluginLoader loader = new PluginLoader("nl.mawoo.intergrationframework.connectors");
        for (Object o : loader.mapPlugins().entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Plugin plugin = (Plugin) entry.getValue();
            logger.info(plugin.getName());
            logger.info(plugin.getSourceUrl());
            logger.info(plugin.getDescription());
        }
    }
}
