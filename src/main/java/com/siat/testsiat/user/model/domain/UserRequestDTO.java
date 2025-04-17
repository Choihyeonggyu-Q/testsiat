package com.siat.testsiat.user.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
@Getter
public class UserRequestDTO {
    private String id;
    private String pwd;
}
