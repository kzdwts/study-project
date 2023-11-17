package top.kangyong.springboot.property.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 单例测试
 *
 * @author Kang Yong
 * @date 2023/11/17
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/property")
public class SingleController {


    private List<String> nameList = new ArrayList<>();

    @PostMapping("/getNameList")
    public String getNameList(@RequestBody List<String> paramList) {
        nameList.forEach(System.out::println);
        nameList = paramList;
        return nameList.stream().collect(Collectors.joining());
    }

}
