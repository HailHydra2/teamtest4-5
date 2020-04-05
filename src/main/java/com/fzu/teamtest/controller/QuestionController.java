package com.fzu.teamtest.controller;

import com.fzu.teamtest.dao.QuestionDao;
import com.fzu.teamtest.dao.ResponseDao;
import com.fzu.teamtest.dao.UserDao;
import com.fzu.teamtest.model.AjaxResponse;
import com.fzu.teamtest.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Controller
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private QuestionDao questionDao;

    @PostMapping("/question")
    public @ResponseBody AjaxResponse addQuestion(@RequestBody Question question){
        questionDao.insert(question);
        return AjaxResponse.success(question);

    }

    @GetMapping("/questions/{id}")
    public @ResponseBody AjaxResponse getQuestion(@PathVariable int id){
        return AjaxResponse.success(questionDao.selectByPrimaryKey(id));
    }

    @PutMapping("/questions/{id}")
    public @ResponseBody AjaxResponse updateQuestion(@PathVariable int id, @RequestBody Question question){
        question.setId(id);
        questionDao.updateByPrimaryKey(question);
        return AjaxResponse.success(question);
    }

    @DeleteMapping("/question/{id}")
    public @ResponseBody AjaxResponse deleteQuestion(@PathVariable int id){
        questionDao.deleteByPrimaryKey(id);
        return AjaxResponse.success(id);
    }


}
