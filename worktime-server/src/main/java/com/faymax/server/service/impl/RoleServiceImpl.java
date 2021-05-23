package com.faymax.server.service.impl;

import com.faymax.server.entity.RespBean;
import com.faymax.server.entity.Role;
import com.faymax.server.mapper.RoleMapper;
import com.faymax.server.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

}
