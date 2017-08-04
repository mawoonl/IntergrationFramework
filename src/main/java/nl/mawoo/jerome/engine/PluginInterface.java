package nl.mawoo.jerome.engine;

import nl.mawoo.jerome.model.MainDataModel;

import java.util.List;

/**
 * This interface defines a plugin.
 */
public interface PluginInterface {
    List<MainDataModel> query(String path, String query);
}
