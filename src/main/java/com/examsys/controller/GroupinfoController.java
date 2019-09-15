package com.examsys.controller;

import com.examsys.model.Groupinfo;
import com.examsys.model.entity.ResponseEntity;
import com.examsys.service.IGroupinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by twinkleStar on 2019/9/4.
 */

@RestController
@RequestMapping("/upi/group")
public class GroupinfoController {

    @Autowired
    IGroupinfoService iGroupinfoService;

    @PostMapping("/single")
    public ResponseEntity addSingleGroup(@RequestBody Groupinfo groupinfo) {
        ResponseEntity responseEntity=iGroupinfoService.addGroupinfo(groupinfo);
        return responseEntity;
    }

    @DeleteMapping("/single")
    public ResponseEntity deleteUsers(@RequestBody Map<String,Integer> map) {
        ResponseEntity responseEntity = iGroupinfoService.deleteGroup(map);
        return responseEntity;
    }

    @PostMapping("/uid")
    public ResponseEntity getGroupByUserId(@RequestBody Map<String,Integer> map) {
        ResponseEntity responseEntity=iGroupinfoService.getGroupByUserId(map.get("id"));
        return responseEntity;
    }
}
