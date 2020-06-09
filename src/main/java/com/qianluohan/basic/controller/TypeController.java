package com.qianluohan.basic.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianluohan.basic.entity.Type;
import com.qianluohan.basic.service.TypeService;
import com.qianluohan.basic.utils.MyPageUtil;
import com.qianluohan.basic.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/list")
    public Result getTypeList(){
        PageHelper.startPage(2, 3);
        Page<Type> list = typeService.list();
        System.out.println("list-->>"+ list);
        return Result.ok().put("data", new MyPageUtil<Type>(list));
    }

}
