package com.siat.testsiat.valid.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/valid")
public class RestValidTodoCtrl {

    @PostMapping("/insert")
    public ResponseEntity<Map<String, String>> insert(@Valid TodoRequestDTO params, BindingResult bindResult) {
        System.out.println("debug > todo ctrl /insert ->" + params);
        List<ObjectError> validateErrors = bindResult.getAllErrors();
        System.out.println("debug >> rest valid has errors size : " + validateErrors.size());
        if(bindResult.hasErrors()){
            Map<String, String> map = new HashMap<>();
            for(int i = 0; i < validateErrors.size(); i++){
                FieldError field = (FieldError)validateErrors.get(i);
                System.out.println("code : "    + field.getCode());
                System.out.println("field : "   + field.getField());
                System.out.println("message : " + field.getDefaultMessage());
                map.put(field.getField(), field.getDefaultMessage());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }else{

        }
        return null;
    }
}
