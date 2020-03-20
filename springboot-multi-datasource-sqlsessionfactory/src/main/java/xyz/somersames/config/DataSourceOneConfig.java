package xyz.somersames.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"xyz.somersames.dao.one"} ,sqlSessionTemplateRef = "dataSourceOneSqlSessionTemplate")
public class DataSourceOneConfig {

    @Primary
    @Bean(name = "dataSourceOneT")
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource getDataSource(){
        return new DruidDataSource();
    }

    @Primary
    @Bean(name = "dataSourceOneSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("dataSourceOneT") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/one/*.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean(name = "dataSourceOneTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("dataSourceOneT") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "dataSourceOneSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("dataSourceOneSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
