package com.faymax.server.service;

import com.faymax.server.entity.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faymax.server.entity.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
public interface MenuRoleService extends IService<MenuRole> {

    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
