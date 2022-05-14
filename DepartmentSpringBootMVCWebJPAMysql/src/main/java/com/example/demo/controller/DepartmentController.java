package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	@PostMapping("/departments/")

	public Department saveDepartment(@RequestBody Department department)
	{
		return departmentService.saveDepartment(department);

	}
	
	//get record
	@GetMapping("/departments/")
	public List<Department> fetchDepartmentList()
	{
		return departmentService.fetchDepartmentList();
		
	}
	
	//delete record
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentbyId(@PathVariable("id") Integer did) throws DepartmentNotFoundException
	{
		departmentService.deleteDepartmentbyId(did);
		return "Record is Deleted";
		
	}
	
	//update record
	  @PutMapping("/departments/{id}")
	  
	  public Department updateDepartment(@PathVariable("id") Integer did, @RequestBody Department department) throws DepartmentNotFoundException {
		  
		  return departmentService.updateDepartment(did,department);
	  }
	  
	 //getting record by name
	  @GetMapping("/departments/{id}")
	  public Department fetchDepartmentbyid(@PathVariable("id") Integer did) throws DepartmentNotFoundException
	  {
		  return departmentService.fetchDepartmentbyid(did);
	  }
	  
	 //getting by name
	  @GetMapping("/departments/name/{name}")
	  public Department findByDeprtmentName(@PathVariable("name") String dname)
	  {
		  return departmentService.findByDepartmentName(dname);
	  }
	 //getting by address
	  @GetMapping("/departments/address/{address}")
	  public Department findByDepartmentAddress(@PathVariable("address") String daddress)
	  {
		  return departmentService.findByDepartmentAddress(daddress);
	  }
	  
	 //getting by code
	  @GetMapping("/departments/code/{code}")
	  public Department findByDepartmentCode(@PathVariable("code") String dcode)
	  {
		  return departmentService.finBydepartmentCode(dcode);
	  }


}
