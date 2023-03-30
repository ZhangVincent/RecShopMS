package com.zkp.recshop.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 对密码进行MD5加密处理，以提高安全性。
 */
public class MD5Utils {
    public static String md5Encode(String pwd) {
        String str = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(pwd.getBytes());
            byte[] bs = md5.digest();
            str = new BigInteger(1, bs).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }
}
