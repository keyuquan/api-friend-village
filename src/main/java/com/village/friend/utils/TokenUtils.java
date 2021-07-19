package com.village.friend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zm
 * @desc 使用token验证用户是否登录
 **/
public class TokenUtils {
    //设置过期时间
    private static final long EXPIRE_DATE = 7 * 24 * 60 * 60 * 1000;
    //token秘钥
    private static final String TOKEN_SECRET = "YXA65t40PgMxozp6X6PIKnoR3mInxAI";

    public static String token(String username, String password) {

        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("password", password)
                    .withExpiresAt(date) // 设置超时时间
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    public static boolean verify(String username, String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();

            DecodedJWT verify = verifier.verify(token);
            String usernameJWT = verify.getClaim("username").asString();
            if (username != null && username.equals(usernameJWT)) {
                return true;
            }

            return false;

        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String username = "zhangsan";
        String password = "123";
        String token = token(username, password);
        System.out.println(token);
        boolean b = verify("zhangsan", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMyIsInVzZXJuYW1lIjoiemhhbmdzYW4ifQ.yQXy6t55tdABMNGsZUstd4M4idtWCvwrQgwRSUd4sYM");
        System.out.println(b);
    }
}