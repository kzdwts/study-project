package top.kangyong.study.jwt.core.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * jwt工具类
 *
 * @author Kang Yong
 * @date 2024/9/27
 * @since 1.0.0
 */
public class JwtUtil {

    private static final String SECRET = "L7A/6zARSkK1j7Vd5SDD9pSSqZlqF7mAhiOgRbgv9Smce6tf4cJnvKOjtKPxNNnWQj+2lQEScm3XIUjhW+YVZg==";
    private static final long EXPIRATION = 86400000; // 1 day in milliseconds


    public static String genJwt(long time, String path) {
        return Jwts.builder()
                .claim("time", time)
                .claim("path", path)
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();
    }

}
