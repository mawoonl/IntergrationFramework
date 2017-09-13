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

import com.google.gson.Gson;
import nl.mawoo.intergrationframework.model.MainDataModel;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class FrameworkCli {
    private static Logger logger = Logger.getLogger(FrameworkCli.class);

    public static void main(String[] args) {
        Jerome jerome = new Jerome("");
        logger.info("Ready for input");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.next();
            List<MainDataModel> model = jerome.run(input);
            logger.info(new Gson().toJson(model));
        }
    }
}
