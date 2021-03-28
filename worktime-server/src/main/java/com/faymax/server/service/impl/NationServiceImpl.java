package com.faymax.server.service.impl;

import com.faymax.server.entity.Nation;
import com.faymax.server.mapper.NationMapper;
import com.faymax.server.service.NationService;
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
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements NationService {

}
