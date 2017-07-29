package nl.mawoo.jerome.engine;

import nl.mawoo.jerome.model.MainDataModel;

/**
 * This interface defines a plugin.
 */
public interface PluginInterface {
    MainDataModel query(String query, String[] params);
}
