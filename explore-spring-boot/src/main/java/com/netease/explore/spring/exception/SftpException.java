package com.netease.explore.spring.exception;

/**
 * 概要：SFTP异常
 */
public class SftpException extends RuntimeException {

  public SftpException() {
    super();
  }

  public SftpException(String message) {
    super(message);
  }

  public SftpException(String message, Throwable cause) {
    super(message, cause);
  }

  public SftpException(Throwable cause) {
    super(cause);
  }

  protected SftpException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
