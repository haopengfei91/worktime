package com.faymax.server;

import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Faymax
 * @Description:
 */

@RestController
public class HelloController {

    @Test
    @GetMapping("hello")
    public String hello() {
        return "Hello";
    }
}
