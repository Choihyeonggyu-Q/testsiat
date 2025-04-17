package com.siat.testsiat.test.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;
import com.siat.testsiat.test.service.TestService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest/todo")
//api endpoint가 어떤 그룹에 속하는 지를 알려주는 그룹핑 어노테이션
@Tag(name = "Todo API", description = "Todo 컨트롤러에 대한 설명입니다.")
public class TodoRestCtrl {
    @Autowired
    private TestService service;

    // endpoint : http://ip:port/todo/registerForm
    @GetMapping("/registerForm")
    public String form(){
        System.out.println("debug >>> todo ctrl /registerForm");
        return "register";
    }
    /*
    @RequestParam, @PathValues

    ResponseEntity(body, headers, status)
    example)
    ResponseEntity("data found", HttpStatus.method)
    */
    // endpoint : http://ip:port/todo/insert
    @PostMapping("/insert")
    @Operation(summary = "입력",     description="parameter로 받은 정보를 저장")   
    @Parameter(name = "title",      description = "제목 입력")
    @Parameter(name = "content",    description = "내용 입력")
    @Parameter(name = "prioriy",    description = "우선 순위 입력")
    @ApiResponse(responseCode = "200", description = "입력 성공")
    
    @ApiResponse(responseCode = "501", description = "입력 수행 실패",
        content = @Content(schema = @Schema(implementation = TodoResponseDTO.class)))
    public ResponseEntity<String> insert(@RequestBody TodoRequestDTO params) {
        System.out.println("debug > todo ctrl /insert ->" + params);
        int flag = service.insertService(params);
        if(flag != 0){
            return new ResponseEntity<>("정상처리", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("실패", HttpStatus.BAD_REQUEST);
        }
    }

    // url query 방식 endpoint: http://ip:port/todo/read?seq=1
    @GetMapping("/read")
    public ResponseEntity<TodoResponseDTO> read(@RequestParam("seq") int seq) {
        System.out.println("debug > read " + seq);
        TodoResponseDTO response = service.readService(seq);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);    
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    // path로 연결함 Pathwariable로 매개 변수로 받는 seq를 Getmapping에 있는 seq로 바인딩 된다
    // endpoint: http://ip:port/todo/view/1
    @GetMapping("/view/{seq}")
    
    public ResponseEntity<TodoResponseDTO> view(@PathVariable int seq) {
        System.out.println("debug > view " + seq);
        TodoResponseDTO response = service.readService(seq);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //endpoint : http://ip:port/todo/delete?seq=1
    @GetMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int seq){
        System.out.println("debug > todo ctrl/delete ->" + seq);
        int flag = service.deleteService(seq);
        if(flag != 0){
            return new ResponseEntity<>("삭제 성공",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("삭제 실패",HttpStatus.BAD_REQUEST);
        }

    }

    // endpoint : http://ip:port/todo/update
    @PostMapping("/update")
    public ResponseEntity<String> update(   @RequestParam String content,
                            @RequestParam String status,
                            @RequestParam int    seq) {
        System.out.println("debug >> todo Ctrl/update ->" + content);
        System.out.println("debug >> todo Ctrl/update ->" + status);
        System.out.println("debug >> todo Ctrl/update ->" + seq);        
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("content", content);
        map.put("seq", seq);
        int flag = service.updateService(map);
        if(flag != 0){
            return new ResponseEntity<>("수정 성공",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("수정 실패", HttpStatus.NOT_MODIFIED);
        }
    }

     // endpoint : http//ip:port/todo/select   
     @GetMapping("/select")
     public ResponseEntity<List<TodoResponseDTO>> select() {
         System.out.println("debug > read ");
         List<TodoResponseDTO> list = service.selectService();
         
         return new ResponseEntity<>(list, HttpStatus.OK);
     }
}
