package wang.zihlu.zuanapi.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * Zuan
 *
 * @author Zihlu Wang
 * @since 22 Sept, 2023
 */
@Table("main")
@Data
public class Zuan {

    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String text;

    private String level;

}
