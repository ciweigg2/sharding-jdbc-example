package com.forezp.sharedingjdbcmasterslavetables.service;



import com.forezp.sharedingjdbcmasterslavetables.entity.User;

import java.util.List;

public interface UserService {

    Integer addUser(User user);

    Integer deleteUser(Long id);

    List<User> list();
}
