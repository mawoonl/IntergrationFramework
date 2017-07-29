package nl.mawoo.jerome.protocol;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class MawUrlConnection extends URLConnection {
    private Logger logger = Logger.getLogger(MawUrlConnection.class);

    protected MawUrlConnection(URL url) {
        super(url);
    }

    @Override
    public void connect() throws IOException {
        logger.info("Connected");
        logger.info("Opening file: "+ url);
        logger.info("Using connector: \"filesystem\"");
        logger.info("Content: The quick brown fox jumps over the lazy dog.");
    }
}
