package com.incture.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.demo.dao.StudentDao;
import com.incture.demo.entity.Student;

@Service
public class StudentServiceImplementation implements StudentService {
	
	@Autowired
	StudentDao stdao;
	
	public List<Student> getAllstudents(){
		return stdao.getAllStudents();
		
	}
 
}
