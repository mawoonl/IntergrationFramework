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
