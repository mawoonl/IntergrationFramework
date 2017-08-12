package nl.mawoo.jerome;

import com.google.gson.Gson;
import nl.mawoo.jerome.model.MainDataModel;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class FrameworkCli {
    private static Logger logger = Logger.getLogger(FrameworkCli.class);

    public static void main(String[] args) {
        Framework framework = new Framework("");
        framework.registerProtocol();
        logger.info("Ready for input");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.next();
            List<MainDataModel> model = framework.run(input);
            logger.info(new Gson().toJson(model));
        }
    }
}
