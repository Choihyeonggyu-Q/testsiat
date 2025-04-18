package com.siat.testsiat.valid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;
import com.siat.testsiat.valid.dao.ValidDao;
import com.siat.testsiat.valid.domain.entity.TodoEntity;

@Service
public class ValidService {
    
    @Autowired
    private ValidDao dao;
    
    public int insertService(TodoRequestDTO params){
        System.out.println("debug >>> valid service insert service");
        TodoEntity entity = TodoEntity.builder()
                                    .content(params.getContent())
                                    .title(params.getTitle())
                                    .priority(params.getPriority())
                                    .build();
        dao.save(entity);
        ////////////////////////
        dao.findAll();
        return 1;
    }
}
