package com.emedinaa.concurrency;

import com.emedinaa.concurrency.model.User;
import com.emedinaa.concurrency.model.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by emedinaa on 17/03/17.
 */
public class MainCallableFuture {

    private List<UserEntity> mocks(){
        List<UserEntity> userEntities= new ArrayList<>();
        userEntities.add(new UserEntity(1, "Eduardo Medina", "abc@gmail.com"));
        userEntities.add(new UserEntity(2, "Eduardo Medina", "abc@gmail.com"));
        userEntities.add(new UserEntity(3, "Eduardo Medina", "abc@gmail.com"));
        userEntities.add(new UserEntity(4, "Eduardo Medina", "abc@gmail.com"));
        userEntities.add(new UserEntity(5, "Eduardo Medina", "abc@gmail.com"));
        userEntities.add(new UserEntity(6, "Eduardo Medina", "abc@gmail.com"));
        userEntities.add(new UserEntity(7, "Eduardo Medina", "abc@gmail.com"));
        userEntities.add(new UserEntity(8, "Eduardo Medina", "abc@gmail.com"));

        return  userEntities;
    }

    public void setUp(){
        List<UserEntity> userEntities= mocks();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future<List<User>> future= executor.submit(new CallableOperation(new UserMapper(),userEntities));

        List<User> users= null;
        try {
            users= future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("users "+users);


    }

    public static void main(String[] args) {

        MainCallableFuture mainCallableFuture = new MainCallableFuture();
        mainCallableFuture.setUp();
    }
}
