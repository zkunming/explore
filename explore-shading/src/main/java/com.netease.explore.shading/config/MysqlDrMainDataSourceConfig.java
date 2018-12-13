package com.netease.explore.shading.config;

import com.netease.explore.shading.constant.TransactionConstant;
import com.netease.explore.shading.util.DataSourceUtils;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(basePackages = "com.dianrong.moat.repo.drmain", sqlSessionFactoryRef = "drmainSqlSessionFactory")
public class MysqlDrMainDataSourceConfig {

  @Value("${mysql.drmain.datasource.url}")
  private String drmainUrl;

  @Value("${mysql.drmain.datasource.username}")
  private String drmainUsername;

  @Value("${mysql.drmain.datasource.password}")
  private String drmainPassword;

  @Value("${mysql.drmain.datasource.driverClass}")
  private String drmainDriver;

  @Value("${datasource.max-active}")
  private int maxActive;

  @Value(("${datasource.max-wait}"))
  private int maxWait;

  @Value("${mysql.drmain.mapper.location}")
  private String drmainMapperLocation;


  // =================mysql-drmain配置====================
  @Bean(name = "drmainDataSource")
  @Primary
  public DataSource drmainDataSource() {
    return DataSourceUtils
        .dataSource(drmainUrl, drmainUsername, drmainPassword, drmainDriver, maxActive, maxWait);
  }

  @Bean(name = TransactionConstant.MYSQL_DRMAIN_DATA_SOURCE)
  @Primary
  public PlatformTransactionManager drmainTransactionManager() {
    return DataSourceUtils.platformTransactionManager(drmainDataSource());
  }

  @Bean(name = "drmainSqlSessionFactory")
  @Primary
  public SqlSessionFactory drmainSqlSessionFactory() throws Exception {
    return DataSourceUtils.sqlSessionFactory(drmainDataSource(), drmainMapperLocation);
  }
}
