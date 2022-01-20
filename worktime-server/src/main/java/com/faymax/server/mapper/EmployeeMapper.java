package com.faymax.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faymax.server.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faymax.server.entity.RespPageBean;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Faymax
 * @since 2021-04-07
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    IPage<Employee> getEmployeeByPage(Page<Employee> page,
                                      @Param("employee") Employee employee,
                                      @Param("beginDateScope") LocalDate[] beginDateScope);


}
