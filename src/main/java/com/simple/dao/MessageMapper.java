package com.simple.dao;

import com.simple.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    int uploadMessage(@Param("name") String name, @Param("email") String email, @Param("phone") String phone, @Param("message") String message);

    List<Message> getAllMessage();

    int deleteMessage(@Param("message") String message, @Param("phone") String phone);


}