package top.kangyong.study.jwt.core.util;

import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO description .
 *
 * @author Kang Yong
 * @date 2024/9/27
 * @since 1.0.0
 */
public class JwtUtilTest {




    @Test
    public void genJwt() {
        String jwt = JwtUtil.genJwt(System.currentTimeMillis() + 100000, "2024-05-06/F5CC0C4C-70B0-11EF-AC73-D2B073755160/测试文件名称.jpg");
        System.out.println(jwt);
    }

}