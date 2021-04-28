package com.faymax.server.mapper;

import com.faymax.server.entity.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {


    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);

}
