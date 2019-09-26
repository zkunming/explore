package com.netease.explore.spring.config.datasource;

import com.netease.explore.spring.constant.TransactionConstant;
import com.netease.explore.spring.util.DataSourceUtils;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(basePackages = "com.dianrong.moat.repo.slprod", sqlSessionFactoryRef = "slprodSqlSessionFactory")
public class OracleSlprodDataSourceConfig {

  @Value("${oracle.slprod.datasource.url}")
  protected String oracleUrl;
  @Value("${oracle.slprod.datasource.username}")
  protected String oracleUsername;

  @Value("${oracle.slprod.datasource.password}")
  protected String oraclePassword;

  @Value("${oracle.slprod.datasource.driverClass}")
  protected String oracleDriver;

  @Value("${datasource.max-active}")
  protected int maxActive;

  @Value(("${datasource.max-wait}"))
  protected int maxWait;

  @Value("${oracle.slprod.mapper.location}")
  private String slprodMapperLocation ;

  // =================oracle-slprod配置====================
  @Bean(name = "slprodDataSource")
  public DataSource oracleDataSource() {
    return DataSourceUtils
        .dataSource(oracleUrl, oracleUsername, oraclePassword, oracleDriver, maxActive, maxWait);
  }

  @Bean(name = TransactionConstant.ORACLE_SLPROD_DATA_SOURCE)
  public PlatformTransactionManager oracleTransactionManager() {
    return DataSourceUtils.platformTransactionManager(oracleDataSource());
  }


  @Bean(name = "slprodSqlSessionFactory")
  public SqlSessionFactory slprodSqlSessionFactory() throws Exception {
    return DataSourceUtils.sqlSessionFactory(oracleDataSource(), slprodMapperLocation);
  }
}
