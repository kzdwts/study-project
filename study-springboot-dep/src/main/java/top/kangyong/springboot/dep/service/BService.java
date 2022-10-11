package top.kangyong.springboot.dep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * b
 *
 * @author Kang Yong
 * @date 2022/10/11
 * @since 1.0.0
 */
@Service
public class BService {

    @Autowired
    private CService cService;

    public void demoB() {
        System.out.println("===demoB");
        cService.demoC();
    }
}
