package com.netease.explore.spring.exception;

public class ZipException extends RuntimeException {

  public ZipException() {
    super();
  }

  public ZipException(String message) {
    super(message);
  }

  public ZipException(String message, Throwable cause) {
    super(message, cause);
  }

  public ZipException(Throwable cause) {
    super(cause);
  }

  protected ZipException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
