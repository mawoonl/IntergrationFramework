package nl.mawoo.intergrationframework.engine;

import nl.mawoo.intergrationframework.model.MainDataModel;

import java.util.List;

/**
 * This interface defines a plug-in.
 *
 * Don't look here to create a plug-in. Extend the abstract Plugin class to make sure your plug-in is loaded into the framework.
 */
public interface PluginInterface {
    /**
     * In this class arrives the search query url.
     * @param path The path retrieved from the url
     * @param query URL query parameters
     * @return The model that the framework will be returning
     */
    List<MainDataModel> query(String path, String query);
}
