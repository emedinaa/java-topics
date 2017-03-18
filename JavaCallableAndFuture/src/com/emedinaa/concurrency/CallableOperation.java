package com.emedinaa.concurrency;

import com.emedinaa.concurrency.model.User;
import com.emedinaa.concurrency.model.UserEntity;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by emedinaa on 17/03/17.
 */
public class CallableOperation implements Callable<List<User>> {

    private final UserMapper userMapper;
    private final List<UserEntity> userEntities;

    public CallableOperation(UserMapper userMapper, List<UserEntity> userEntities) {
        this.userMapper = userMapper;
        this.userEntities = userEntities;
    }

    @Override
    public List<User> call() throws Exception {
        return userMapper.transformList(this.userEntities);
    }
}
