package com.faymax.server.service.impl;

import com.faymax.server.entity.Oplog;
import com.faymax.server.mapper.OplogMapper;
import com.faymax.server.service.OplogService;
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
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements OplogService {

}
