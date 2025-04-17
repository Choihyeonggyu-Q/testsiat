package com.siat.testsiat.test.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Todo 요청")
public class TodoRequestDTO {
    private String title;
    private String content;
    private String startDate;
    private String endDate;
    private String status;
    private int priority;
    
    private int seq;
}
