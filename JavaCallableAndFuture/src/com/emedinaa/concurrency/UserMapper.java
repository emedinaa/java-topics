package com.emedinaa.concurrency;

import com.emedinaa.concurrency.model.User;
import com.emedinaa.concurrency.model.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 17/03/17.
 */
public class UserMapper {

    private User transform(UserEntity userEntity){
        User user = new User();
        if(userEntity==null) return  user;

        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());

        return  user;
    }

    public List<User> transformList(List<UserEntity> userEntities){
        List<User> users= new ArrayList<>();
        if(userEntities==null) return users;

        for (UserEntity userEntity:userEntities) {
            users.add(transform(userEntity));
        }

        return users;
    }
}
