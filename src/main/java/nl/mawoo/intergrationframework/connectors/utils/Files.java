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
package nl.mawoo.intergrationframework.connectors.utils;

import org.apache.log4j.Logger;

/**
 * In this package are classes that can are often helpful for developing plugins.
 *
 * This class helps extracting values from filepath and other types that are useful for getting information about
 * directories or files.
 */
public class Files {
    private static Logger logger = Logger.getLogger(Files.class);

    /**
     * If you have a path with filename this method will extract the file and the path separably.
     * @param path fullpath with filename. example: path/to/document.txt
     * @return String[] 0 = path, 1 = file
     */
    public static String[] getPathFromFull(String path) {
        int iDirectory = path.lastIndexOf("/");
        if(iDirectory == 0) {
            return new String[]{path};
        } else {
            return new String[]{path.substring(0, iDirectory+1), path.substring(iDirectory+1)};
        }
    }
}
