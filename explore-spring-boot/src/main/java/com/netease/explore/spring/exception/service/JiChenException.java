package com.netease.explore.spring.exception.service;

/**
 * 概要：集成业务异常
 */
public class JiChenException extends RuntimeException{

  public JiChenException() {
    super();
  }

  public JiChenException(String message) {
    super(message);
  }

  public JiChenException(String message, Throwable cause) {
    super(message, cause);
  }

  public JiChenException(Throwable cause) {
    super(cause);
  }

  protected JiChenException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
