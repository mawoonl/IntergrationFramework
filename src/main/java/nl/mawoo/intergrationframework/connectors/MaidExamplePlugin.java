package nl.mawoo.intergrationframework.connectors;

import nl.mawoo.intergrationframework.engine.Plugin;
import nl.mawoo.intergrationframework.model.DefaultModel;
import nl.mawoo.intergrationframework.model.MainDataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a plugin to show as a example.
 * <p>
 * You extend the Plugin class and fill the super with information about the source that you are integrating
 */
public class MaidExamplePlugin extends Plugin {
    /**
     * This class defines a plugin and gives information about the plugin
     * The super params
     * @param name        The name of the plugin. It cannot contain the "+" character.
     * @param sourceUrl   Source URL that is used to find more information about the actual source
     * @param description Simple description of the plugin it self about the source and what it does.
     */
    public MaidExamplePlugin() {
        super("exampe-plugin", "http://yourdomain.com/", "Example plugin on how to implement sources and use this framework.");
    }

    /**
     * In this class arrives the search query url.
     *
     * @param path  The path retrieved from the url
     * @param query URL query parameters
     * @return The model that the framework will be returning
     */
    @Override
    public List<MainDataModel> query(String path, String query) {
        List<MainDataModel> output = new ArrayList<>();
        // Here I create a new DefaultModel the model implements the MainDataModel so we can use it to output information
        DefaultModel defaultModel = new DefaultModel(this.getName(), "requested path:"+ path, "query:"+ query);
        output.add(defaultModel);
        return output;
    }
}
