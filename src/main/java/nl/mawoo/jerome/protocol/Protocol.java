package nl.mawoo.jerome.protocol;

import org.apache.log4j.Logger;

import java.net.URI;

/**
 * This is the second version of the protocol.
 * This time we won't be using
 */
public class Protocol {
    private URI incoming;
    private Logger logger = Logger.getLogger(Protocol.class);

    public Protocol(String incoming) {
        this.incoming = URI.create(incoming);
    }

    private String[] getPlugins() {
       return incoming.getAuthority().split("\\+");
    }

    private String getPath() {
        return incoming.getPath();
    }

    private String getQuery() {
        return incoming.getQuery();
    }

    public CurrentQuery getCurrentQuery() {
        return new CurrentQuery(getPlugins(), getPath(), getQuery());
    }
}
