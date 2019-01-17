package com.netease.explore.core.util;

import com.netease.explore.core.exception.ZipException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class ZipUtil {

  /**
   * 不允许被实例化
   */
  private ZipUtil() {
  }

  private static int bufferSize = 1024;

  /***
   * 概要：Zip压缩
   *
   * @param data 待解压的字节数据
   * @param fileName 解压出来的文件名，不包含.zip, 例如tt.txt [备注：如果不需要写入到文件，该值可填""][解压的文件名：tt.txt.zip ，该文件名是用户自己产生的]
   */
  public static byte[] compress(byte[] data, String fileName) {
    try (
        ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
      compress(data, fileName, bos);
      return bos.toByteArray();
    } catch (Exception ex) {
      throw new ZipException("Zip compress failed!", ex);
    }
  }


  /**
   * 概要：压缩数据输出到Outputstream
   *
   * @return 压缩的数据大小
   */
  public static long compress(byte[] data, String fileName, OutputStream outputStream) {
    CustomerOutputStream customerOutputStream = new CustomerOutputStream(outputStream);
    ZipOutputStream zip = new ZipOutputStream(customerOutputStream);
    try {
      ZipEntry entry = new ZipEntry(fileName);
      zip.putNextEntry(entry);
      zip.write(data);
      zip.closeEntry();
      zip.close();
    } catch (Exception ex) {

      //备注：这里之所以close不在finally里面执行时有原因的：close操作还会输出流，
      if (zip != null) {
        try {
          zip.close();
        } catch (IOException e) {
          throw new ZipException("Zip compress failed!", ex);
        }
      }
      throw new ZipException("Zip compress failed!", ex);
    }
    return customerOutputStream.getDataSize();
  }


  /**
   * 概要：压缩某一个文件
   *
   * @param waitToCompressFilePath 等待被解压的文件
   * @param compressFilePath 压缩的文件名
   * @param fileName 解压后的文件名 (产生压缩文件后，如果你用系统工具解压，解压出来的文件的名称就是该fileName)
   */
  public static void compress(String waitToCompressFilePath, String compressFilePath,
      String fileName) {
    try (
        InputStream inputStream = new FileInputStream(waitToCompressFilePath);
        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(compressFilePath))) {
      byte[] bytes = new byte[bufferSize];
      int length;
      ZipEntry zipEntry = new ZipEntry(fileName);
      zip.putNextEntry(zipEntry);
      while ((length = inputStream.read(bytes)) != -1) {
        zip.write(bytes, 0, length);
      }
      zip.closeEntry();
    } catch (Exception e) {
      throw new ZipException("Zip compress failed!", e);
    }
  }

  /***
   * 概要：Zip解压
   */
  public static byte[] unCompress(InputStream inputStream) throws IOException {
    byte[] resultBytes = null;
    try (ZipInputStream zip = new ZipInputStream(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
      while (zip.getNextEntry() != null) {
        byte[] bufferBytes = new byte[bufferSize];
        int length;
        while ((length = zip.read(bufferBytes, 0, bufferBytes.length)) != -1) {
          outputStream.write(bufferBytes, 0, length);
        }
        resultBytes = outputStream.toByteArray();
        outputStream.flush();
        outputStream.close();
      }
    } catch (Exception ex) {
      throw new ZipException("Zip unCompress failed!", ex);
    } finally {
      inputStream.close();
    }
    return resultBytes;
  }

  /**
   * 用于统计流大小
   */
  public static class CustomerOutputStream extends OutputStream {

    /**
     * 代理对象
     */
    private OutputStream proxy;

    /**
     * 数据大小
     */
    private AtomicLong dataSize;

    public CustomerOutputStream(OutputStream proxy) {
      this.proxy = proxy;
      dataSize = new AtomicLong(0);
    }

    @Override
    public void write(int b) throws IOException {
      this.proxy.write(b);
      this.dataSize.addAndGet(1);
    }


    @Override
    public void write(byte[] b) throws IOException {
      this.proxy.write(b);
      this.dataSize.addAndGet(b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
      this.proxy.write(b, off, len);
      this.dataSize.addAndGet(len);
    }

    @Override
    public void flush() throws IOException {
      this.proxy.flush();
    }

    @Override
    public void close() throws IOException {
      this.proxy.close();
    }

    public long getDataSize() {
      return dataSize.get();
    }
  }
}
