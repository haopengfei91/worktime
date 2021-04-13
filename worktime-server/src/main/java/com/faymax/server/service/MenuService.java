package com.faymax.server.service;

import com.faymax.server.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faymax.server.entity.Role;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
public interface MenuService extends IService<Menu> {

    /**
     * 通过用户id查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

}
