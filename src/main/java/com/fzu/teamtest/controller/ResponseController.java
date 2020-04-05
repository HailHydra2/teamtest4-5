package com.fzu.teamtest.controller;

import com.fzu.teamtest.dao.ResponseDao;
import com.fzu.teamtest.model.AjaxResponse;
import com.fzu.teamtest.model.Question;
import com.fzu.teamtest.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@Controller
@RequestMapping("/response")

public class ResponseController {
    @Resource
    private ResponseDao responseDao;

    @PostMapping("/add")
    public @ResponseBody AjaxResponse addResponse(@RequestBody Response response){
        responseDao.insert(response);
        return AjaxResponse.success(response);
    }
    @GetMapping("/get/{id}")
    public @ResponseBody AjaxResponse getResponse(@PathVariable int id){
        return AjaxResponse.success(responseDao.selectByPrimaryKey(id));
    }

    @PutMapping("/update/{id}")
    public @ResponseBody AjaxResponse updateResponse(@PathVariable int id, @RequestBody Response response){
        response.setId(id);
        responseDao.updateByPrimaryKey(response);
        return AjaxResponse.success(response);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody AjaxResponse deleteResponse(@PathVariable int id){
        responseDao.deleteByPrimaryKey(id);
        return AjaxResponse.success(id);
    }
}
