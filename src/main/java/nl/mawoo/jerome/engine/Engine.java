package nl.mawoo.jerome.engine;

import com.google.gson.Gson;
import nl.mawoo.jerome.model.MainDataModel;
import nl.mawoo.jerome.protocol.CurrentQuery;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Engine {
    private Logger logger = Logger.getLogger(Engine.class);

    private CurrentQuery currentQuery;
    private Map<String, Plugin> pluginMap;

    /**
     * This engine is responsible to run plugins and return the information given by the plugins
     *
     * @param currentQuery query that is requested for the plugins
     * @param pluginMap    every plugin available in the system
     */
    public Engine(CurrentQuery currentQuery, Map<String, Plugin> pluginMap) {
        this.currentQuery = currentQuery;
        this.pluginMap = pluginMap;
    }

    /**
     * This method runs the engine it self. Runs the selected plugins and passes on information that the plugins need
     * to function.
     */
    public void run() {
        logger.info("engine started");
        List<List<MainDataModel>> models = new ArrayList<>();
        for (String plugin : currentQuery.getPlugins()) {
            Plugin plugin1 = pluginMap.get(plugin);
            List<MainDataModel> model = plugin1.query(currentQuery.getPath(), currentQuery.getQuery());
            models.add(model);
        }
        String json = this.formatData(models);
        logger.info("output: "+ json);
    }

    /**
     * Format data from all the plugins into one format.
     * @param allModels list returned by the plugins
     * @return String with JSON information
     */
    private String formatData(List<List<MainDataModel>> allModels) {
        List<MainDataModel> completeList = new ArrayList<>();
        for (List<MainDataModel> modelList : allModels) {
            if (modelList.size() <= 1) {
                completeList.add(modelList.get(0));
            } else {
                for (MainDataModel model : modelList) {
                    completeList.add(model);
                }
            }
        }
        return new Gson().toJson(completeList);
    }
}
