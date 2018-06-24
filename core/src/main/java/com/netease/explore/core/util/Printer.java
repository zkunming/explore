package com.netease.explore.core.util;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

public class Printer
{
	public static void testPrint(Object content)
	{
		System.out.println(
				"===================================================================================================================================="
						+ "\n"
						+ "打印内容:" + JSON.toJSONString(content)
						+ "\n"
						+ "===================================================================================================================================="
						+ "\n");
	}

	public static void testPrintBytes(byte[] bytes) throws UnsupportedEncodingException
	{
		String content = new String(bytes, "UTF-8");
		testPrint(content);
	}

	public static void testPrintBytes(byte[] bytes, String stat) throws UnsupportedEncodingException
	{
		String content = new String(bytes, "UTF-8");
		testPrint(content + ", stat : " + stat);
	}
}
