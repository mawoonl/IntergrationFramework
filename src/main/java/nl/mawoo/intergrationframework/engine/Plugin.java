package nl.mawoo.intergrationframework.engine;


public abstract class Plugin implements PluginInterface {

    private final String name;
    private final String sourceUrl;
    private final String description;

    /**
     * This class defines a plugin and gives information about the plugin
     * @param name The name of the plugin. It cannot contain the "-" character.
     * @param sourceUrl Source URL that is used to find more information about the actual source
     * @param description Simple description of the plugin it self about the source and what it does.
     */
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
