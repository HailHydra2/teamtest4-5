package com.fzu.teamtest.controller;

import com.fzu.teamtest.dao.QuestionDao;
import com.fzu.teamtest.model.AjaxResponse;
import com.fzu.teamtest.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Controller
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private QuestionDao questionDao;

    @RequestMapping("/question")
    public @ResponseBody AjaxResponse addQuestion(@RequestBody Question question){
        questionDao.insert(question);
        return AjaxResponse.success(question);
    }

    @RequestMapping("/questions/{id}")
    public @ResponseBody AjaxResponse getQuestion(@PathVariable int id){
        return AjaxResponse.success(questionDao.selectByPrimaryKey(id));
    }

    
}
