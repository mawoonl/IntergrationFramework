package nl.mawoo.jerome.api;

import com.google.gson.Gson;
import nl.mawoo.jerome.Framework;
import nl.mawoo.jerome.model.MainDataModel;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import java.util.List;

@SpringBootApplication(exclude = {MongoRepositoriesAutoConfiguration.class, MongoDataAutoConfiguration.class,
        MongoAutoConfiguration.class})
public class Api {
    private static Logger logger = Logger.getLogger(Api.class);

    public static void main(String[] args) {
        SpringApplication.run(Api.class);
        Framework framework = new Framework("");
        framework.registerProtocol();
        List<MainDataModel> mainDataModel = framework.run("maid://google-drive/msdk");
    }
}
