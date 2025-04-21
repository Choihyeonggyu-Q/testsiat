package com.siat.testsiat.test.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;
import com.siat.testsiat.test.service.TestService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/react")
public class ReactCtrl {

    @Autowired
    private TestService service;
    
    @GetMapping("/select")
    public ResponseEntity<List<TodoResponseDTO>> select(@RequestBody TodoRequestDTO params) {
         System.out.println("debug > reactCtrl > select ");

         System.out.println("debug > reactCtrl / select params :" + params);
         
         List<TodoResponseDTO> list = service.selectService();
         
         return new ResponseEntity<List<TodoResponseDTO>>(list, HttpStatus.OK);
     }

    
}
