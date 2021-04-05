package xyz.somersames.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import xyz.somersames.entity.Advice;

import java.util.Date;

@ControllerAdvice
public class GlobalAdvice {

    Logger logger = LoggerFactory.getLogger(GlobalAdvice.class);

    @InitBinder
    public void registerProduct(WebDataBinder webDataBinder, String advice){
        logger.info("origin:{}",advice);
        webDataBinder.registerCustomEditor(Advice.class,new ProductEditor());
        webDataBinder.registerCustomEditor(Date.class,new DateEditor());
        webDataBinder.setValidator(new AdviceValidator());
    }

}
