package com.examsys.service.Impl;

import com.examsys.dao.GroupUserMapper;
import com.examsys.dao.GroupinfoMapper;
import com.examsys.model.GroupUser;
import com.examsys.model.Groupinfo;
import com.examsys.model.entity.ResponseEntity;
import com.examsys.service.IGroupinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by twinkleStar on 2019/9/4.
 */

@Repository
public class GroupinfoServiceImpl implements IGroupinfoService {


    @Autowired
    GroupinfoMapper groupinfoMapper;
    @Autowired
    GroupUserMapper groupUserMapper;

    public ResponseEntity addGroupinfo(Groupinfo groupinfo){
        ResponseEntity responseEntity=new ResponseEntity();
        Groupinfo infoAlready=groupinfoMapper.selectByGroupName(groupinfo.getGroupName());
        if(infoAlready!=null){
            responseEntity.setStatus(-1);
            responseEntity.setMsg("组已存在,组名不可重复");
            return responseEntity;
        }else{
            int res=groupinfoMapper.insert(groupinfo);

            if(res<0){
                responseEntity.setStatus(-1);
                responseEntity.setMsg("添加失败");

            }else{
                responseEntity.setStatus(200);
                responseEntity.setMsg("添加组成功");
                responseEntity.setData(groupinfo);
            }

            return responseEntity;
        }

    }


    public ResponseEntity getGroupByUserId(int userId){
        ResponseEntity responseEntity=new ResponseEntity();
        Groupinfo groupinfo=groupinfoMapper.selectByUserId(userId);
        if (groupinfo != null) {
            responseEntity.setStatus(200);
            responseEntity.setMsg("查询成功");
            responseEntity.setData(groupinfo);
        }else{
            responseEntity.setStatus(-1);
            responseEntity.setMsg("该用户不属于任何一个组");
        }

        return responseEntity;
    }




    public ResponseEntity deleteGroup(Map<String,Integer> map){
        int groupId=map.get("id");
        List<GroupUser> groupUsers=groupUserMapper.selectByGroupId(groupId);
        if (groupUsers==null ||groupUsers.size()==0){

            //todo:加上试卷后需要改动
        }else {
            int delRelation=groupUserMapper.deleteByGroupId(groupId);
        }
        int delRes=groupinfoMapper.deleteByPrimaryKey(groupId);

        ResponseEntity responseEntity=new ResponseEntity();
        responseEntity.setStatus(200);
        responseEntity.setMsg("删除成功");
        return responseEntity;
    }
}
