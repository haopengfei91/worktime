package com.faymax.server.mapper;

import com.faymax.server.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faymax.server.entity.Menu;
import com.faymax.server.entity.RespBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
public interface AdminMapper extends BaseMapper<Admin> {


    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keyWords);

}
