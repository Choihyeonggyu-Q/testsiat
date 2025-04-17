package com.siat.testsiat.user.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siat.testsiat.user.model.domain.UserRequestDTO;
import com.siat.testsiat.user.model.domain.UserResponseDTO;
import com.siat.testsiat.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Slf4j  //simple logging facade for java
/*
trace : 추적레벨 -> debug 보다 좀 더 상세함
debug : 디버깅 정보성 메시지를 출력할 때
info  : 상태변경이나 정보성 메시지를 출력할 때
warn  : 에러의 원인이 될 수 있는 경소성 메시지를 출력할 때
error : 요청 처리에 문제 발생시
*/
@Controller
@RequestMapping("/user") // http://ip:port/user
public class UserCtrl {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService service;

    // endpoint http://ip:port/user/login
    @PostMapping("/login")
    public String postMethodName(UserRequestDTO params) {
        log.info(">>>>>>>>>>>>>>>>>>> ctrl login param" + params);
        UserResponseDTO response = service.loginService(params);
        log.debug(">>>>>>>>>>>>>>>>> response = " + response);
        session.setAttribute("UserSession", response);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
    
    
}
