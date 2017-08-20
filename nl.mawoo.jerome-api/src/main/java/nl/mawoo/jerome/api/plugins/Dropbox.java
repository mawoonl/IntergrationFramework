package nl.mawoo.jerome.api.plugins;

import nl.mawoo.jerome.engine.Plugin;
import nl.mawoo.jerome.model.DefaultModel;
import nl.mawoo.jerome.model.MainDataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Just an example on how to load external plugins.
 */
public class Dropbox extends Plugin{

    /**
     * This class defines a plugin and gives information about the plugin
     */
    public Dropbox() {
        super("dropbox", "http://dropbox.com", "Cloud storage");
    }

    @Override
    public List<MainDataModel> query(String path, String query) {
        List<MainDataModel> dataModels = new ArrayList<>();
        dataModels.add(new DefaultModel("dropbox", path));
        return dataModels;
    }
}
