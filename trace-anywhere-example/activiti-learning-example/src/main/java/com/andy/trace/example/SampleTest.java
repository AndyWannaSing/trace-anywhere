package com.andy.trace.example;

import org.apache.ibatis.executor.BatchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        System.out.println(("----- testInsert method test ------"));
        long id = 6L;
        User user = User.builder()
                .id(id)
                .name("user" + id)
                .age((int) id)
                .email("user" + id + "@test.com")
                .build();
        userMapper.insert(user);
    }

    @Test
    public void testInsertNoId() {
        System.out.println(("----- testInsertNoId method test ------"));
        long id = 7L;
        User user = User.builder()
                .name("user" + id)
                .age((int) id)
                .email("user" + id + "@test.com")
                .build();
        userMapper.insert(user);
    }

    @Test
    public void testInsertBatch() {
        System.out.println(("----- testInsertBatch method test ------"));
        List<User> userList = new ArrayList<>();
        for(long id = 8L; id <= 9L; id++){
            User user = User.builder()
                    .name("user" + id)
                    .age((int) id)
                    .email("user" + id + "@test.com")
                    .build();
            userList.add(user);
        }
        List<BatchResult> batchResults = userMapper.insert(userList);
        userList.forEach(System.out::println);
    }

}
