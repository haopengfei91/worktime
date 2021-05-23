package com.faymax.server.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.faymax.server.entity.Admin;
import com.faymax.server.entity.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faymax.server.entity.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    Integer addAdminRole(@Param("aid") Integer adminId, @Param("rids") Integer[] rids);

}
