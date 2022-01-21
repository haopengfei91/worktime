package com.faymax.server.service;

import com.faymax.server.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faymax.server.entity.RespBean;
import com.faymax.server.entity.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Faymax
 * @since 2021-04-07
 */
public interface EmployeeService extends IService<Employee> {

    RespPageBean getEmployeeByPage(Integer currentpage, Integer size, Employee employee, LocalDate[] beginDateScope);

    RespBean maxWorkId();

    RespBean addEmp(Employee employee);

    List<Employee> getEmployee(Integer id);
}
