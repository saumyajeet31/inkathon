package com.incture.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.demo.entity.Student;


@Repository
public class StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Student> getAllStudents() {
		try{
			
			Session session = sessionFactory.getCurrentSession();
			List<Student> incturites = new ArrayList<Student>();
			incturites = session.createQuery("from Student", Student.class).list();
			return incturites;
		}catch(Exception e)
		{
			System.out.println("hahhaa"+ e);
		}
		
		return null;
	}

}
