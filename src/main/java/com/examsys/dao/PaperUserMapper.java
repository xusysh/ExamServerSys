package com.examsys.dao;

import com.examsys.model.PaperUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface PaperUserMapper {
    int insert(PaperUser record);

    List<PaperUser> selectAll();
}