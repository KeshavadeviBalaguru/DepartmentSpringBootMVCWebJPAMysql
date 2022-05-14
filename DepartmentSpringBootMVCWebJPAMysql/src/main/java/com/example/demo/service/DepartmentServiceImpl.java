package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentRepository departmentrepo;

	@Override
	public Department saveDepartment(Department department) {
		
		return departmentrepo.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		return departmentrepo.findAll();
	}

	

	@Override
	public void deleteDepartmentbyId(Integer did) throws DepartmentNotFoundException {
		//check for null
				Optional<Department> department1= departmentrepo.findById(did);//check in database
		          if(!department1.isPresent()) {
		        	  throw new DepartmentNotFoundException("Department not available");
		          }

		departmentrepo.deleteById(did);
	}

	@Override
	public Department updateDepartment(Integer did, Department department) throws DepartmentNotFoundException {
		Optional<Department> department1= departmentrepo.findById(did);
		Department depDB=null;
		if(department1.isPresent()) {
		 depDB=	departmentrepo.findById(did).get();
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
			
		}
		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
			System.out.println(department.getDepartmentAddress());
		}
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
			System.out.println(department.getDepartmentCode());
		}
		return departmentrepo.save(depDB);

		}
		else
		{
			throw new DepartmentNotFoundException("Department not Available");
		}
		

	}

	@Override
	public Department fetchDepartmentbyid(Integer did) throws DepartmentNotFoundException {
		//check for null
				Optional<Department> department1= departmentrepo.findById(did);//check in database
		          if(!department1.isPresent()) {
		        	  throw new DepartmentNotFoundException("Department not available");
		          }

		
		return departmentrepo.findById(did).get();
	}

	@Override
	public Department findByDepartmentName(String dname) {
		// TODO Auto-generated method stub
		return departmentrepo.findByDepartmentName(dname);
	}

	@Override
	public Department findByDepartmentAddress(String daddress) {
		
		return departmentrepo.findBydepartmentAddress(daddress) ;
	}

	@Override
	public Department finBydepartmentCode(String dcode) {
	
		return  departmentrepo.findBydepartmentCode(dcode);
	}

	
	
	
	
	

	
	
	


}
