package com.faymax.server.mapper;

import com.faymax.server.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRolesByAdminId(Integer id);
}
