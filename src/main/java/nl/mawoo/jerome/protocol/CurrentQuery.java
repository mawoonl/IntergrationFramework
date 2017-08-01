package nl.mawoo.jerome.protocol;

public class CurrentQuery {
    private String[] plugins;
    private String path;
    private String params;

    public CurrentQuery(String[] plugins, String path, String params) {
        this.plugins = plugins;
        this.path = path;
        this.params = params;
    }

    public String[] getPlugins() {
        return plugins;
    }

    public String getPath() {
        return path;
    }

    public String getParams() {
        return params;
    }
}
