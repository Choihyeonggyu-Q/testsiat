package com.siat.testsiat.test.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Schema(description = "Todo 요청 DTO")
public class TodoRequestDTO {
    /*
    Validation을 할 수 있는 Annotation
    @NotNull, @NotEmpty, @NotBlank, @Past, @PastOrPresent
    @Size, @Min, @Max, @Pattern 
    */
    @Schema(description = "오라클 시퀸스 값", example = "1")
    private int seq;

    @NotBlank(message = "타이틀은 필수입력 요청")
    private String title;
    
    @NotBlank(message = "내용은 필수입력 요청")
    private String content;
    
    @Pattern(regexp = "^\\d{2,3}-\\d{4}-\\d{4}$", message = "핸드폰 번호 형식에 맞게 입력 요청")
    private String phone;
    
    private String startDate;
    private String endDate;
    private String status;

    @Min(value = 1, message = "1 ~ 10사이의 값")
    @Max(value = 10, message = "1 ~ 10사이의 값")
    private int priority;
    

}
