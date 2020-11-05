package com.example.demo.encrypt;

import com.alibaba.csp.sentinel.util.StringUtil;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

/**
 * 提供简单的加解密处理。<BR>
 *
 * @author <a href="mailto:chengy@primeton.com">chengy</a>
 */

public final class CryptoUtil {
    /**
     * DES算法常量
     */
    public static String DES_ALGORITHM = "DES";  //ECB/PKCS5Padding

    /**
     * AES算法常量
     */
    public static String AES_ALGORITHM = "AES";    //ECB/PKCS5Padding

    /**
     * 3DES算法常量
     */
    public final static String DESede_ALGORITHM = "DESede"; //ECB/PKCS5Padding

    private static final int HEADLEN = 12;

    private static final int KEYLEN = 24; // 密钥的字节长度

    /**
     * encrypt(String),encrypt(String,String), decrypt(String),decrypt(String,String) 的使用算法
     */
    public final static String ALGORITHM = "3DES";


    /**
     * 因为不需要实例，所以构造函数为私有<BR> 参见Singleton模式<BR> Only one instance is needed,so the default constructor is private<BR> Please refer to
     * singleton design pattern.
     */
    public CryptoUtil() {
        super();
    }

    /**
     * 生成密钥, 注意此步骤时间比较长。<BR> Generate a key by a specified key.<BR>
     *
     * @param algorithm If the algorithm is not one of the tow specified algorithms.<BR> It will be DES.<BR>
     * @return
     * @throws NoSuchAlgorithmException
     * @see #DES_ALGORITHM
     * @see #AES_ALGORITHM
     */
    public static byte[] getKey(String algorithm) throws NoSuchAlgorithmException {
        algorithm = assertAlgorithm(algorithm);
        KeyGenerator keygen = KeyGenerator.getInstance(algorithm);
        keygen.init(getKeySize(algorithm), new SecureRandom());
        SecretKey deskey = keygen.generateKey();
        return deskey.getEncoded();
    }

