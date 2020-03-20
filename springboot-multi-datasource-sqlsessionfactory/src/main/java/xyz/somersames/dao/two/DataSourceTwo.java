package xyz.somersames.dao.two;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

public interface DataSourceTwo {

    Map<String,Object> getDataSourceFromTwo();

}
