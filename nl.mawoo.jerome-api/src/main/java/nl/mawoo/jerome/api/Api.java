package nl.mawoo.jerome.api;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoRepositoriesAutoConfiguration.class, MongoDataAutoConfiguration.class,
        MongoAutoConfiguration.class})
public class Api {
    private static Logger logger = Logger.getLogger(Api.class);

    public static void main(String[] args) {
        SpringApplication.run(Api.class);
    }
}
