package com.netease.explore.spring.web.user.vo;

public class UserVO
{
	private String id;
	private String username;

	public UserVO()
	{
	}

	public UserVO(String id, String username)
	{
		this.id = id;
		this.username = username;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@Override
	public String toString()
	{
		return "UserVO{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}
