package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;

public interface DepartmentService {

	

	

	Department saveDepartment(Department department);

	List<Department> fetchDepartmentList();

	void deleteDepartmentbyId(Integer did) throws DepartmentNotFoundException;

	Department updateDepartment(Integer did, Department department) throws DepartmentNotFoundException;

	Department fetchDepartmentbyid(Integer did) throws DepartmentNotFoundException;

	Department findByDepartmentName(String dname);

	Department findByDepartmentAddress(String daddress);

	Department finBydepartmentCode(String dcode);

	
	

	

	
}