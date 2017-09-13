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
package nl.mawoo.intergrationframework.model;

public class DefaultModel implements MainDataModel {

    private String _source;
    private String title;
    private String content;

    public DefaultModel(String _source, String title, String content) {
        this._source = _source;
        this.title = title;
        this.content = content;
    }

    /**
     * The plug-in that is using this model.
     * @return String with source(plug-in) name
     */
    public String get_source() {
        return _source;
    }

    /**
     * Get the name of a item
     * @return String name of item
     */
    public String getName() {
        return title;
    }

    /**
     * Get content from plug-in
     * @return String data content
     */
    public String getContent() {
        return content;
    }
}
