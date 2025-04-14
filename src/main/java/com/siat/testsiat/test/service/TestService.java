package com.siat.testsiat.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siat.testsiat.test.dao.TestDao;

@Service
public class TestService {
    
    @Autowired  //의존성 주입 -> 이게 즉 객체 생성
    private TestDao dao;

    public void testService(){
        System.out.println("debug >> service testService");
        System.out.println("debug >> service dao inject " + dao);
        dao.testRow();
    }

}
