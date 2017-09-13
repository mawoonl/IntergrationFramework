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
