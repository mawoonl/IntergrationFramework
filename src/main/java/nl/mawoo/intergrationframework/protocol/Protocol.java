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
package nl.mawoo.intergrationframework.protocol;

import org.apache.log4j.Logger;

import java.net.URI;

/**
 * This is the second version of the protocol.
 * This time we won't be using
 */
public class Protocol {
    private URI incoming;
    private Logger logger = Logger.getLogger(Protocol.class);

    public Protocol(String incoming) {
        this.incoming = URI.create(incoming);
    }

    private String[] getPlugins() {
       return incoming.getAuthority().split("\\+");
    }

    private String getPath() {
        return incoming.getPath();
    }

    private String getQuery() {
        return incoming.getQuery();
    }

    public CurrentQuery getCurrentQuery() {
        return new CurrentQuery(getPlugins(), getPath(), getQuery());
    }
}
