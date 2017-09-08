import nl.mawoo.intergrationframework.protocol.CurrentQuery;
import nl.mawoo.intergrationframework.protocol.Protocol;
import org.junit.Assert;
import org.junit.Test;

public class ProtocolTest {

    @Test
    public void uriTest() {
        Protocol protocol = new Protocol("maid://filesystem+google-drive/path/to/file?query=test&bool=true");
        CurrentQuery query = protocol.getCurrentQuery();
        Assert.assertEquals("/path/to/file", query.getPath());
        Assert.assertEquals("filesystem", query.getPlugins()[0]);
    }

}
