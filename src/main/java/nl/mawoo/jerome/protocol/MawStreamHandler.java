package nl.mawoo.jerome.protocol;

import com.google.inject.Injector;
import nl.mawoo.jerome.engine.Plugin;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Map;

public class MawStreamHandler extends URLStreamHandler {

    private final Map<String, Plugin> pluginMap;

    public MawStreamHandler(Map<String, Plugin> pluginMap) {
        this.pluginMap = pluginMap;
    }

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        return new MawUrlConnection(url, pluginMap);
    }
}
