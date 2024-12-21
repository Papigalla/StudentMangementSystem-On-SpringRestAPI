package com.example.Student_Management_System.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Student_Management_System.entity.Student;
import com.example.Student_Management_System.exception.StudentNotFoundById;
import com.example.Student_Management_System.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}


	public Student displayStudent(int studentId) {
		return studentRepository.findById(studentId).orElseThrow(()->new StudentNotFoundById("Please Enter valid studentid"));
	}


	public Student deleteStudent(int studentId) {
		Optional<Student> optional=studentRepository.findById(studentId);
		if(optional.isPresent())
		{
			Student student=optional.get();
			studentRepository.delete(student);
			return student;
		}
		else
		{
			throw new StudentNotFoundById("Studentid details are not there");
		}
	}


	public Student updateStudent(Student student) {
		Optional<Student> student1=studentRepository.findById(student.getStudentId());
		if(student1.isPresent())
		{
			return studentRepository.save(student);
		}
		else
		{
			throw new StudentNotFoundById("student is not there");
		}
	}

}
