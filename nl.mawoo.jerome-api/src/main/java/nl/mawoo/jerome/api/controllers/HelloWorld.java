package nl.mawoo.jerome.api.controllers;

import com.google.gson.Gson;
import nl.mawoo.jerome.Framework;
import nl.mawoo.jerome.api.configuration.EngineConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloWorld {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        Framework framework = engineConfig.framework();
        return new Gson().toJson(framework.run("maid://filesystem/home/"));
    }

    @Autowired
    private EngineConfig engineConfig;
}
