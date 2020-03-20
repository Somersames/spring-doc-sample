package xyz.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class ConfigA {
    @Bean
    @ConditionalOnMissingBean(ConfigFactory.class)
    public ConfigFactoryA configFactory(){
        System.out.println("ConfigA");
        return new ConfigFactoryA();
    }

    public void te(){
        System.out.println("ConfigA");
    }
}
