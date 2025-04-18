package com.siat.testsiat.valid.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// dto의 역할을 해서는 안된다
// @table -> 이러한 형태의 테이블이 만들어진다 ex)(todo_entity)
@Entity(name = "Jpa_todo_entity") // 테이블 name 지정
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TodoEntity {
    
    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int seq;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "phone")
    private String phone;   
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "status")
    private String status;
    @Column(name = "priority")
    private int priority;
    

}
