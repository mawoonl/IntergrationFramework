package nl.mawoo.jerome.api.plugins;

import nl.mawoo.jerome.engine.Plugin;
import nl.mawoo.jerome.model.DefaultModel;
import nl.mawoo.jerome.model.MainDataModel;

import java.util.ArrayList;
import java.util.List;

public class Dropbox extends Plugin{

    /**
     * This class defines a plugin and gives information about the plugin
     *
     * @param name        The name of the plugin. It cannot contain the "-" character.
     * @param sourceUrl   Source URL that is used to find more information about the actual source
     * @param description Simple description of the plugin it self about the source and what it does.
     */
    public Dropbox(String name, String sourceUrl, String description) {
        super(name, sourceUrl, description);
    }

    @Override
    public List<MainDataModel> query(String path, String query) {
        List<MainDataModel> dataModels = new ArrayList<>();
        dataModels.add(new DefaultModel("dropbox", path));
        return dataModels;
    }
}
