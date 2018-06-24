package com.netease.explore.core.dao;

public interface BaseDao<T>
{
	/**
	 * 增加数据
	 */
	int insert(T domain);

	/**
	 * 根据id查询数据
	 */
	T findById(String id);

	/**
	 * 更新数据
	 */
	boolean update(T domain);
}
