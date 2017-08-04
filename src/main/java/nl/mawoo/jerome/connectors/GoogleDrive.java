package nl.mawoo.jerome.connectors;

import nl.mawoo.jerome.engine.Plugin;
import nl.mawoo.jerome.model.DefaultModel;
import nl.mawoo.jerome.model.MainDataModel;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GoogleDrive extends Plugin {
    private Logger logger = Logger.getLogger(GoogleDrive.class);
    public GoogleDrive() {
        super("google-drive", "https://drive.google.com", "Part of google apps.");
    }

    @Override
    public List<MainDataModel> query(String path, String query) {
        logger.info("I got: "+ path +" 000 "+ query);
        List<MainDataModel> mainDataModels = new ArrayList<>();
        DefaultModel model = new DefaultModel(this.getName(), "random google document");
        mainDataModels.add(model);
        return mainDataModels;
    }
}
