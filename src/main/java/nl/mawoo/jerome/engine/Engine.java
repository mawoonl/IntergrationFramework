package nl.mawoo.jerome.engine;

import com.google.gson.Gson;
import nl.mawoo.jerome.model.MainDataModel;
import nl.mawoo.jerome.protocol.CurrentQuery;
import org.apache.log4j.Logger;

import java.util.Map;

public class Engine {
    private Logger logger = Logger.getLogger(Engine.class);

    private CurrentQuery currentQuery;
    private Map<String, Plugin> pluginMap;


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
        logger.info("no plugins requested.");
        logger.info("request not handled");
        for (String plugin : currentQuery.getPlugins()) {
            Plugin plugin1 = pluginMap.get(plugin);
            MainDataModel model = plugin1.query(currentQuery.getPath(), currentQuery.getQuery());
            String output = new Gson().toJson(model);
            logger.info(output);
        }

    }
}
