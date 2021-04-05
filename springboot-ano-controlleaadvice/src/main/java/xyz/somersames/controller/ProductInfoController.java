package xyz.somersames.controller;

import org.springframework.web.bind.annotation.*;
import xyz.somersames.entity.Advice;

@RestController
@RequestMapping("controller")
public class ProductInfoController {

    @PostMapping("/testAdvice")
    public String testAdvice(@RequestParam (name = "advice")Advice advice ,
                             @RequestBody Advice bodyAdvice){
        return advice.toString() + "body:" + bodyAdvice.toString();
    }

    @PostMapping("/testAdvice2")
    public String testAdvice2(Advice advice){
        return advice.toString();
    }
}
