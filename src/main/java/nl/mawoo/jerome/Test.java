package nl.mawoo.jerome;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Test {
    private static Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) {
        Framework framework = new Framework("nl.mawoo.jerome");
        Scanner in = new Scanner(System.in);
        logger.info("Ready for input");
        while (in.hasNext()) {
            String input = in.next();
            framework.run(input);
        }
    }
}
