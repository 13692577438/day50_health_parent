package com.itheima.service.impl;

import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao dao;
    @Override
    public int add(CheckItem checkItem) {
       return dao.add(checkItem);
    }

    @Override
    public PageResult<CheckItem> findPage(QueryPageBean queryPageBean) {
        long total=dao.findCount(queryPageBean);
        List<CheckItem> rows=dao.findPage(queryPageBean);
       PageResult pageResult=new PageResult(total,rows);
       return pageResult;
    }
}
