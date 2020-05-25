package xyz.somersames.spring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author somersames
 */
@RequestMapping(value = "/api")
@RestController
public class RestControllerTest {

    @RequestMapping(value = "/query/{id}")
    public String getStrFromReq(@PathVariable(name = "id") String id){
        return id;
    }
}
