package com.north.managesystem.controller;

import com.north.managesystem.common.CommonDto;
import com.north.managesystem.pojo.User;
import com.north.managesystem.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    //测试
//    @GetMapping("test")
//    public void test(){
//        System.out.println("0");
//    }
//
//    @GetMapping("test1")
//    public CommonDto test1(){
//        System.out.println("1");
//        CommonDto commonDto = new CommonDto();
//        commonDto.setContent("content");
//        commonDto.setMessage("message");
//        return commonDto;
//    }

    @Resource
    private UserService userService;

    @GetMapping("/getList")
    public CommonDto getList(User user){

        CommonDto<Object> commonDto = new CommonDto<>();
        List list = userService.getList(user);
        commonDto.setContent(list);
        return commonDto;
    }

}
