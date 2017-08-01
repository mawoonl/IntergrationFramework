package nl.mawoo.jerome.protocol;

import java.net.URL;

public class Protocol {
    private URL url;

    public Protocol(URL url) {
        this.url = url;
    }

    /**
     * Get every plugin name that the
     * @return String array with plugins that are requested
     */
    String[] getSelectedPlugins() {
        return url.getHost().split("\\+");
    }
}
