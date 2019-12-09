package xyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import xyz.model.User;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@ResponseBody
public class StartController {

    @Autowired
    MessageSource messageSource;

    @PostMapping(value = "test")
    public String testError(@Valid  @RequestBody User user ,Errors errors){
        if(errors.hasErrors()){
            for (ObjectError err : errors.getAllErrors()) {
                return err.getDefaultMessage();
            }
        }
        return "OK";
    }



    @PostMapping(value = "test/cn")
    public String testErrorCn(@Valid  @RequestBody User user ,Errors errors){
        if(errors.hasErrors()){
            for (ObjectError err : errors.getAllErrors()) {
                String msg = messageSource.getMessage(err, Locale.CHINA);
                return msg;
            }
        }
        return "OK";
    }

    @PostMapping(value = "test/en")
    public String testErrorEn(@Valid  @RequestBody User user ,Errors errors){
        if(errors.hasErrors()){
            for (ObjectError err : errors.getAllErrors()) {
                String msg = messageSource.getMessage(err, Locale.US);
                return msg;
            }
        }
        return "OK";
    }
}
