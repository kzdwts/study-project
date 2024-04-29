package top.kangyong.springboot.property.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.springboot.property.service.AutoService;

/**
 * 测试通过构造方法注入
 *
 * @author Kang Yong
 * @date 2024/4/29
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/auto")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @PostMapping("/do")
    public String auto() {
        autoService.doIt();
        return "成功";
    }
}
