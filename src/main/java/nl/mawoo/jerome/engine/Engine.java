package nl.mawoo.jerome.engine;

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
        for (Object o : pluginMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Plugin plugin = (Plugin) entry.getValue();
            logger.info(plugin.getName());
        }
    }
}
