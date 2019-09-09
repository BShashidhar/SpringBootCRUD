package com.cdac.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.example.entity.StudentEntity;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

}
