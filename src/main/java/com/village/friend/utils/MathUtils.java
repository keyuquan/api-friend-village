package com.village.friend.utils;

public class MathUtils {

    /**
     * 生成随机验证码
     *
     * @return
     */
    public static int getAuthCode() {
        int a = 1000;
        int b = 10000;
        return (int) (Math.random() * (b - a)) + a;
    }
}
