package com.netease.explore.core.dao;

import com.netease.explore.core.SpringContext;
import java.lang.reflect.ParameterizedType;
import javax.annotation.PostConstruct;

public class BaseDaoServiceImpl<T> implements BaseDaoService<T> {

  private BaseDao<T> baseDao;


  @PostConstruct
  public void init() {
    Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];

    String simpleName = entityClass.getSimpleName();
    String firstWorld = simpleName.substring(0, 1);
    String lowerCase = firstWorld.toLowerCase();
    String beanName = lowerCase +
        simpleName.substring(1, simpleName.length()) + "Dao";
    baseDao = (BaseDao<T>) SpringContext.getBean(beanName);
  }

  public void insert(T domain) {

    baseDao.insert(domain);
  }

  public T findById(String id) {
    return baseDao.findById(id);
  }

  public boolean update(T domain) {
    return baseDao.update(domain);
  }
}
