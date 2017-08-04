package nl.mawoo.jerome.connectors.filesystem;

import nl.mawoo.jerome.engine.Plugin;
import nl.mawoo.jerome.model.DefaultModel;
import nl.mawoo.jerome.model.MainDataModel;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FileSystem extends Plugin {

    private Logger logger = Logger.getLogger(FileSystem.class);
    private String path;

    public FileSystem() {
        super("filesystem", "C:/", "Native file system of current terminal");
    }

    @Override
    public List<MainDataModel> query(String path, String query) {
        this.path = path;
        DefaultModel defaultModel = new DefaultModel(this.getName(), "random document at: " + path);
        List<MainDataModel> defaultModels = new ArrayList<>();
        defaultModels.add(defaultModel);
        return defaultModels;
    }


}
