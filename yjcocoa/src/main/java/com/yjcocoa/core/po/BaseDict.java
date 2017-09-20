package com.yjcocoa.core.po;

import java.io.Serializable;

/**
 * 数据字典持久化类
 */
public class BaseDict implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;         // 数据字典id
    private String type_code;  // 数据字典类别代码
    private String type_name;  // 数据字典类别名称
    private String item_name;  // 数据字典项目名称
    private String item_code;  // 数据字典项目代码
    private Integer sort;      // 排序字段
    private String enable;     // 是否可用
    private String memo;       // 备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "BaseDict{" +
                "id=" + id +
                ", type_code='" + type_code + '\'' +
                ", type_name='" + type_name + '\'' +
                ", item_name='" + item_name + '\'' +
                ", item_code='" + item_code + '\'' +
                ", sort=" + sort +
                ", enable='" + enable + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
