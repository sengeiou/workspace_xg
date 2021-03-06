package com.jf.common.utils;


import java.security.Security;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * AES工具类，密钥必须是16位字符串
 */
public class AESUtils {

    /**偏移量,必须是16位字符串*/
    private static final String IV_STRING = "c625ffce4f79016e";

    /**
     * 默认的密钥
     */
    public static final String DEFAULT_KEY = "c625ffce4f79016e7313675af17d4067";

    /**
     * 产生随机密钥(这里产生密钥必须是16位)
     */
    public static String generateKey() {
        String key = UUID.randomUUID().toString();
        key = key.replace("-", "").substring(0, 16);// 替换掉-号
        return key;
    }

    public static String encryptData(String key, String content) {
        byte[] encryptedBytes = new byte[0];
        try {
            byte[] byteContent = content.getBytes("UTF-8");
            // 注意，为了能与 iOS 统一
            // 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
            byte[] enCodeFormat = key.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            Security.addProvider(new BouncyCastleProvider());
            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            encryptedBytes = cipher.doFinal(byteContent);
            // 同样对加密后数据进行 base64 编码
            return Base64.encode(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptData(String key, String content) {
        try {
            // base64 解码
            byte[] encryptedBytes = Base64.decode(content);
            byte[] enCodeFormat = key.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
            Security.addProvider(new BouncyCastleProvider());
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] result = cipher.doFinal(encryptedBytes);
            return new String(result, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
    	String content = "c071c98e-0fea-4da4-8342-cc6d187d05f9";
    	String enCode = AESUtils.encryptData(DEFAULT_KEY, content);
        String deCode = AESUtils.decryptData(DEFAULT_KEY, enCode);
        System.out.println("aes加密后: " + enCode);
        System.out.println("aes解密后: " + deCode);
    }

}
