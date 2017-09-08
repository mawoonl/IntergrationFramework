package nl.mawoo.intergrationframework.model;

public class DefaultModel implements MainDataModel {

    private String _source;
    private String title;
    private String content;

    public DefaultModel(String _source, String title, String content) {
        this._source = _source;
        this.title = title;
        this.content = content;
    }

    /**
     * The plug-in that is using this model.
     * @return String with source(plug-in) name
     */
    public String get_source() {
        return _source;
    }

    /**
     * Get the name of a item
     * @return String name of item
     */
    public String getName() {
        return title;
    }

    /**
     * Get content from plug-in
     * @return String data content
     */
    public String getContent() {
        return content;
    }
}
