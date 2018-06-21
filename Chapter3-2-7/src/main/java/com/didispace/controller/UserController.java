package com.didispace.controller;

import com.didispace.domain.User;
import com.didispace.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



/**
 * @Author: george
 * @Date: 2018/6/21-09-43
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User queryUser(@RequestParam(value = "name",required = false) String name){
        System.out.println(name);
        return userMapper.findByName(name);
    }

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody User user){
        System.out.println(user.getName());
        userMapper.insert(user.getName(),user.getAge());
    }
}
