package nl.mawoo.intergrationframework.engine;

import nl.mawoo.intergrationframework.model.MainDataModel;

import java.util.List;

/**
 * This interface defines a plugin.
 */
public interface PluginInterface {
    List<MainDataModel> query(String path, String query);
}
