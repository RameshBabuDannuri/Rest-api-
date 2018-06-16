package com.ramesh.restfullwebservice.restwebservice.user;

import java.util.List;

public interface IUserDAO {
    public List<User> findAll();
    public User save(User user);
    public User findOne(int id);
}
