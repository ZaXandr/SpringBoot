package com.zakharov.propertiesHW.configuration;

import com.zakharov.propertiesHW.logger.DevLogger;
import com.zakharov.propertiesHW.logger.Logger;
import com.zakharov.propertiesHW.logger.ProdLogger;
import com.zakharov.propertiesHW.logger.TestLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringProjectConfiguration {

    @Value("${environment}")
    private String env;

    @Bean
    public Logger logger() {
        switch (env) {
            case "dev":
                return new DevLogger();
            case "test":
                return new TestLogger();
            default:
                return new ProdLogger();
        }
    }
}