    /**
     * 使用指定的Key和算法来对指定内容进行加密。<BR> Use the specified algorithm and keys to encrypt the byte array.<BR>
     *
     * @param input
     * @param key
     * @param algorithm If the algorithm is not one of the tow specified algorithms.<BR> It will be DES.<BR>
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @see #DES_ALGORITHM
     * @see #AES_ALGORITHM
     */
    public static byte[] encrypt(final byte[] input, final byte[] key, String algorithm) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        algorithm = assertAlgorithm(algorithm);
        SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, algorithm);
        Cipher c1 = Cipher.getInstance(algorithm);
        c1.init(Cipher.ENCRYPT_MODE, deskey);
        byte[] cipherByte = c1.doFinal(input);
        return cipherByte;
    }

    /**
     * 使用指定的Key和算法来对指定内容进行解密。<BR> Use the specified algorithm and keys to decrypt the byte array.<BR>
     *
     * @param input
     * @param key
     * @param algorithm If the algorithm is not one of the tow specified algorithms.<BR> It will be DES.<BR>
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @see #DES_ALGORITHM
     * @see #AES_ALGORITHM
     */
    public static byte[] decrypt(final byte[] input, final byte[] key, String algorithm) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        algorithm = assertAlgorithm(algorithm);
        SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, algorithm);
        Cipher c1 = Cipher.getInstance(algorithm);
        c1.init(Cipher.DECRYPT_MODE, deskey);
        byte[] clearByte = c1.doFinal(input);
        return clearByte;
    }

    /**
     * 增加对MD5的加密算法
     *
     * @param plain
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String md5(String plain) throws NoSuchAlgorithmException {
        byte[] input = null;
        try {
            input = plain.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new NoSuchAlgorithmException(e);
        }

        byte[] encrypted = md5(input);

        return byte2hex(encrypted);
    }

    /**
     * 使用MD5算法生成摘要信息。<BR> Generate hash content by MD5 for a string.<BR>
     *
     * @param input
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static byte[] md5(final byte[] input) throws NoSuchAlgorithmException {
        java.security.MessageDigest alg = java.security.MessageDigest.getInstance("MD5"); // or "SHA-1"
        alg.update(input);
        byte[] digest = alg.digest();
        return digest;
    }

    /**
     * 增加对sha1的加密算法
     *
     * @param plain
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String sha1(String plain) throws NoSuchAlgorithmException {
        byte[] input = null;
        try {
            input = plain.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new NoSuchAlgorithmException(e);
        }

        byte[] encrypted = sha1(input);

        return byte2hex(encrypted);
    }

    /**
     * 使用sha1算法生成摘要信息。<BR> Generate hash content by MD5 for a string.<BR>
     *
     * @param input
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static byte[] sha1(final byte[] input) throws NoSuchAlgorithmException {
        java.security.MessageDigest alg = java.security.MessageDigest.getInstance("SHA-1"); // or "SHA-1"
        alg.update(input);
        byte[] digest = alg.digest();
        return digest;
    }

    /**
     * 将字节码转换成16进制字符串。<BR> Convert byte array to string in HEX.<BR>
     *
     * @param b
     * @return
     */
    public static String byte2hex(final byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
//			if (n < b.length - 1) {
//				hs = hs + ":";
//			}
        }
        return hs.toUpperCase();
    }

    /**
     * 检查指定的算法是否有效，如果无效，默认使用DES。<BR>
     *
     * @param algorithm
     * @return
     * @see #AES_ALGORITHM
     * @see #DES_ALGORITHM
     */
    private static String assertAlgorithm(String algorithm) {
        if (StringUtil.equalsIgnoreCase(algorithm, AES_ALGORITHM)) {
            return AES_ALGORITHM;
        } else {
            return DES_ALGORITHM;
        }
    }

    /**
     * 使用缺省密钥加密
     *
     * @param plain
     * @return
     */
    public final static String encrypt(String plain) {
        if (plain == null || plain.length() == 0) return null;
        try {
            byte[] seed = getSeed();
            String seedStr = base64Encode(seed);
            byte[] key = generateKey(seed);
            return seedStr + encrypt(plain, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用指定密钥字符串加密
     *
     * @param plain 明文
     * @param key   密钥字符串
     * @return
     * @throws Exception
     */
    public final static String encrypt(String plain, String key) throws Exception {
        return encrypt(plain, getKeyByString(key));
    }

    /**
     * 使用指定密钥加密
     *
     * @param plain
     * @param key
     * @return
     * @throws Exception
     */
    private final static String encrypt(String plain, byte[] key) throws Exception {
        byte[] encrypted = encryptByJCE(plain.getBytes("UTF-8"), key);
        return base64Encode(encrypted);
    }

    /**
     * 加密函数(使用JCE加密）
     *
     * @param plainText 明文
     * @param key       密钥
     * @return
     * @throws Exception
     */
    private static byte[] encryptByJCE(byte[] plainText, byte[] key) throws Exception {
        SecretKey securekey = new SecretKeySpec(key, DESede_ALGORITHM);
        Cipher cipher = Cipher.getInstance(DESede_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, securekey);
        return cipher.doFinal(plainText);
    }

    /**
     * 使用缺省密钥解密
     *
     * @param cryptograph 密文
     * @return
     */
    public final static String decrypt(String cryptograph) {
        if (cryptograph == null || cryptograph.length() == 0) return "";
        try {
            String seedStr = cryptograph.substring(0, HEADLEN);
            byte[] seed = base64Decode(seedStr);
            byte[] key = generateKey(seed);
            return decryptByJCE(cryptograph.substring(HEADLEN), key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 使用指定密钥字符串解密
     *
     * @param cryptograph 密文
     * @param key         密钥字符串
     * @return
     */
    public final static String decrypt(String cryptograph, String key) throws Exception {
        return decryptByJCE(cryptograph, getKeyByString(key));
    }

    /**
     * 密码解密（使用JCE）
     *
     * @param cryptograph 密文
     * @param key         密钥
     * @return
     * @throws Exception
     */
    private final static String decryptByJCE(String cryptograph, byte[] key) throws Exception {
        byte[] encrypted = base64Decode(cryptograph);
        return new String(decrypt(encrypted, key), "UTF-8");
    }

    /**
     * 解密函数
     *
     * @param cryptograph 密文
     * @param key         密钥
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] cryptograph, byte[] key) throws Exception {
        SecretKey securekey = new SecretKeySpec(key, DESede_ALGORITHM);
        Cipher cipher = Cipher.getInstance(DESede_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, securekey);
        return cipher.doFinal(cryptograph);
    }

    /**
     * 生成密钥
     *
     * @param seed
     * @return
     * @throws Exception
     */
    private static byte[] generateKey(byte[] seed) throws Exception {
        byte[] key = new byte[]{0x24, 0x50, 0x72, 0x69, 0x6d, 0x65, 0x74, 0x6f, 0x6e, 0x2d, 0x45, 0x4f, 0x53, 0x20, 0x57, 0x69,
                0x6c, 0x6c, 0x5f, 0x57, 0x69, 0x6e, 0x21, 0x24};
        for (int i = 0; i < seed.length; i++) {
            for (int j = 0; j < key.length; j++) {
                key[j] = (byte) (key[j] ^ seed[i]);
            }
        }
        return key;
        /**
         * will generate different keys between Sun JCE & IBM JCE KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM,JCE_PROVIDER);
         * KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM); kg.init(112, sr); SecretKey key = kg.generateKey(); return
         * key.getEncoded();
         */
    }

    /**
     * 根据当前时间戳生成种子
     *
     * @return
     */
    private static byte[] getSeed() {
        long seed = new Date().getTime();
        byte[] seedBytes = null;
        try {
            seedBytes = String.valueOf(seed).getBytes("UTF-8");
            MessageDigest digest = MessageDigest.getInstance("MD5");
            return base64Decode(base64Encode(digest.digest(seedBytes)).substring(0, HEADLEN));
        } catch (Exception e) {
            return seedBytes;
        }
    }

    /**
     * base64编码
     *
     * @param bytes
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String base64Encode(byte[] bytes) {
        try {
            return new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * base64解码
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] base64Decode(String str) {
        try {
            return Base64.decodeBase64(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成种子
     *
     * @return
     */
    // private static byte[] getDefaultSeed() {
    // final byte[] initBytes1 = { 0x11, 0x22, 0x4F, 0x58, (byte) 0x88, 0x10,
    // 0x40, 0x38, 0x28, 0x27, 0x79, 0x51, (byte) 0xBC, (byte) 0xDD,
    // 0x55, 0x66, 0x71, 0x29, 0x74, (byte) 0x98, 0x30, 0x40, 0x36,
    // (byte) 0xE2 };
    //
    // final byte[] initBytes2 = { 0x10, 0x32, (byte) 0xF4, 0x25, (byte) 0x1F,
    // 0x01, 0x04, (byte) 0x99, 0x28, (byte) 0xF9 };
    //
    // try {
    // MessageDigest digest1 = MessageDigest.getInstance("MD5");
    // MessageDigest digest2 = MessageDigest.getInstance("MD5");
    //
    // byte[] seed1 = digest1.digest(initBytes1);
    // byte[] seed2 = digest2.digest(initBytes2);
    //
    // final int len = KEYLEN;
    // byte[] seed = new byte[len];
    //
    // Random rand = new Random(2010);
    // for (int i = 0; i < len; i = i + 2) {
    // do {
    // seed[i] = seed1[rand.nextInt(16)];
    // } while (seed[i] == 0x0);
    // do {
    // seed[i + 1] = seed2[rand.nextInt(16)];
    // } while (seed[i + 1] == 0x0);
    // }
    //
    // return seed;
    // } catch (Exception e) {
    // e.printStackTrace();
    // // ignor
    // return initBytes1;
    // }
    // }

    /**
     * 通过string返回密钥字节数组
     *
     * @param key
     * @return
     * @throws UnsupportedEncodingException
     */
    private static byte[] getKeyByString(String key) {
        byte[] oldKeys = null;
        try {
            oldKeys = key.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        byte[] newKeys = new byte[KEYLEN];
        for (int i = 0; i < oldKeys.length; i++) {
            if (i == KEYLEN) break;
            newKeys[i] = oldKeys[i];
        }
        return newKeys;
    }

    /**
     * 返回加密算法的密钥尺寸
     *
     * @param algorithm
     * @return
     */
    private static int getKeySize(String algorithm) {
        if (algorithm.equals(DES_ALGORITHM))
            return 56;
        else if (algorithm.equals(DESede_ALGORITHM))
            return 112;
        else if (algorithm.equals(AES_ALGORITHM))
            return 128;

        return 0;
    }
}
/*
 * 修改历史 $Log: CryptoUtil.java,v $
 * 修改历史 Revision 1.1  2013/10/11 17:45:46  haoyf
 * 修改历史 add:java 2 maven
 * 修改历史
 * 修改历史 Revision 1.2  2013/09/03 12:25:54  wuyh
 * 修改历史 update: to UTF-8
 * 修改历史
 * 修改历史 Revision 1.1  2013/08/26 08:42:55  wangwb
 * 修改历史 Add: 换新CVS
 * 修改历史
 * 修改历史 Revision 1.1  2013/08/19 04:19:07  haoyf
 * 修改历史 add: components.commons.utility
 * 修改历史
 * 修改历史 Revision 1.1  2013/08/16 10:42:45  wangwb
 * 修改历史 Update: 杩佺Щ浠ｇ爜 FOR_PTP50_201308161100
 * 修改历史
 * 修改历史 Revision 1.5  2010/06/07 02:41:41  chengy
 * 修改历史 Review：更改注释
 * 修改历史
 * 修改历史 Revision 1.4  2010/06/07 02:37:34  chengy
 * 修改历史 Add: 增加sha1加密算法
 * 修改历史
 * 修改历史 Revision 1.3  2010/06/05 05:54:40  chengy
 * 修改历史 Update: 增加md5的高级加密方法md5(String)
 * 修改历史
 * 修改历史 Revision 1.2  2010/05/13 09:13:32  chengy
 * 修改历史 Update: 去掉对common-lang的StringUtils的依赖
 * 修改历史
 * 修改历史 Revision 1.1  2010/01/26 01:35:29  wanglei
 * 修改历史 Add:迁移6.1CVS到6.2CVS上
 * 修改历史
 * 修改历史 Revision 1.2  2010/01/04 08:55:03  wuyh
 * 修改历史 Update:修改Base64实现方式
 * 修改历史
 * 修改历史 Revision 1.1  2009/11/18 07:11:15  wanglei
 * 修改历史 Add:提交到CVS。
 * 修改历史
 * 修改历史 Revision 1.1  2008/07/04 11:55:51  build
 * 修改历史 Added by Needle,Sxn,Sccot
 * 修改历史
 * 修改历史 Revision 1.8  2008/05/23 07:52:51  chengy
 * 修改历史 Add：将base64编码接口开放为public
 * 修改历史
 * 修改历史 Revision 1.7  2008/05/23 03:17:49  chengy
 * 修改历史 Update：更改注释
 * 修改历史
 * 修改历史 Revision 1.6  2008/05/23 03:12:19  chengy
 * 修改历史 Update： 完善了加密解密算法，原先代码生成key的大小不对，造成无法加密解密
 * 修改历史 Revision 1.5 2008/05/13 09:54:43 wuyh Update:增加加解密工具方法 Revision 1.4 2007/11/06 07:18:18 wanglei
 * Update:整理完成
 */