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
package nl.mawoo.intergrationframework.engine;

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
        for (Class<?> c : runReflections()) {
            try {
                Plugin o = (Plugin) c.newInstance();
                logger.info("plugin found: "+ o.getName());
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
