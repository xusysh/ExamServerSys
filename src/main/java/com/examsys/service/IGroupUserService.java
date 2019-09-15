package com.examsys.service;

import com.examsys.model.entity.ResponseEntity;

import java.util.Map;

/**
 * Created by twinkleStar on 2019/9/3.
 */
public interface IGroupUserService {

    /**
     * 获取组-用户列表
     * todo:组加上admin用户ID
     * @return
     */
    ResponseEntity getGroupUserInfo();

    ResponseEntity addNewGroupUser(Map<String,Object> map);

    ResponseEntity getGroupUserByGid(int groupId);

    ResponseEntity updateUserGroupRelation(Map<String,Object> map);

    ResponseEntity getUserGroupInfo();
}
