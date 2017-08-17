package nl.mawoo.jerome.api.configuration;

import nl.mawoo.jerome.Framework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EngineConfig {

    @Bean
    public Framework framework() {
        Framework framework = new Framework("");
        return framework;
    }
}
