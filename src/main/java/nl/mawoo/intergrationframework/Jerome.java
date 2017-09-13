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
package nl.mawoo.intergrationframework;

import nl.mawoo.intergrationframework.engine.BootLoader;
import nl.mawoo.intergrationframework.engine.Engine;
import nl.mawoo.intergrationframework.model.MainDataModel;
import nl.mawoo.intergrationframework.protocol.Protocol;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Jerome - Connector Jerome
 * The last data source you'll ever need.
 * <p>
 * This framework is build to have many connections as one data source
 */
public class Jerome {

    private static Logger logger = Logger.getLogger(Jerome.class);
    private BootLoader bootLoader;


    /**
     * Boot up the application.
     * Initializes bootloader and scans plugins on startup.
     *
     * @param packageLocation can be an empty String
     */
    public Jerome(String packageLocation) {
        // awesome logger header
        System.out.println("    __  ___                                  __                             \n" +
                "   /  |/  /___ __      ______  ____         / /__  _________  ____ ___  ___ \n" +
                "  / /|_/ / __ `/ | /| / / __ \\/ __ \\   __  / / _ \\/ ___/ __ \\/ __ `__ \\/ _ \\\n" +
                " / /  / / /_/ /| |/ |/ / /_/ / /_/ /  / /_/ /  __/ /  / /_/ / / / / / /  __/\n" +
                "/_/  /_/\\__,_/ |__/|__/\\____/\\____/   \\____/\\___/_/   \\____/_/ /_/ /_/\\___/ \n" +
                "                                                                            ");
        logger.info("Booting up");
        logger.info("initialize the injector");
        logger.info("Starting bootloader");
        this.bootLoader = new BootLoader();
        bootLoader.setPackageLocation(packageLocation);
        bootLoader.pluginLoader();
        bootLoader.scanPlugins();
    }

    /**
     * This method will get the information that you want
     * @param url url that you want to visit to get a document
     * @return List of main data models. Every model that is implemented into the system.
     */
    public List<MainDataModel> run(String url) {
        logger.info("Incoming request: "+ url);
        Protocol protocol = new Protocol(url);
        Engine engine = new Engine(protocol.getCurrentQuery(), bootLoader.getPluginMap());
        List<MainDataModel> model = engine.run();
        logger.info("Request handled");
        return model;
    }
}
