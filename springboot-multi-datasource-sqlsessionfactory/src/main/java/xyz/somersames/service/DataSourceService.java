package xyz.somersames.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.somersames.dao.one.DataSourceOne;
import xyz.somersames.dao.two.DataSourceTwo;

@Service
public class DataSourceService {

    @Autowired
    DataSourceOne dataSourceOne;

    @Autowired
    DataSourceTwo dataSourceTwo;

    public String testDataSource(String param1){
        if("1".equals(param1)){
            System.out.println(dataSourceOne.getDataSourceFromOne());
        } else{
            System.out.println(dataSourceTwo.getDataSourceFromTwo());
        }
        return "OK";
    }
}
