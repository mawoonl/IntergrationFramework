package nl.mawoo.jerome.api;

import com.google.gson.Gson;
import nl.mawoo.jerome.Framework;
import nl.mawoo.jerome.model.MainDataModel;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class Api {
    private static Logger logger = Logger.getLogger(Api.class);

    public static void main(String[] args) {
        Framework framework = new Framework("");
        Scanner in = new Scanner(System.in);
        logger.info("ready for input");
        while(in.hasNext()) {
            String input = in.next();
            List<MainDataModel> model = framework.run(input);
            logger.info(new Gson().toJson(model));
        }
    }
}
