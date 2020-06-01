package com.qianluohan.basic.controller;

import com.qianluohan.basic.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/type")
public class TypeController {

    @GetMapping("/list")
    public Result getTypeList(){
        return Result.ok();
    }

}
