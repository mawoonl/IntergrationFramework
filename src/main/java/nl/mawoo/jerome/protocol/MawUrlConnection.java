package nl.mawoo.jerome.protocol;

import nl.mawoo.jerome.engine.Engine;
import nl.mawoo.jerome.engine.Plugin;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class MawUrlConnection extends URLConnection {
    private Logger logger = Logger.getLogger(MawUrlConnection.class);
    private Map<String, Plugin> pluginMap;

    public MawUrlConnection(URL url, Map<String, Plugin> pluginMap) {
        super(url);
        this.pluginMap = pluginMap;
    }

    MawUrlConnection(URL url) {
        super(url);
    }

    @Override
    public void connect() throws IOException {
        logger.info("Started request");
        Protocol protocol = new Protocol(url);
        CurrentQuery query = new CurrentQuery(protocol.getSelectedPlugins(), url.getPath(), url.getQuery());
        Engine engine = new Engine(query, pluginMap);
        engine.run();
    }


}
