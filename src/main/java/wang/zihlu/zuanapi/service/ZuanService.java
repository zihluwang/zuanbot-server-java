package wang.zihlu.zuanapi.service;

import com.mybatisflex.core.service.IService;
import wang.zihlu.zuanapi.entity.Zuan;

/**
 * ZuanService
 *
 * @author Zihlu Wang
 * @since 22 Sept, 2023
 */
public interface ZuanService extends IService<Zuan> {

    Zuan getRandomOne(String level);

}
