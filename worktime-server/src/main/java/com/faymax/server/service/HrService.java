package com.faymax.server.service;

import com.faymax.server.entity.Hr;
import com.baomidou.mybatisplus.extension.service.IService;
import com.faymax.server.entity.RespBean;

import javax.security.auth.message.callback.SecretKeyCallback;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */
public interface HrService extends IService<Hr> {

    /**
     * 返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    RespBean login(String username, String password, SecretKeyCallback.Request request);
}
