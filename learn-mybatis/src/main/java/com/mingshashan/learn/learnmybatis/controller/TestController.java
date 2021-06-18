package com.mingshashan.learn.learnmybatis.controller;

import com.mingshashan.learn.learnmybatis.response.Response;
import com.mingshashan.learn.learnmybatis.service.TestService;
import com.mingshashan.learn.learnmybatis.validation.ValidationGroup;
import com.mingshashan.learn.learnmybatis.vo.Test02VO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping
    public Response saveTest(@RequestBody
                             @NotEmpty
                             @ValidationGroup.Create Test02VO test02VO) {

        testService.saveTest(test02VO);
        return Response.ok();
    }

}
