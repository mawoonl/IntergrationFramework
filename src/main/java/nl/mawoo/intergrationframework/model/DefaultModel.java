package nl.mawoo.intergrationframework.model;

public class DefaultModel implements MainDataModel {
    private String _source;
    private String title;

    public DefaultModel(String _source, String title) {
        this._source = _source;
        this.title = title;
    }

    public String get_source() {
        return _source;
    }

    public String getTitle() {
        return title;
    }
}
