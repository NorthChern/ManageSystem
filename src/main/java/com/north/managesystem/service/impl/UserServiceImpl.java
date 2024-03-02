package com.north.managesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.north.managesystem.mapper.UserMapper;
import com.north.managesystem.pojo.User;
import com.north.managesystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List getList(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //判断前端是否传来参数
        if(ObjectUtils.isNotEmpty(user.getUsername())){
            //进行模糊查询
            queryWrapper.lambda().like(User::getUsername, user.getUsername());
        }
        List<User> userList = userMapper.selectList(queryWrapper);
        return userList;
    }
}
