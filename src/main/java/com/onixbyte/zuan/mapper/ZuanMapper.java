package com.onixbyte.zuan.mapper;

import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.onixbyte.zuan.entity.Zuan;

/**
 * ZuanMapper
 *
 * @author Zihlu Wang
 * @since 22 Sept, 2023
 */
public interface ZuanMapper extends BaseMapper<Zuan> {

    @Select("""
            <script>
            select id, text, level
              from zuan
            <if test="level != null and level != ''">
             where level = #{level}
            </if>
            order by rand()
            limit 1;
            </script>
            """)
    Zuan selectOneRandomly(@Param("level") String level);

}
