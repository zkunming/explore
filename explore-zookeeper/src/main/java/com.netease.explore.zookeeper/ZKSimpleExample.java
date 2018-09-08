package com.netease.explore.zookeeper;

import com.alibaba.fastjson.JSON;
import com.netease.explore.core.util.Printer;
import com.netease.explore.zookeeper.common.ZookeeperConstant;
import com.netease.explore.zookeeper.dto.Dubbo;
import com.netease.explore.zookeeper.util.ZookeeperUtil;
import com.netease.explore.zookeeper.watcher.ZooKeeperWatcher;
import java.io.IOException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

class ZKSimpleExample {

  public static void main(String[] args) throws Exception {
    //1、初始化ZK
    final ZooKeeper zooKeeper = buildZookeeper();

    //2、演示简单版zk操作
    ZKSimpleExample zkSimpleExample = new ZKSimpleExample(zooKeeper, ZookeeperConstant.PATH,
        getDubbo());
    zkSimpleExample.execute();
  }

  /**
   * 创建Zookeeper
   */
  private static ZooKeeper buildZookeeper() throws IOException {
    return new ZooKeeper(ZookeeperConstant.CONNECT_STRING, ZookeeperConstant.SESSION_TIMEOUT,
        new ZooKeeperWatcher());
  }

  /**
   * 获取dubbo类
   */
  private static byte[] getDubbo() {
    Dubbo dubbo = new Dubbo("dubbo", "dubbp-测试", "梁飞", "2010-02-10");
    return JSON.toJSONBytes(dubbo);
  }

  private ZooKeeper zooKeeper;
  private String path;
  private byte[] dataBytes;

  public ZKSimpleExample(ZooKeeper zooKeeper, String path, byte[] dataBytes) {
    this.zooKeeper = zooKeeper;
    this.path = path;
    this.dataBytes = dataBytes;
  }

  public void execute() {
    try {
      //1、判断节点是否存在
      Stat stat = zooKeeper.exists(path, null);
      if (stat != null) {
        //存在该节点的信息
        Printer.testPrint(stat);
        //2、循环递归删除节点
        ZookeeperUtil.deleteByRecurrence(path, zooKeeper);
      }
      //3、创建节点
      String nodePath = zooKeeper
          .create(path, dataBytes, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
      Printer.testPrint(nodePath);

      //4、获取节点信息
      byte[] data = zooKeeper.getData(this.path, null, null);
      Printer.testPrint(JSON.parseObject(data, Dubbo.class));

      //5、更新节点信息
      Stat setDataStat = zooKeeper.setData(path, null, -1);
      Printer.testPrint(setDataStat);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
