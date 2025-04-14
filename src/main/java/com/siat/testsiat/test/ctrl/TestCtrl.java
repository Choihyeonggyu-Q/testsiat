package com.siat.testsiat.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siat.testsiat.test.service.TestService;

/*
IOC(Inversion of Control)
- DI(Dependency Inject)
- DL(Dependency Lookup)

객체 생성과 관련된 Annotation
- @Component, @Controller, @Service, @Repository

사용자 요청과 관련된 Annotaion
- @RequestMapping

의존성 관리를 위한 Annotaion
- @Autowired, @Inject, @Resource, @Qualifier
*/
@Controller
// user endpoint : http:// ip:port / context / test
@RequestMapping("/test")
public class TestCtrl {

    @Autowired
    private TestService service;
    

    // user endpoint : http:// ip:port / context / test / insert
    @RequestMapping("/insert")
    public String insert(){
        System.out.println("debug >> Ctrl insert");
        System.out.println("debug >> Ctrl inject : " + service);
        service.testService();
        return "insert"; // 논리적 페이지를 분기시킨 리턴
    }
    
    // user endpoint : http:// ip:port / context / test / update
    @RequestMapping("/update")
    public String update(){
        System.out.println("Ctrl update");
        return "update";
    }
    @RequestMapping("/delete")
    public String delete(){
        System.out.println("Ctrl delete");
        return "delete";
    }
    @RequestMapping("/select")
    public String select(){
        System.out.println("Ctrl celect");
        return "select";
    }
}
