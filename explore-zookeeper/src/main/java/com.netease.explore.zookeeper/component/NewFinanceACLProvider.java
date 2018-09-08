package com.netease.explore.zookeeper.component;

import com.google.common.collect.Lists;
import com.netease.explore.zookeeper.common.ZookeeperConstant;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewFinanceACLProvider implements ACLProvider {

  private final static Logger logger = LoggerFactory.getLogger(NewFinanceACLProvider.class);
  public static List<ACL> aclList;

  public NewFinanceACLProvider() throws NoSuchAlgorithmException {
    //初始化acl
    Id id = new Id(ZookeeperConstant.SCHEME,
        DigestAuthenticationProvider.generateDigest(ZookeeperConstant.AUTH));
    aclList = Lists.newArrayList(new ACL(ZooDefs.Perms.ALL, id));

  }

  /**
   * @return
   */
  @Override
  public List<ACL> getDefaultAcl() {
    return aclList;
  }

  /**
   * 默认所有待创建的节点都要加入权限控制
   */
  @Override
  public List<ACL> getAclForPath(String path) {
    if (StringUtils.isEmpty(path)) {
      logger.error("该目录需要进行acl接入，path:" + path);
      throw new RuntimeException("path路径为空，无法判断是否需要加入权限");
    }
    logger.info("进入getAclForPath方法,path:+" + path);
    return aclList;
  }
}
