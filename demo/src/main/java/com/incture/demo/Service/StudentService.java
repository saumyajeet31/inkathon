package com.incture.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.incture.demo.entity.Student;

@Service
public interface StudentService {
	
	List<Student> getAllstudents();

}
