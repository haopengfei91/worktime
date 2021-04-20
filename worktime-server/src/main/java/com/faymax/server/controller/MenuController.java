package com.faymax.server.controller;


import com.faymax.server.entity.Menu;
import com.faymax.server.service.AdminService;
import com.faymax.server.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */

@Api(tags = "MenuController")
@RestController
@RequestMapping("/system/cfg")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenusByAdminId() {
        return menuService.getMenusByAdminId();
    }
}
