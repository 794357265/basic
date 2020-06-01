package com.qianluohan.basic.controller;

import com.qianluohan.basic.exception.CustomizedException;
import com.qianluohan.basic.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class BasicController {

    @GetMapping("/")
    public String index(){
        //此处返回index.html页面
        return "index";
    }

    @GetMapping("/index1")
    @ResponseBody
    public Map<String, Object> index1(){
        //此处返回json数据
        return Result.ok();
    }

    @GetMapping("/index2")
    @ResponseBody
    public Map<String, Object> index2(){
        throw new CustomizedException("test");
    }

}
