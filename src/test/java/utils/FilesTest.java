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
package utils;

import nl.mawoo.intergrationframework.connectors.utils.Files;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class FilesTest {
    private Logger logger = Logger.getLogger(FilesTest.class);

    @Test
    public void extractFilenameTest() {
        String filepath = "/path/to/document.txt";
        String[] exploded = Files.getPathFromFull(filepath);
        Assert.assertEquals("/path/to/", exploded[0]);
        Assert.assertEquals("document.txt", exploded[1]);
    }

    @Test
    public void extractPathTest() {
        String filepath = "/path/to/";
        String[] exploded = Files.getPathFromFull(filepath);
        logger.info(exploded[0]);
        Assert.assertEquals("/path/to/", exploded[0]);
    }

    @Test
    public void noPathTest() {
        String filepath = "/path";
        String[] exploded = Files.getPathFromFull(filepath);
        Assert.assertEquals("/path", exploded[0]);
    }
}