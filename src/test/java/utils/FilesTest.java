package utils;

import nl.mawoo.jerome.connectors.utils.Files;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class FilesTest {
    private Logger logger = Logger.getLogger(FilesTest.class);

    @Test
    public void extractFilenameTest() {
        String filepath = "/path/to/document.txt";
        String[] exploded = Files.getPathFromFull(filepath);
        Assert.assertEquals("/path/to/", exploded[0]);
        Assert.assertEquals("document.txt", exploded[1]);
    }

    @Test
    public void extractPathTest() {
        String filepath = "/path/to/";
        String[] exploded = Files.getPathFromFull(filepath);
        logger.info(exploded[0]);
        Assert.assertEquals("/path/to/", exploded[0]);
    }

    @Test
    public void noPathTest() {
        String filepath = "/path";
        String[] exploded = Files.getPathFromFull(filepath);
        Assert.assertEquals("/path", exploded[0]);
    }
}