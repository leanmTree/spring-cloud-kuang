package com.lemon.tools;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hengtao.wu
 * @Date 2020/11/9 11:32
 **/
public class JwtTest {
    public static void main(String[] args) {
        getToken();
       // System.out.println(checkToken("eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJsZW1vbiIsImlhdCI6MTYwNDg5MzA4MSwiZXhwIjoxNjA0ODkzMTE2LCJzdWIiOiJqd3Tku6TniYwifQ.vXFhXuj3wuKEl80lENoGMvVtiJLAKKJG0eWJm7pWvrs"));
        System.out.println(checkToken(getToken()));
    }
    public static String getToken() {
        JwtBuilder builder = Jwts.builder();
        builder.setIssuer("lemon");  //颁发者
        builder.setIssuedAt(new Date()); //颁发时间
        builder.setExpiration(new Date(System.currentTimeMillis() + 350000));  //过期时间35秒
        builder.setSubject("jwt令牌");  //token主题
        builder.signWith(SignatureAlgorithm.HS256, "lemon");  //设置加密算法、唯一秘钥(盐)
        Map<String, Object> map = new HashMap<>();
        map.put("userId", "asdfhqi23ihreuisadfa");
        map.put("userNmae", "lemon");
        map.put("phone", "15554356789");
        map.put("companyId", "A1001");
        builder.addClaims(map);
        //或者
//
//        builder.claim("userId", "asdfhqi23ihreuisadfa")
//                .claim("userNmae", "lemon")
//                .claim("phone", "15554356789")
//                .claim("companyId", "A1001");
        String compact = builder.compact();
        System.out.println(compact);
        return compact;
    }
    public static boolean checkToken(String token) {
        Claims lemon = null;
        try {
            lemon = Jwts.parser().setSigningKey("lemon").parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println(lemon.toString());
        return true;
    }
}
