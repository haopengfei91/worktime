package com.faymax.server.service;

import com.faymax.server.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faymax.server.entity.Menu;
import com.faymax.server.entity.RespBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
public interface AdminService extends IService<Admin> {

    /**
     * 返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名返回对象
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

}
