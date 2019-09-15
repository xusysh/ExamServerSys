package com.examsys.service;

import com.examsys.model.Groupinfo;
import com.examsys.model.entity.ResponseEntity;

import java.util.Map;

/**
 * Created by twinkleStar on 2019/9/4.
 */
public interface IGroupinfoService {

    ResponseEntity addGroupinfo(Groupinfo groupinfo);

    ResponseEntity getGroupByUserId(int userId);

    ResponseEntity deleteGroup(Map<String,Integer> map);
}
