package com.faymax.server.service.impl;

import com.faymax.server.entity.Admin;
import com.faymax.server.entity.Menu;
import com.faymax.server.mapper.MenuMapper;
import com.faymax.server.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenusByAdminId() {

        return menuMapper.getMenusByAdminId(((Admin) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getId());
    }

}
