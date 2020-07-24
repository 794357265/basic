package com.qianluohan.basic.controller;

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
        MyPageUtil<Type> list = typeService.list1();
        System.out.println("list-->>"+ list);
        return Result.ok().put("data", list);
    }

}
