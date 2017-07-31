package nl.mawoo.jerome.connectors;

import nl.mawoo.jerome.engine.Plugin;
import nl.mawoo.jerome.model.MainDataModel;

public class GoogleDrive extends Plugin {
    public GoogleDrive() {
        super("Google Drive", "https://drive.google.com", "Part of google apps.");
    }

    @Override
    public MainDataModel query(String query, String[] params) {
        return null;
    }
}
