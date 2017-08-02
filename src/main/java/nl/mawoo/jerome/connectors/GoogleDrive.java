package nl.mawoo.jerome.connectors;

import nl.mawoo.jerome.engine.Plugin;
import nl.mawoo.jerome.model.DefaultModel;
import nl.mawoo.jerome.model.MainDataModel;
import org.apache.log4j.Logger;

public class GoogleDrive extends Plugin {
    private Logger logger = Logger.getLogger(GoogleDrive.class);
    public GoogleDrive() {
        super("google-drive", "https://drive.google.com", "Part of google apps.");
    }

    @Override
    public MainDataModel query(String path, String query) {
        logger.info("I got: "+ path +" 000 "+ query);
        return new DefaultModel(this.getName(), "random google document");
    }
}
