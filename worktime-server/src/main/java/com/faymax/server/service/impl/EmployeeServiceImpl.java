package com.faymax.server.service.impl;

import com.faymax.server.entity.Employee;
import com.faymax.server.mapper.EmployeeMapper;
import com.faymax.server.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
