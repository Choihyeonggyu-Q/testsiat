package com.siat.testsiat.valid.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.valid.service.ValidService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/valid")
public class ValidTodoCtrl {

    @Autowired
    private ValidService service;

    @PostMapping("/insert")
    public String insert(@Valid TodoRequestDTO params, BindingResult bindResult, Model model) {
        System.out.println("debug > todo ctrl /insert ->" + params);
        List<ObjectError> validateErrors = bindResult.getAllErrors();
        System.out.println("debug >> valid has errors size : " + validateErrors.size());
        if(bindResult.hasErrors()){
            Map<String, String> map = new HashMap<>();
            for(int i = 0; i < validateErrors.size(); i++){
                FieldError field = (FieldError)validateErrors.get(i);
                System.out.println("code : "    + field.getCode());
                System.out.println("field : "   + field.getField());
                System.out.println("message : " + field.getDefaultMessage());
                map.put(field.getField(), field.getDefaultMessage());
            }
            model.addAttribute("validError", map);
            return "register";
        }else{
            System.out.println("else OK");
            int flag = service.insertService(params);
        
        }
        return null;
    }
}
