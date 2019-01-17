package com.netease.explore.core.util;

/**
 * 概要：SFTP工具类
 */
public final class SftpUtil {
  
//
//  private SftpUtil() {
//  }
//
//
//  /**
//   * 概要：文件上传
//   */
//  public static void justUploadData(SftpConfig sftpConfig, InputStream inputStream,
//      String remoteFile, String remotePath) throws IOException {
//    ChannelSftp sftp = openSftpChannel(sftpConfig);
//    uploadData(sftp, inputStream, remotePath, remoteFile);
//    closeConnect(sftp);
//  }
//
//  /**
//   * 概要：打开SFTP通道
//   */
//  public static ChannelSftp openSftpChannel(SftpConfig sftpConfig) {
//    log.info("Begin open sftp channel, sftpConfig:{} ", JSON.toJSONString(sftpConfig));
//    JSch jsch = new JSch(); // 创建JSch对象
//
//    try {
//      // 根据用户名，主机ip，端口获取一个Session对象
//      Session session = jsch
//          .getSession(sftpConfig.getUserName(), sftpConfig.getServer(), sftpConfig.getPort());
//
//      if (sftpConfig.getUserPassword() != null) {
//        session.setPassword(sftpConfig.getUserPassword()); // 设置密码
//      }
//      Properties config = new Properties();
//      config.put("StrictHostKeyChecking", "no");
//      session.setConfig(config);
//      session.setTimeout(sftpConfig.getTimeout());
//      session.connect();
//      Channel channel = session.openChannel("sftp");
//      channel.connect();
//      log.info("Open sftp channel success, sftpConfig:{} ", JSON.toJSONString(sftpConfig));
//      return (ChannelSftp) channel;
//    } catch (Exception e) {
//      throw new SftpException(
//          "openSftpChannel error, sftpConfig:[" + JSON.toJSONString(sftpConfig) + "]", e);
//    }
//  }
//
//  /**
//   * 概要：获取SFTP输出流[会直接写入到该文件中]
//   */
//  public static OutputStream getSftpOutputStream(ChannelSftp channelSftp, String remotePath,
//      String remoteFile) throws com.jcraft.jsch.SftpException {
//    channelSftp.cd(remotePath);
//    return channelSftp.put(remoteFile);
//  }
//  /**
//   * 概要：上传文件
//   */
//  public static void uploadData(ChannelSftp sftp, InputStream inputStream, String remoteFilePath,
//      String remoteFileName) throws IOException {
//    Asserts.notNull(sftp, "sftp can not be null");
//    Asserts.notNull(inputStream, "inputStream can not be null");
//    Asserts.notBlank(remoteFilePath, "remoteFilePath can not be null");
//
//    try {
//      sftp.cd(remoteFilePath);
//      sftp.put(inputStream, remoteFileName);
//    } catch (Exception e) {
//      throw new SftpException(
//          "upload file failed! remoteFilePath:[" + remoteFilePath + "], remoteFileName:["
//              + remoteFileName + "]", e);
//    }finally {
//      inputStream.close();
//    }
//  }
//
//  /**
//   * 概要：下载远程文件
//   */
//  public static InputStream downloadFile(ChannelSftp sftp, String remoteFilePath,
//      String remoteFileName) {
//    try {
//      sftp.cd(remoteFilePath);
//      return sftp.get(remoteFileName);
//    } catch (Exception e) {
//      throw new SftpException(
//          "dump remote file failed! remoteFilePath:[" + remoteFilePath + "], remoteFileName:["
//              + remoteFileName + "]", e);
//    }
//  }
//
//
//  /**
//   * 概要：下载文件至本地
//   *
//   * @param remoteFilePath 远程文件路径
//   * @param remoteFileName 远程文件名
//   * @param localFileAbsolutePath 本地文件玩完整路径
//   */
//  public static void downloadToLocalFile(ChannelSftp sftp, String remoteFilePath,
//      String remoteFileName, String localFileAbsolutePath) {
//    try {
//      sftp.cd(remoteFilePath);
//      sftp.get(remoteFileName, new FileOutputStream(localFileAbsolutePath));
//    } catch (Exception e) {
//      throw new SftpException(
//          "download to local file failed! remoteFilePath:[" + remoteFilePath + "], remoteFileName:["
//              + remoteFileName + "]", e);
//    }
//  }
//
//  /**
//   * 概要：关闭连接
//   */
//  public static void closeConnect(ChannelSftp sftp) {
//    Asserts.notNull(sftp, "sftp is null");
//    try {
//      Session session = sftp.getSession();
//      sftp.disconnect();
//      session.disconnect();
//    } catch (Exception e) {
//      throw new SftpException("SFTP closeConnect error, ", e);
//    }
//  }
//
//
//  /**
//   * 概要：校验SFTP文件服务器是否存在某个指定的文件
//   */
//  public static boolean checkFileExist(ChannelSftp channelSftp, String remoteFilePath,
//      String fileName) {
//    Asserts.notNull(channelSftp, "channelSftp can not be null");
//    Asserts.notBlank(remoteFilePath, "remoteFilePath can not be null");
//    Vector vector;
//    try {
//      vector = channelSftp.ls(remoteFilePath);
//    } catch (Exception e) {
//      //备注：这里之所以在这里捕获异常，是因为如果目录不存在，channelSftp会直接抛异常，
//      //这里不需要担心会把账号、密码等错误等异常捕获，因为这类异常会在openSftpChannel阶段就抛出来
//      return false;
//    }
//    for (Object object : vector) {
//      LsEntry entry = (LsEntry) object;
//      if (fileName.equals(entry.getFilename())) {
//        return true;
//      }
//    }
//    return false;
//
//  }
//
//  /**
//   * 概要：删除SFTP文件服务器指定的文件 建议：使用这个方法前先调用checkFileExist() 判断一下文件是否存在》
//   */
//  public static boolean deleteFile(ChannelSftp channelSftp, String remoteFilePath,
//      String fileName) {
//    try {
//      channelSftp.rm(remoteFilePath + "/" + fileName);
//      return true;
//    } catch (Exception e) {
//      throw new SftpException(
//          "deleteFile error,remoteFilePath:[" + remoteFilePath + "], fileName:[" + fileName
//              + "],", e);
//    }
//  }
  
  public static class SftpConfig {

    // 登录用户名
    private String userName;
    // 登录密码
    private String userPassword;
    // 地址
    private String server;
    // 端口
    private int port;
    //超时时间
    private int timeout;
  }
}
