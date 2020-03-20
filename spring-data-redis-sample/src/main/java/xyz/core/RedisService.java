package xyz.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    public void setString(String data){
        redisTemplate.opsForValue().set("abc","def");
    }
}
