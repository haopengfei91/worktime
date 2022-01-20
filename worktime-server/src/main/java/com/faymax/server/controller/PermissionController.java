package com.faymax.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.faymax.server.entity.Menu;
import com.faymax.server.entity.MenuRole;
import com.faymax.server.entity.RespBean;
import com.faymax.server.entity.Role;
import com.faymax.server.service.MenuRoleService;
import com.faymax.server.service.MenuService;
import com.faymax.server.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Faymax
 * @Description: 权限组
 */

@Api(tags = "PermissionController")
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissionController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuRoleService menuRoleService;


    @ApiOperation(value = "获取角色信息")
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/")
    public RespBean addRole(@RequestBody Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        if (roleService.save(role)) {
            return RespBean.success("添加角色成功");
        }
        return RespBean.fail("添加角色失败");
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid) {
        if (roleService.removeById(rid)) {
            return RespBean.success("删除角色成功");
        }
        return RespBean.fail("删除角色失败");
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid) {
        return menuRoleService.list(new QueryWrapper<MenuRole>()
                .eq("rid", rid))
                .stream()
                .map(MenuRole::getMid)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        return menuRoleService.updateMenuRole(rid, mids);
    }
}
