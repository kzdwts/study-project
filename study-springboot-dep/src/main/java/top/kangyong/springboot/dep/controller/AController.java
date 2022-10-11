package top.kangyong.springboot.dep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.springboot.dep.service.AService;

/**
 * a
 *
 * @author Kang Yong
 * @date 2022/10/11
 * @since 1.0.0
 */
@RestController
public class AController {

    @Autowired
    private AService aService;

    @GetMapping("/demoA")
    public String demoA() {
        aService.demoA();
        return "demoA";
    }
}
