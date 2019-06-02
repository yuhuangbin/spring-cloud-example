package com.yuhb.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Description:
 * author: yu.hb
 * Date: 2019-06-02
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocation;

    @Bean
    public DataSource druidDataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dataSourceProperties.getUrl());
        datasource.setUsername(dataSourceProperties.getUsername());
        datasource.setPassword(dataSourceProperties.getPassword());
        datasource.setDriverClassName(dataSourceProperties.getDriverClassName());

        DataSourceProxy dataSourceProxy = new DataSourceProxy(datasource);
        return dataSourceProxy;
    }

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource druidDataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(mapperLocation);
        sqlSessionFactory.setDataSource(druidDataSource);
        sqlSessionFactory.setMapperLocations(resources);
        return sqlSessionFactory;
    }


}
