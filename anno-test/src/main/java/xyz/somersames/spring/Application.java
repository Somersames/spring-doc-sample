package xyz.somersames.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.somersames.anno.EnableLog;

/**
 * @author somersames
 */
@SpringBootApplication
@EnableLog
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
