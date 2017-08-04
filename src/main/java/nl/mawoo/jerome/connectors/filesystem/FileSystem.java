package nl.mawoo.jerome.connectors.filesystem;

import nl.mawoo.jerome.engine.Plugin;
import nl.mawoo.jerome.model.DefaultModel;
import nl.mawoo.jerome.model.MainDataModel;
import org.apache.log4j.Logger;

public class FileSystem extends Plugin {

    private Logger logger = Logger.getLogger(FileSystem.class);
    private String path;

    public FileSystem() {
        super("filesystem", "C:/", "Native file system of current terminal");
    }

    @Override
    public MainDataModel query(String path, String query) {
        this.path = path;
        return new DefaultModel(this.getName(), "random document at: " + path);
    }

}
