package com.faymax.server.controller;

import com.faymax.server.entity.HrLoginParam;
import com.faymax.server.entity.RespBean;
import com.faymax.server.service.HrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.callback.SecretKeyCallback;

/**
 * @Author: Faymax
 * @Description: 登录
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private HrService hrService;

    @ApiOperation(value = "返回token")
    @PostMapping("/login")
    public RespBean login(HrLoginParam hrLoginParam, SecretKeyCallback.Request request) {
        return hrService.login(hrLoginParam.getUsername(), hrLoginParam.getPassword(), request);
    }
}
