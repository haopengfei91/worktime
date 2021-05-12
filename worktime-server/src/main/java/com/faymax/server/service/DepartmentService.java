package com.faymax.server.service;

import com.faymax.server.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faymax.server.entity.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
public interface DepartmentService extends IService<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();

    RespBean addDepartment(Department dep);

    RespBean deleteDepartment(Integer id);
}
