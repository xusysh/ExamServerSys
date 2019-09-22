package com.examsys.controller;

import com.examsys.model.PaperQuestion;
import com.examsys.model.Questioninfo;
import com.examsys.model.entity.ResponseEntity;
import com.examsys.service.Impl.PaperQuestionServiceImpl;
import com.examsys.service.Impl.QuestioninfoServiceImpl;
import com.examsys.util.ExcelAnalysisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by twinkleStar on 2019/9/22.
 */

@RestController
@RequestMapping("/question")
public class QuestioninfoController {


    @Autowired
    ExcelAnalysisUtil excelAnalysisUtil;
    @Autowired
    PaperQuestionServiceImpl paperQuestionService;
    @Autowired
    QuestioninfoServiceImpl questioninfoService;


    @PostMapping(value = "/excel")
    @Transactional
    public ResponseEntity addNewQuestionByExcel(
            @RequestParam( value="files[]",required=false)MultipartFile[] multipartFiles)throws IllegalStateException, IOException {
        MultipartFile file=multipartFiles[0];
        List<Questioninfo> questioninfoList=excelAnalysisUtil.addNewQuestion(file);
        ResponseEntity responseEntity=questioninfoService.addNewQuestions(questioninfoList);
        return responseEntity;
    }

    @PostMapping(value = "/new")
    @Transactional
    public ResponseEntity addNewPaperByFront(@RequestBody List<Map<String,Object>> mapRes) {
        List<Questioninfo> questioninfoList=questioninfoService.handleNewQuestions(mapRes);
        ResponseEntity responseEntity=questioninfoService.addNewQuestions(questioninfoList);
        return responseEntity;
    }
}
