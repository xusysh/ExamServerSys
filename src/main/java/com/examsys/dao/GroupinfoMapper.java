package com.examsys.dao;

import com.examsys.model.Groupinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface GroupinfoMapper {



    Groupinfo selectByPrimaryKey(Integer id);

    List<Groupinfo> selectAll();

    int updateByPrimaryKey(Groupinfo record);


    /**
     * 插入组信息
     * @param record
     * @return
     */
    int insert(Groupinfo record);

    /**
     * 删除组
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);


    Groupinfo selectByGroupName(String groupName);


    Groupinfo selectByUserId(Integer userId);

}