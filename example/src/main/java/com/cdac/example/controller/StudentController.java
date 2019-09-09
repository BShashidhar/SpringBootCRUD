package com.cdac.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.example.dao.StudentService;
import com.cdac.example.dto.StudentDto;
import com.cdac.example.entity.StudentEntity;

@RestController
@RequestMapping("/cdac")
public class StudentController {
	@Autowired
	StudentService studentService;

	// create Student
	@PostMapping("/createstudent")
	public StudentEntity createStudent(@Valid @RequestBody StudentEntity stu) {
		return studentService.save(stu);
	}

	// find student by id
	@GetMapping("/findstudent/{id}")
	public ResponseEntity<StudentDto> findStudentById(@PathVariable(value = "id") Long id) {
		StudentEntity stu = studentService.getOne(id);
		StudentDto dto = new StudentDto();
		dto.setCourse(stu.getCourse());
		dto.setId(stu.getId());
		dto.setName(stu.getName());
		dto.setPhoneno(stu.getPhoneno());
		dto.setParphoneno(stu.getParphoneno());
		dto.setEmail(stu.getEmail());
		dto.setAddress(stu.getAddress());
		dto.setFeedback(stu.getFeedback());

		return ResponseEntity.ok().body(dto);

	}

	// find all students
	@GetMapping("/findallstudents")
	public List<StudentEntity> findAll(StudentEntity stu) {
		return studentService.findAll();

	}

	// update a student
	@PutMapping("/updatestudent/{id}")
	public ResponseEntity<StudentEntity> updateStudent(@PathVariable(value = "id") Long id,
			@RequestBody StudentEntity studentDetails) {
		StudentEntity stu = studentService.getOne(id);
		if (stu == null) {
			return ResponseEntity.notFound().build();
		}
		stu.setName(studentDetails.getName());
		stu.setCourse(studentDetails.getCourse());
		stu.setAddress(studentDetails.getAddress());
		stu.setPhoneno(studentDetails.getPhoneno());
		stu.setEmail(studentDetails.getEmail());
		stu.setParphoneno(studentDetails.getParphoneno());
		stu.setAddress(studentDetails.getAddress());
		stu.setFeedback(studentDetails.getFeedback());

		StudentEntity updateStudent = studentService.save(stu);
		return ResponseEntity.ok().body(updateStudent);

	}
	@DeleteMapping("deletestudent/{id}")
	public ResponseEntity<StudentEntity> deleteStudent(@PathVariable(value="id") Long id) {
		StudentEntity stuent=studentService.getOne(id);
		studentService.delete(stuent);
		return ResponseEntity.ok().body(stuent);

	}

}
