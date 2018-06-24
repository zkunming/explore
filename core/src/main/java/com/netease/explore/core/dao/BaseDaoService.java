package com.netease.explore.core.dao;

/**
 * 基础Dao服务层（这里不提供删除的方法，一般不对数据进行有删除操作，如果需要删除操作，请在各自的Service层自行实现）
 * @param <T> domain实体对象
 */
public interface BaseDaoService<T>
{
	/**
	 * 增加数据
	 */
	void insert(T domain);

	/**
	 * 根据id查询数据
	 */
	T findById(String id);

	/**
	 * 更新数据
	 */
	boolean update(T domain);
}