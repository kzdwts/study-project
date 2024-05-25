package com.kangyong.mpdm.controller;

import com.kangyong.mpdm.domain.TbStu;
import com.kangyong.mpdm.service.TbStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * student
 *
 * @author Kang Yong
 * @date 2024/5/26
 * @since 1.0.0
 */
@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private TbStuService stuService;

    @PostMapping("/save")
    public String save(@RequestBody TbStu tbStu) {
        boolean b = stuService.save(tbStu);
        return b ? "ok" : "error";
    }
}
