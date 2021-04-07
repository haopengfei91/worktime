package com.faymax.server.mapper;

import com.faymax.server.entity.Admin;
import com.faymax.server.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
public interface MenuMapper extends BaseMapper<Menu> {

    public List<Menu> getMenusByAdminId(Integer id);

}
