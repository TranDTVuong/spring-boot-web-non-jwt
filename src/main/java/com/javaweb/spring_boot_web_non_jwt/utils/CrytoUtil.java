package com.javaweb.spring_boot_web_non_jwt.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import lombok.experimental.UtilityClass;

import static com.javaweb.spring_boot_web_non_jwt.constants.Constant.*;

import java.util.Base64;

@UtilityClass
public class CrytoUtil {
    public static String sign(String key, String data)
    {
        try {
            Mac mac = Mac.getInstance(HMACSHA256_ALGORITHM);
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), HMACSHA256_ALGORITHM);
            mac.init(secretKey);
            byte[] hash = mac.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
