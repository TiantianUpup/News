package com.cqupt.myproject.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 基础加密工具类
 *
 * @author hetiantian
 * @version 1.0
 * @since 1.0
 */
public class EncryptUtil {
    public static final String KEY_SHA = "SHA";
    public static final String KEY_MD5 = "MD5";

    /**
     * SHA加密
     *
     * @param data
     * @return
     * */
    public static String encryptSHA(String data)  {

        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance(KEY_SHA);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        sha.update(data.getBytes());

        return byteArrayToHexStr(sha.digest());

    }

    /**
     * MD5加密
     *
     * @param data
     * @return
     * @throws NoSuchAlgorithmException
     * */
    public static String encryptMD5(String data){

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance(KEY_MD5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(data.getBytes());

        return byteArrayToHexStr(md5.digest());

    }

    /**
     * 字节转字符串
     * */
    public static String byteArrayToHexStr(byte[] bytes) {

        if(bytes == null) {
            return null;
        }

        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length*2];

        for(int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = hexArray[v >>> 4];
            hexChars[i * 2 + 1] = hexArray[v & 0X0F];
        }

        return new String(hexChars);

    }

}
