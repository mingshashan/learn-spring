package com.mingshashan.learn.testorder.controller;

import com.mingshashan.learn.testorder.model.Response;
import com.mingshashan.learn.testorder.model.Test;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author xufj
 */
//@OpenAPIDefinition(info = @Info(title = "test管理"))
@Tag(name = "test管理")
@RestController()
@RequestMapping("test")
public class TestController {

    private static final Class T = new Response<Test>().getClass();

    @GetMapping
//    @Operation(method = "获取test", tags = {"获取test"}, summary = "获取test")
//    @Operation(method = "获取test", tags = {"获取test"})
    @Operation(tags = {"获取test"}, summary = "获取test")
    private Response<Test> get() {
        Test test = new Test();
        test.setzClass("com.aaa.bbb");
        return Response.of(test);
    }
}
