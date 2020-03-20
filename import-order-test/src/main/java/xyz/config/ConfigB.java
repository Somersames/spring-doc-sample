package xyz.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class ConfigB {

    @Bean
    @ConditionalOnMissingBean(ConfigFactory.class)
    public ConfigFactoryB configFactory(){
        System.out.println("ConfigB");
        return new ConfigFactoryB();
    }

    public void te(){
        System.out.println("ConfigB");
    }
}
