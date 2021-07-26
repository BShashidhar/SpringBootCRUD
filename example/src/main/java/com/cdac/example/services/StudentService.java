package com.cdac.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.example.entity.StudentEntity;
import com.cdac.example.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository; 
		
	public StudentEntity save(StudentEntity stu) {
		return studentRepository.save(stu);
	}
	
	public List<StudentEntity> findAll(){
		return studentRepository.findAll();
	}
	
	public StudentEntity getOne(Long id){
		return studentRepository.getOne(id);
	}
	
	public void delete(StudentEntity stu)
	{
		studentRepository.delete(stu);
	}
	

}
