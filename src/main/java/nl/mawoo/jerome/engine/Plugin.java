package nl.mawoo.jerome.engine;


public abstract class Plugin implements PluginInterface {

    private final String name;
    private final String sourceUrl;
    private final String description;

    public Plugin(String name, String sourceUrl, String description) {
        this.name = name;
        this.sourceUrl = sourceUrl;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getDescription() {
        return description;
    }
}
