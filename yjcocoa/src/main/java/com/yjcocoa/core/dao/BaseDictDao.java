package com.yjcocoa.core.dao;

import com.yjcocoa.core.po.BaseDict;
import java.util.List;

/**
 * 数据字典
 */
public interface BaseDictDao {

    // 根据类别代码查询数据字典
    public List<BaseDict> selectBaseDictByTypeCode(String typecode);

}
