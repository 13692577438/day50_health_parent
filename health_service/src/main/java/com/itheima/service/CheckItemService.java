package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;

public interface CheckItemService {
    int add(CheckItem checkItem);

    PageResult<CheckItem> findPage(QueryPageBean queryPageBean);
}
