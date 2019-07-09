package com.dongren.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author dongren
 * @create 2019-07-04 16:28
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        System.out.println(encodePassword("1234"));
    }
}
