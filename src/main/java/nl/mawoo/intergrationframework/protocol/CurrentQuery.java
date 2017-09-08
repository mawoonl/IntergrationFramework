package nl.mawoo.intergrationframework.protocol;

public class CurrentQuery {
    private String[] plugins;
    private String path;
    private String query;

    public CurrentQuery(String[] plugins, String path, String query) {
        this.plugins = plugins;
        this.path = path;
        this.query = query;
    }

    public String[] getPlugins() {
        return plugins;
    }

    public String getPath() {
        return path;
    }

    public String getQuery() {
        return query;
    }
}
