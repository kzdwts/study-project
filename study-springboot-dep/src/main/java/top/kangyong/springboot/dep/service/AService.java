package top.kangyong.springboot.dep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * a
 *
 * @author Kang Yong
 * @date 2022/10/11
 * @since 1.0.0
 */
@Service
public class AService {

    @Autowired
    private BService bService;

    public void demoA() {
        System.out.println("===demoA");
        bService.demoB();
    }
}
