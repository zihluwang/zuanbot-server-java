package com.onixbyte.zuan.service;

import com.onixbyte.zuan.entity.Zuan;
import com.onixbyte.zuan.mapper.ZuanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ZuanService
 *
 * @author Zihlu Wang
 * @since 22 Sept, 2023
 */
@Service
public class ZuanService {

    private final ZuanMapper zuanMapper;

    @Autowired
    public ZuanService(ZuanMapper zuanMapper) {
        this.zuanMapper = zuanMapper;
    }

    public Zuan getRandomOne(String level) {
        return zuanMapper.selectOneRandomly(level);
    }

}
