package nl.mawoo.jerome.protocol;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * StreamHandler for custom web protocol so we can browse through files and other types of content
 */
public class MawStreamHandlerFactory implements URLStreamHandlerFactory {
    @Override
    public URLStreamHandler createURLStreamHandler(String s) {
        if("maw".equals(s)) {
            return new MawStreamHandler();
        }
        return null;
    }
}
