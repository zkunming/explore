package com.netease.explore.shading.util;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

public class DataSourceUtils {

  /**
   * 不允许被实例化
   */
  private DataSourceUtils() {
  }

  public static DataSource dataSource(String url, String username, String password, String driver,
      int maxActive, int maxWait) {
    DruidAbstractDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName(driver);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    dataSource.setMaxActive(maxActive);
    dataSource.setMaxWait(maxWait);
    return dataSource;
  }

  public static PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
    DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
    dataSourceTransactionManager.setDataSource(dataSource);
    return dataSourceTransactionManager;
  }


  public static SqlSessionFactory sqlSessionFactory(DataSource dataSource, String locationPattern)
      throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
        .getResources(locationPattern));
    return sessionFactory.getObject();
  }
}
