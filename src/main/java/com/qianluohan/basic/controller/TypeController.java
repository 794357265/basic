package com.qianluohan.basic.controller;

import com.qianluohan.basic.entity.Item;
import com.qianluohan.basic.service.TypeService;
import com.qianluohan.basic.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/list")
    public Result getTypeList(){
        return Result.ok();
    }

    public Result saveItems(){
        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setRemark("test");
        items.add(item);
        typeService.saveItems(items);
        return Result.ok();
    }

}
