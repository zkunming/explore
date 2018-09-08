package com.netease.explore.zookeeper.common;

public class ZookeeperConstant {

  public static final String PATH = "/dubbo-zkm";
  public final static String LOCK_PATH = "/lock/explore/survey";
  public final static String DUBBO_SERVICE_PATH = "/pubsub/explore/dubbo";
  public final static String LEADER_SELECTOR_PATH = "/leader/selector/explore/survey";

  public static final String CONNECT_STRING = "localhost:2181";
  public static final int SESSION_TIMEOUT = 2000;//2秒
  public final static String SCHEME = "digest";
  public final static String AUTH = "zkm:zkm123123";
  public final static int RETRY_TIME = 5;
}
