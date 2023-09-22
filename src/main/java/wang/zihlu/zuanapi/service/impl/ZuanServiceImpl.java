package wang.zihlu.zuanapi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.zihlu.zuanapi.entity.Zuan;
import wang.zihlu.zuanapi.mapper.ZuanMapper;
import wang.zihlu.zuanapi.service.ZuanService;

/**
 * ZuanServiceImpl
 *
 * @author Zihlu Wang
 * @since 22 Sept, 2023
 */
@Service
public class ZuanServiceImpl extends ServiceImpl<ZuanMapper, Zuan> implements ZuanService {
    @Override
    public Zuan getRandomOne(String level) {
        return mapper.selectOneRandomly(level);
    }
}
