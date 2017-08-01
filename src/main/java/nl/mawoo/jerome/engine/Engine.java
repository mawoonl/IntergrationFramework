package nl.mawoo.jerome.engine;

import com.google.inject.Inject;
import nl.mawoo.jerome.protocol.CurrentQuery;
import org.apache.log4j.Logger;

import java.util.Map;

public class Engine {
    private Logger logger = Logger.getLogger(Engine.class);

    private CurrentQuery currentQuery;
    private PluginLoaderService loaderService;

    @Inject
    public void setLoaderService(PluginLoaderService loaderService) {
        this.loaderService = loaderService;
    }

    public Engine(CurrentQuery currentQuery) {
        this.currentQuery = currentQuery;
    }

    /**
     * This method runs the engine it self. Runs the selected plugins and passes on information that the plugins need
     * to function.
     */
    public void run() {
        Map<String, Plugin> pluginMap = loaderService.getPluginMap();
        for (Object o : pluginMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Plugin plugin = (Plugin) entry.getValue();
            logger.info(plugin.getName());
        }
    }
}
