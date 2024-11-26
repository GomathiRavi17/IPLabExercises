package com.paginationandsorting.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paginationandsorting.model.Employee;

/* This interface is responsible for handling all database operations. 
 * Objects cannot be created for Interface. 
 * so at runtime, Object will be created for the class which implements this interface.
 * @Repository - this annotation is mandatory as it handles the object creation of it's implementation class
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	/* this method fetches the data from db by applying like operator condition and pagination.
	 * returns all the records that matches with given name
	 * this method is equivalent to the sql query: select * from employee e where e.name like '%name%';
	 */
	Page<Employee> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

}
