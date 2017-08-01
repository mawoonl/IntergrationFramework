package nl.mawoo.jerome.protocol;

import nl.mawoo.jerome.engine.Engine;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class MawUrlConnection extends URLConnection {
    private Logger logger = Logger.getLogger(MawUrlConnection.class);

    MawUrlConnection(URL url) {
        super(url);
    }

    @Override
    public void connect() throws IOException {
        logger.info("Started request");
        Protocol protocol = new Protocol(url);
        CurrentQuery query = new CurrentQuery(protocol.getSelectedPlugins(), url.getPath(), url.getQuery());
        Engine engine = new Engine(query);
        engine.run();
    }


}
