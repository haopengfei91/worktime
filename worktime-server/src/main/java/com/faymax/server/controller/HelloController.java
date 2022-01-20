package com.faymax.server.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Faymax
 * @Description:
 */

@Api(tags = "HelloController")
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/employee/basic/hello")
    public String hello2() {
        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3() {
        return "/employee/advanced/hello";
    }
}
