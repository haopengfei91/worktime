package com.faymax.server.exception;

import com.faymax.server.entity.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @Author: Faymax
 * @Description: 全局异常处理
 */

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RespBean mySqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.fail("该数据存在关联数据，操作失败");
        }
        return RespBean.fail("数据库异常，操作失败");
    }
}
