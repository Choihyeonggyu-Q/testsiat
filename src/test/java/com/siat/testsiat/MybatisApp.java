package com.siat.testsiat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.siat.testsiat.test.dao.TestMapper;
import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;

@SpringBootTest
public class MybatisApp {
    
    @Autowired
    private TestMapper testMapper;

    @Test
    public void insertTest(){
        System.out.println("debud >>>>> insert test");
        TodoRequestDTO request = TodoRequestDTO.builder()
                                                .title("ㅇㅇ")
                                                .content("dd")
                                                .priority(2)
                                                .build();
        int flag = testMapper.insertRow(request);
        System.out.println("it's OK" + flag);
    }

    @Test
    public void selectTest(){
        System.out.println("debug >>> select test");
        List<TodoResponseDTO> list = testMapper.selectRow();
        System.out.println();
        for(TodoResponseDTO response : list){
            System.out.println(response);
        }
    }

    @Test
    public void updateTest(){
        System.out.println("debug >>> update test");
        Map<String, Object> map = new HashMap<>();
        map.put("seq", 2);
        map.put("content", "dd");
        map.put("status", "Y");
        int flag = testMapper.updateRow(map);
        System.out.println("flag test >> "+ flag);
    }

    @Test
    public void deleteTest(){
        System.out.println("debug >>> delete test");
        int flag = testMapper.deleteRow(61);
        System.out.println("delete flag >>> " + flag);
    }

    @Test
    public void readTest(){
        System.out.println("debug >>> read test");
        // given
        TodoResponseDTO response = testMapper.readRow(41);
        // when
        System.out.println(response);
        // then
        
    }
}
