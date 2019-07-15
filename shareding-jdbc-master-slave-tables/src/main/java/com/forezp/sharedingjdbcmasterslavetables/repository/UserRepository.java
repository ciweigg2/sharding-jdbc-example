package com.forezp.sharedingjdbcmasterslavetables.repository;


import com.forezp.sharedingjdbcmasterslavetables.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {

    Integer addUser(User user);

    Integer deleteUser(Long id);

    List<User> list();

}

