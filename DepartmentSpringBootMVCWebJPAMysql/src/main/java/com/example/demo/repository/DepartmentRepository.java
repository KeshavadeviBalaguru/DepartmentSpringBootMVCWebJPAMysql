package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Department findByDepartmentName(String dname);

	
	Department findBydepartmentAddress(String daddress);


	Department findBydepartmentCode(String dcode);

}
