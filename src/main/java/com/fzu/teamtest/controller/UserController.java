package com.fzu.teamtest.controller;

import com.fzu.teamtest.dao.UserDao;
import com.fzu.teamtest.model.AjaxResponse;
import com.fzu.teamtest.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserDao userDao;

    @RequestMapping("/add")
    public @ResponseBody AjaxResponse addUser(@RequestBody User user){
        userDao.insert(user);
        return AjaxResponse.success(user);
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody AjaxResponse deleteUser(@PathVariable int id){
        userDao.deleteByPrimaryKey(id);
        return AjaxResponse.success();
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody AjaxResponse updateUser(@PathVariable int id,@RequestBody User user){
        user.setId(id);
        userDao.updateByPrimaryKeySelective(user);
        return AjaxResponse.success(user);
    }

    @RequestMapping("/get/{id}")
    public @ResponseBody AjaxResponse getUser(@PathVariable int id){
        return AjaxResponse.success(userDao.selectByPrimaryKey(id));
    }
}
