import nl.mawoo.jerome.engine.Plugin;
import nl.mawoo.jerome.engine.PluginLoader;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class PluginLoaderTest {
    private static Logger logger = Logger.getLogger(PluginLoaderTest.class);

    /**
     * Test if the plugin mapper works
     */
    @Test
    public void pluginMapperTest() {
        PluginLoader loader = new PluginLoader("nl.mawoo.jerome.connectors");
        for (Object o : loader.mapPlugins().entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Plugin plugin = (Plugin) entry.getValue();
            logger.info(plugin.getName());
            logger.info(plugin.getSourceUrl());
            logger.info(plugin.getDescription());
        }
    }

    /**
     * Get a plugin from a name(String)
     */
    @Test
    public void getPluginFromMapper() {
        PluginLoader loader = new PluginLoader("nl.mawoo.jerome.connectors");
        Map<String, Plugin> map = loader.mapPlugins();

        Plugin plugin = map.get("filesystem");
        Assert.assertEquals("filesystem", plugin.getName());
    }
}
