package com.siat.testsiat.test.service;

import java.util.List;
import java.util.Map;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siat.testsiat.test.dao.TestMapper;
import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;

@Service
public class TestService {
    
    @Autowired  //의존성 주입 -> 이게 즉 객체 생성
    private TestMapper TestMapper ;

    public int insertService(TodoRequestDTO params){
        System.out.println("debug >> service insertService");
        return TestMapper.insertRow(params);
    }
    public List<TodoResponseDTO> selectService(){
        System.out.println("debug >> service selectService");
        return TestMapper.selectRow();
    }
    public int updateService(Map<String, Object> map){
        System.out.println("debug >> service updateService");
        return TestMapper.updateRow(map);
    }
    public int deleteService(int seq){
        System.out.println("debug >> service deleteService");
        return TestMapper.deleteRow(seq);
    }
    public TodoResponseDTO readService(int seq){
        System.out.println("debug >> service readService");
        return TestMapper.readRow(seq);
    }

}
