package nl.mawoo.jerome.api.controllers;

import com.google.gson.Gson;
import nl.mawoo.jerome.api.configuration.EngineConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/filesystem")
public class FileSystem {

    @Autowired
    private EngineConfig engine;

    @RequestMapping(value = "/get", produces = "application/json")
    @ResponseBody
    public String getDirectory(@RequestParam("path") String path) {
        return new Gson().toJson(engine.framework().run("maid://filesystem"+ path));
    }
}
