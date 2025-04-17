package com.siat.testsiat.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.siat.testsiat.user.model.domain.UserRequestDTO;
import com.siat.testsiat.user.model.domain.UserResponseDTO;

@Mapper
public interface UserMapper {

    public UserResponseDTO loginRow(UserRequestDTO params);
    
} 
