package xyz.somersames.dao.one;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

public interface DataSourceOne {

    Map<String,Object> getDataSourceFromOne();
}
