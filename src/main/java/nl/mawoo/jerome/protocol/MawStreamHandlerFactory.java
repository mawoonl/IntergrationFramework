package nl.mawoo.jerome.protocol;

import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * StreamHandler for custom web protocol so we can browse through files and other types of content
 */
public class MawStreamHandlerFactory implements URLStreamHandlerFactory {
    private Logger logger = Logger.getLogger(MawStreamHandlerFactory.class);

    @Override
    public URLStreamHandler createURLStreamHandler(String s) {
        return new MawStreamHandler();
    }
}
