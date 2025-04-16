package com.siat.testsiat.test.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class TodoResponseDTO {
    private int seq;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;
    private String status;
    private int priority;
}
