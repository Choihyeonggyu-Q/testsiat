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
import com.siat.testsiat.user.model.domain.UserRequestDTO;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/react")
public class ReactCtrl {

    @Autowired
    private TestService service;
    
    @PostMapping("/select")
    public ResponseEntity<List<TodoResponseDTO>> select(@RequestBody TodoRequestDTO params) {
         System.out.println("debug > reactCtrl > select ");

         System.out.println("debug > reactCtrl / select params :" + params);
         
         List<TodoResponseDTO> list = service.selectService();
         
         return new ResponseEntity<List<TodoResponseDTO>>(list, HttpStatus.OK);
     }
     @PostMapping("/login")
     public ResponseEntity<Void> postMethodName(@RequestBody UserRequestDTO params) {
         System.out.println("debug >> react ctrl / login");
         System.out.println("devuf >> react ctrl /loing params : " + params);
         // 204 == noContent
         return ResponseEntity.noContent().build();
     }
    @GetMapping("/list")
    public ResponseEntity<List<TodoResponseDTO>> select() {
         System.out.println("debug > reactCtrl > list ");
         List<TodoResponseDTO> list = service.selectService();
         
         return new ResponseEntity<List<TodoResponseDTO>>(list, HttpStatus.OK);
     }
    
}
