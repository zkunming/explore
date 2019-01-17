package com.netease.explore.core.util;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.net.util.Base64;

public class RSAUtil {

  private static String KEY_ALGORITHM = "RSA";
  private static String SIGN_ALGORITHMS = "SHA1WithRSA";
  // 私钥
  private static final String priKey =
      "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKivT6P/1QBBjYL1\n"
          + "jCKdKHcZt+J9UkvzCck4DSIDp1asea/52YLyRl1TFFpplWscmVDxHkRzcd5y2f2k\n"
          + "Y413gavlQNwp+ieeO49ZIq0DzM3ca+OIDggp6Fk3+hVuLtMQmsV+KUhoKtg3KEFo\n"
          + "jWX7W7ofSJIrO/4nd8RyaiTpMclhAgMBAAECgYAtoT6p3kqABzuAcWu28UxA63QS\n"
          + "kFPyt4uuIrtquBJMH9vK/osYIPFnzVF0I5uHnfTbMF4/pfrncaoGMrG7UtiAdpZA\n"
          + "Z33KXARXoU6q/RC8qINOa5ldssb+7T6kBJxtYjAgTyWWZzVUU2UQQGVFLGRfwN20\n"
          + "0O9cHeUlnsNBYPWcAQJBAN4hB4P/sVimIO2p4V6Zydf7fy86ZbDW4B6GxM6e8jzk\n"
          + "JBZp08Zd1WzziSX6IheH33gEQgTvx6hefN+b+6W8KG0CQQDCaAwh2Hir9M0RRcmg\n"
          + "o9tzV5HhCC3Zk/1tli9OOiGKRsSI7vibKX6BSmKxoQwvAs/zFkCwZ0m2iCGgE+9w\n"
          + "3/RFAkBGtz0tSLms/zZ8cxjMhSk9GVPkNTMqmT3AeictoGx99iOG/ynsfPL1PJLt\n"
          + "BDTWSOtbyf86kxt8/pfCmGYE3WIBAkB5DeMoHCygHvKm48b2sbHP8+KRts8eIgn3\n"
          + "+EICuy3xdbmh7vR9Yew1RAWKyFbW2zB0FRI5BkgfUktl66P4rGvlAkEAxSBk8M68\n"
          + "W1jzGHgvDaNzDjK6GiaTr75nUe1b6hZB1Kt4MveX0VeSSlKZUdih9RBb82B+qoJG\n"
          + "Nvv0glPvTVLEbg==";

  // 公钥
  private static final String pubKey =
      "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCor0+j/9UAQY2C9YwinSh3Gbfi\n"
          + "fVJL8wnJOA0iA6dWrHmv+dmC8kZdUxRaaZVrHJlQ8R5Ec3Hectn9pGONd4Gr5UDc\n"
          + "KfonnjuPWSKtA8zN3GvjiA4IKehZN/oVbi7TEJrFfilIaCrYNyhBaI1l+1u6H0iS\n"
          + "Kzv+J3fEcmok6THJYQIDAQAB";

  public static void main(String[] args)
      throws NoSuchAlgorithmException, SignatureException, InvalidKeySpecException, InvalidKeyException {
    String str = "i love you";
    //签名
    String signstr = sign(str, priKey);

    System.out.println("签名结果：" + signstr);
    //验签
    boolean result = verify(str, signstr, pubKey);
    System.out.println("验签结果：" + result);
  }

  /*
   * 输入参数 签名字符串，16进制私钥 输出参数 16进制的签名串 函数当中测试了enbase64 的 合成与解析
   */
  public static String sign(String content, String privateKeyString)
      throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, InvalidKeySpecException {

    //用私钥进行签名
    PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
        Base64.decodeBase64(privateKeyString));
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec); // 用key工厂对象生成私钥
    Signature signature = Signature.getInstance(SIGN_ALGORITHMS);  //  md5 RSA签名对象
    signature.initSign(privateKey);  //初始化签名
    signature.update(content.getBytes());
    byte[] result = signature.sign();  //对消息进行签名
    return Base64.encodeBase64String(result);
  }

  /*
   * 输入参数 需要验签字符串，签名字符串，16进制公钥 输出参数 是否成功验签 函数当中测试了enbase64 的 合成与解析
   */
  public static boolean verify(String content, String sign, String publicKeyString)
      throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
    byte[] keyBytes = Base64.decodeBase64(publicKeyString);
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    PublicKey publicK = keyFactory.generatePublic(keySpec);
    Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
    signature.initVerify(publicK);
    signature.update(content.getBytes());
    return signature.verify(Base64.decodeBase64(sign));
  }

  /**
   * <p>
   * 生成密钥对(公钥和私钥)
   * </p>
   */
  public static void genKeyPair() throws Exception {
    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
    keyPairGen.initialize(1024);
    KeyPair keyPair = keyPairGen.generateKeyPair();
    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
  }
}
