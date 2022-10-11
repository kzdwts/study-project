package top.kangyong.springboot.dep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * c
 *
 * @author Kang Yong
 * @date 2022/10/11
 * @since 1.0.0
 */
@Service
public class CService {

    @Autowired
    private AService aService;

    public void demoC() {
        System.out.println("===demoC");
        aService.demoA();;
    }
}
