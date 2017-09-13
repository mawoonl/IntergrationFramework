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
import nl.mawoo.intergrationframework.protocol.CurrentQuery;
import nl.mawoo.intergrationframework.protocol.Protocol;
import org.junit.Assert;
import org.junit.Test;

public class ProtocolTest {

    @Test
    public void uriTest() {
        Protocol protocol = new Protocol("maid://filesystem+google-drive/path/to/file?query=test&bool=true");
        CurrentQuery query = protocol.getCurrentQuery();
        Assert.assertEquals("/path/to/file", query.getPath());
        Assert.assertEquals("filesystem", query.getPlugins()[0]);
    }

}
