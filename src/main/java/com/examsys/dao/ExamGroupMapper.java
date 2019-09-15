package com.examsys.dao;

import com.examsys.model.ExamGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExamGroupMapper {
    int insert(ExamGroup record);

    List<ExamGroup> selectAll();
}