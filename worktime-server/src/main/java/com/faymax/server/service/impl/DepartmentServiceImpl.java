package com.faymax.server.service.impl;

import com.faymax.server.entity.Department;
import com.faymax.server.entity.RespBean;
import com.faymax.server.mapper.DepartmentMapper;
import com.faymax.server.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private Department department;

    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments(-1);
    }

    @Override
    public RespBean addDepartment(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDepartment(dep);
        if (1 == dep.getResult()) {
            return RespBean.success("添加部门成功", dep);
        }

        return RespBean.fail("添加部门失败");
    }

    @Override
    public RespBean deleteDepartment(Integer id) {
        department.setId(id);
        departmentMapper.deleteDepartment(department);
        if (-2 == department.getResult()) {
            return RespBean.fail("该部门下存在子部门，删除失败");
        }
        if (-1 == department.getResult()) {
            return RespBean.fail("该部门下存在员工，删除失败");
        }
        if (1 == department.getResult()) {
            return RespBean.success("删除部门成功");
        }
        return RespBean.fail("删除部门失败");
    }

}
