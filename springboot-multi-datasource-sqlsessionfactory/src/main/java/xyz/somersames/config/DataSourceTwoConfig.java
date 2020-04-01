package xyz.somersames.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"xyz.somersames.dao.two"} ,sqlSessionTemplateRef = "dataSourceTwoSqlSessionTemplate")
public class DataSourceTwoConfig {

    @Bean(name = "dataSourceTwoT")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource getDataSource(){
        return new DruidDataSource();
    }

    @Bean(name = "dataSourceTwoSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("dataSourceTwoT") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/two/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "dataSourceTwoTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("dataSourceTwoT") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dataSourceTwoSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("dataSourceTwoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
