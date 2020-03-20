package xyz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.core.RedisService;

@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @GetMapping(value = "redis/str")
    public void test(){
     redisService.setString("ad");
    }
}
