package nl.mawoo.jerome.model;

import java.nio.file.attribute.FileTime;

public class FileModel implements MainDataModel {
    private String fileName;
    private boolean isDirectory;
    private FileTime lastModified;
    private FileTime creationDate;


    public FileModel(String name, boolean isDirectory, FileTime lastModified, FileTime creationDate) {
        this.fileName = name;
        this.isDirectory = isDirectory;
        this.lastModified = lastModified;
        this.creationDate = creationDate;
    }

    public String getFileName() {
        return fileName;
    }
    
    public boolean isDirectory() {
        return isDirectory;
    }

    public FileTime getLastModified() {
        return lastModified;
    }

    public FileTime getCreationDate() {
        return creationDate;
    }
}
