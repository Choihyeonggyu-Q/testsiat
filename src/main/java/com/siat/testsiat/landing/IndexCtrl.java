package com.siat.testsiat.landing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexCtrl {
    
    @RequestMapping("/")
    public String index(){
        System.out.println("ctrl index");
        return "landing";
    }   
}
