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

import nl.mawoo.intergrationframework.model.MainDataModel;

import java.util.List;

/**
 * This interface defines a plug-in.
 *
 * Don't look here to create a plug-in. Extend the abstract Plugin class to make sure your plug-in is loaded into the framework.
 */
public interface PluginInterface {
    /**
     * In this class arrives the search query url.
     * @param path The path retrieved from the url
     * @param query URL query parameters
     * @return The model that the framework will be returning
     */
    List<MainDataModel> query(String path, String query);
}
