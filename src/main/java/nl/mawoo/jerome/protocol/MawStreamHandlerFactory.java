package nl.mawoo.jerome.protocol;

import nl.mawoo.jerome.engine.Plugin;
import org.apache.log4j.Logger;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Map;

/**
 * StreamHandler for custom web protocol so we can browse through files and other types of content
 */
public class MawStreamHandlerFactory implements URLStreamHandlerFactory {
    private Logger logger = Logger.getLogger(MawStreamHandlerFactory.class);
    private Map<String, Plugin> pluginMap;

    public MawStreamHandlerFactory(Map<String, Plugin> pluginMap) {
        this.pluginMap = pluginMap;
    }

    @Override
    public URLStreamHandler createURLStreamHandler(String s) {
        if(s.equals("maid")) {
            return new MawStreamHandler(pluginMap);
        } else {
            logger.error("protocol not handled");
        }
        return null;
    }
}
