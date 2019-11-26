package com.xuyewei.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * ClassName:BCryptPasswordEncoderUtils
 * Package:com.xuyewei.utils
 * Description:
 *
 * @Date:2019/11/26 21:05
 * @Author:xuyewei
 */

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder  = new BCryptPasswordEncoder();
    public static String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String pwd = "123";
        System.out.print(bCryptPasswordEncoder.encode(pwd));
    }
}
