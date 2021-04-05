package xyz.somersames.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.somersames.anno.DecryptInfo;
import xyz.somersames.entity.Advice;

@RestController
@RequestMapping("controller")
public class RestProductInfoController {

    @PostMapping("/advice/decrypt")
    @DecryptInfo
    public Advice testAdvice(@Validated @RequestBody Advice bodyAdvice){
        return bodyAdvice;
    }
}
