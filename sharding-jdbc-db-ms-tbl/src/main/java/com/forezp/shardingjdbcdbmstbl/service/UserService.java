package com.forezp.shardingjdbcdbmstbl.service;



import com.forezp.shardingjdbcdbmstbl.entity.User;

import java.util.List;

public interface UserService {

    Long addUser(User user);

    List<User> list();

    void deleteAll();
}
