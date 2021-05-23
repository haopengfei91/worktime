package com.faymax.server.controller;


import com.faymax.server.entity.Admin;
import com.faymax.server.entity.RespBean;
import com.faymax.server.entity.Role;
import com.faymax.server.service.AdminService;
import com.faymax.server.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
@Api(tags = "AdminController")
@RestController
@RequestMapping("/system/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取所有操作员")
    @GetMapping("/")
    public List<Admin> getAllAdmins(String keyWords) {
        return adminService.getAllAdmins(keyWords);
    }

    @ApiOperation(value = "更新操作员")
    @PutMapping("/")
    public RespBean updateAdmin(@RequestBody Admin admin) {
        if (adminService.updateById(admin)) {
            return RespBean.success("更新管理员成功");
        }
        return RespBean.fail("更新管理员失败");
    }

    @ApiOperation(value = "刪除操作员")
    @DeleteMapping("/{id}")
    public RespBean deleteAdmin(@PathVariable Integer id) {
        if (adminService.removeById(id)) {
            return RespBean.success("删除管理员成功");
        }
        return RespBean.fail("删除管理员失败");
    }

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @ApiOperation(value = "更新操作员角色")
    @PutMapping("/role")
    public RespBean updateAdminRole(Integer adminId, Integer[] rids) {
        return adminService.updateAdminRole(adminId, rids);
    }
}
