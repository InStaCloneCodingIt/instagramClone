package org.insta.application.app.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class EncryptUtil {

    private static final String AES = "AES";
    private static String secretKey;    //16bit
    private static String IV;           //16bit
    static final String BASE62 = "ABCDEFGHIJKLMNOPOPQRSTUVWXYZabcdefghijklmnopopqrstuvwxyz01234556789";

    static {
        Properties properties = new Properties();
        try {
            Reader reader = Resources.getResourceAsReader("secretkey.properties");
            properties.load(reader);

            secretKey = properties.getProperty("secretKey");
            if (Objects.nonNull(secretKey)) {
                IV = secretKey.substring(0,16);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * SHA-256 암호화
     */
    public static String sha256Enc(String rawVal) {
        MessageDigest sh;
        StringBuffer sb = new StringBuffer();

        try {
            sh = MessageDigest.getInstance("SHA-256");
            sh.update(rawVal.getBytes());

            byte[] byteData = sh.digest();
            for( int j=0; j< byteData.length; j++) {
                sb.append(Integer.toString((byteData[j] & 0xff) + 0x100,16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }
        return sb.toString();
    }

}