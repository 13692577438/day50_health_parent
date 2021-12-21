package com.itheima.controller;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.health.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import con.itheima.constant.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkItem")
public class CheckItemController {
    @Autowired
    private CheckItemService cs;

    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){
        int add = cs.add(checkItem);
        Result result=null;
        if (add>0){
             result=new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
        }else {
             result=new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return result;
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
        Result result=null;
        try {
            PageResult<CheckItem> pageResult = cs.findPage(queryPageBean);
             result=new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,pageResult);
        } catch (Exception e) {
            e.printStackTrace();
             result=new Result(true, MessageConstant.QUERY_CHECKITEM_FAIL);
        }
        return result;
    }
}
