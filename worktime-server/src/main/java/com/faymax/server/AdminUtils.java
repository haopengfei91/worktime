package com.faymax.server;

import com.faymax.server.entity.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: Faymax
 * @Description: 操作员工具类
 */
public class AdminUtils {

    public static Admin getCurrentAdmin() {
        return (Admin) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
