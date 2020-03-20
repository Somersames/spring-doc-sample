package xyz.somersames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.somersames.service.DataSourceService;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
public class DataSourceTest {


   @Autowired
   DataSourceService dataSourceService;

    @GetMapping("/datasource")
    public String testDataSource(@RequestParam String param1){
        return dataSourceService.testDataSource(param1);
    }

    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime dateTime = LocalTime.parse("14:30:00", df);
        LocalTime time = LocalTime.now();
        System.out.println(time.isAfter(dateTime));
    }
}