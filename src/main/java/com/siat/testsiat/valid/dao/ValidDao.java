package com.siat.testsiat.valid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siat.testsiat.valid.domain.entity.TodoEntity;

/*
JPA 지원 Repository 인터페이스 
- CrudRepository
- PaingAndSortingRepository
- JpaRepository<T,K>
- Repository
*/
@Repository
public interface ValidDao extends JpaRepository<TodoEntity, Integer> {
    
}
