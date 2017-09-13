/**
 * Copyright 2017 Mawoo Nederland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
