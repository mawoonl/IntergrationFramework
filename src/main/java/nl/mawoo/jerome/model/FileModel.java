package nl.mawoo.jerome.model;

import java.util.Date;

public class FileModel implements MainDataModel {
    private String fileName;
    private String extension;
    private String author;
    private double size;
    private Date lastModified;


    public FileModel(String fileName, String extension, String author, double size, Date lastModified) {
        this.fileName = fileName;
        this.extension = extension;
        this.author = author;
        this.size = size;
        this.lastModified = lastModified;
    }

    public String getFileName() {
        return fileName;
    }

    public String getExtension() {
        return extension;
    }

    public String getAuthor() {
        return author;
    }

    public double getSize() {
        return size;
    }

    public Date getLastModified() {
        return lastModified;
    }
}
