package com.itheima.dao;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
    int add(CheckItem checkItem);
    /**
     * 查询表的总记录数 ，但是不能盲目的认为就是整张表的总记录数，因为可能会有附带的查询条件。
     * @param queryPageBean
     * @return
     */
    long findCount(QueryPageBean queryPageBean);
    /**
     * 查询所有
     * @return
     */
    List<CheckItem> findPage(QueryPageBean queryPageBean);


}
