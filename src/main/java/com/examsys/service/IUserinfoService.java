package com.examsys.service;

import com.examsys.model.entity.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * Created by twinkleStar on 2019/8/26.
 */
public interface IUserinfoService {

    /**
     * 通过模板批量导入用户
     * @param multipartFile
     * @return
     */
    ResponseEntity addNewUsers(MultipartFile multipartFile)throws IllegalStateException, IOException;

    /**
     * 根据用户名、密码查询单个用户
     * @param username
     * @param password
     * @return
     */
    ResponseEntity selectUser(String username, String password);

    ResponseEntity deleteUsers(Map<String,Object> map);

}
