package nl.mawoo.jerome.connectors;

import nl.mawoo.jerome.engine.Plugin;
import nl.mawoo.jerome.model.DefaultModel;
import nl.mawoo.jerome.model.MainDataModel;

public class FileSystem extends Plugin {

    public FileSystem() {
        super("filesystem", "C:/", "Native file system of current terminal");
    }

    @Override
    public MainDataModel query(String query, String[] params) {
        return new DefaultModel();
    }
}
