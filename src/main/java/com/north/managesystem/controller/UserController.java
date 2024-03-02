package com.north.managesystem.controller;

import com.north.managesystem.common.CommonDto;
import com.north.managesystem.common.PageDto;
import com.north.managesystem.pojo.User;
import com.north.managesystem.service.UserService;
import org.springframework.web.bind.annotation.*;

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

        //commonDto封装PageDto将分页数据传给前端
        CommonDto<PageDto<User>> commonDto = new CommonDto<>();
        PageDto<User> list = userService.getList(user);
        commonDto.setContent(list);
        return commonDto;
    }

    @PostMapping("/saveOrUpdate")
    public CommonDto saveOrUpdate(@RequestBody User user){
        CommonDto<User> commonDto = new CommonDto<>();
        boolean b = userService.saveOrUpdate(user);
        if(b){
            commonDto.setMessage("更改成功");
        }else{
            commonDto.setMessage("更改失败");
        }
        return commonDto;
    }

}
