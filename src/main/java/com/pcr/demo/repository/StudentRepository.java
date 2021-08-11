package com.pcr.demo.repository;

import com.pcr.demo.model.Student;

public interface StudentRepository {
	void save(Student student);
	Student find(Long id);
}
