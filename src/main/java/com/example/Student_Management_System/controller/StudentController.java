package com.example.Student_Management_System.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student_Management_System.entity.Student;
import com.example.Student_Management_System.service.StudentService;
import com.example.Student_Management_System.util.ResponseStructure;

@RestController
public class StudentController {
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@PostMapping("save-student")
	public ResponseEntity<ResponseStructure<Student>> add(@RequestBody Student student)
	{
		student=studentService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(),"created successfully",student));
	}
	@GetMapping("display-student")
	public ResponseEntity<ResponseStructure<Student>> display(@RequestParam("student_id") int studentId)
	{
	Student student=studentService.displayStudent(studentId);
	return ResponseEntity.status(HttpStatus.FOUND)
			.body(ResponseStructure.create(HttpStatus.FOUND.value(),"Displayed successfully", student));
	}
	@DeleteMapping("/delete-student")
	public ResponseEntity<ResponseStructure<Student>> delete(@RequestParam("student_id") int studentId)
	{
		Student student=studentService.deleteStudent(studentId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(),"student successfully deleted", student));
	}
	@PutMapping("/update-student")
	public ResponseEntity<ResponseStructure<Student>> update(@RequestBody Student student)
	{
		student=studentService.updateStudent(student);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(), "student is Successfully updated", student));
	}

}
