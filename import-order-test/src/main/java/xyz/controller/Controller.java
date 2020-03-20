package xyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.config.ConfigA;
import xyz.config.ConfigB;
import xyz.config.ConfigFactoryA;
import xyz.config.ConfigFactoryB;

@RestController
public class Controller {

    @Autowired
    ConfigFactoryB configB;

    @GetMapping("/test/config")
    public void test(){
        configB.te();
    }
}
