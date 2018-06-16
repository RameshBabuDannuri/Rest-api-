package com.ramesh.restfullwebservice.restwebservice.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAOService implements IUserDAO{
    private static List<User> users = new ArrayList<>();
    public static int countId = 3;
    static {
        users.add(new User
                (1,"ramesh","ramesh.dannuri@gmail.com",new Date()));
        users.add(new User
                (2,"ram","ram.dannuri@gmail.com",new Date()));
        users.add(new User
                (3,"paramesh","paramesh.dannuri@gmail.com",new Date()));
    }

    public List<User> findAll() {
        return users;
    }
    public User save(User user){
        if (user.getId()==null){
            user.setId(++countId);
        }
        users.add(user);
        return user;
    }
    public User findOne(int id){
        for (User user:users){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }
}
