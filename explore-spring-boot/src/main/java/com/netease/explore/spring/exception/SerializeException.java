package com.netease.explore.spring.exception;

/**
 * 概要：序列化异常
 */
public class SerializeException extends RuntimeException {

  public SerializeException() {
    super();
  }

  public SerializeException(String message) {
    super(message);
  }

  public SerializeException(String message, Throwable cause) {
    super(message, cause);
  }

  public SerializeException(Throwable cause) {
    super(cause);
  }

  protected SerializeException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
