package nl.mawoo.jerome.connectors.filesystem;

import nl.mawoo.jerome.engine.Plugin;
import nl.mawoo.jerome.model.FileModel;
import nl.mawoo.jerome.model.MainDataModel;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileSystem extends Plugin {

    private Logger logger = Logger.getLogger(FileSystem.class);
    private String[] path;
    private List<MainDataModel> defaultModels;

    public FileSystem() {
        super("filesystem", "C:/", "Native file system of current terminal");
        defaultModels  = new ArrayList<>();
    }

    @Override
    public List<MainDataModel> query(String rawPath, String query) {
        defaultModels.clear();
        this.path = nl.mawoo.jerome.connectors.utils.Files.getPathFromFull(rawPath);
        if (path[1].isEmpty()) {
            this.scanDirectory();
        } else {
            try {
                this.scanFile(rawPath);
            } catch (IOException e) {
                logger.error("unable to open file", e);
            }
        }
        return defaultModels;
    }

    /**
     * Scan a certain file in the directory
     */
    private void scanFile(String rawPath) throws IOException {
        Path file = Paths.get(rawPath);
        BasicFileAttributes fileAttributes = Files.readAttributes(file, BasicFileAttributes.class);
        FileModel model = new FileModel(file.getFileName().toString(), fileAttributes.isDirectory(), fileAttributes.lastModifiedTime(), fileAttributes.creationTime());
        defaultModels.add(model);
    }

    /**
     * Scan everything in a certain document.
     */
    private void scanDirectory() {
        File[] files = new File(path[0]).listFiles();
        for (File file : files) {
            try {
                this.scanFile(file.getPath());
            } catch (IOException e) {
                logger.error("can't get information about file", e);
            }
        }
    }
}
