import nl.mawoo.jerome.connectors.FileSystem;
import org.junit.Assert;
import org.junit.Test;

public class FileSystemConnectorTest {

    @Test
    public void readValues() {
        FileSystem fileSystem = new FileSystem();
        Assert.assertEquals("filesystem", fileSystem.getName());
        Assert.assertEquals("C:/", fileSystem.getSourceUrl());
        Assert.assertEquals("Native file system of current terminal", fileSystem.getDescription());
    }
}
