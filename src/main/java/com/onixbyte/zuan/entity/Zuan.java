package com.onixbyte.zuan.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

/**
 * Zuan
 *
 * @author Zihlu Wang
 * @since 22 Sept, 2023
 */
@Table("zuan")
public class Zuan {

    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String text;

    private String level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Zuan() {
    }

    public Zuan(Integer id, String text, String level) {
        this.id = id;
        this.text = text;
        this.level = level;
    }
}
