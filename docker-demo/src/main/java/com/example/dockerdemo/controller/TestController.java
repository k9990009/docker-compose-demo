package com.example.dockerdemo.controller;

import com.example.dockerdemo.entity.Test;
import com.example.dockerdemo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 *
 * </p>
 *
 * @author k9
 * @since 2019-09-30
 */
@RestController
public class TestController {

    @Value("${spring.profiles.active}")
    private String active;
    //多副本测试
    private static AtomicLong COUNT = new AtomicLong(0L);

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/")
    public String index(){
        Test test = new Test();
        test.setCount(COUNT.incrementAndGet());
        testRepository.save(test);
        return active;
    }

}
