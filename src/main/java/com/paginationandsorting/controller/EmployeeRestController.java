package com.paginationandsorting.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paginationandsorting.model.Employee;
import com.paginationandsorting.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	/* Whenever '/employees' endpoint is invoked, this handler method is invoked.
	 * This method interacts with repository to fetch the data.
	 * This method take four parameters to support searching and pagination.
	 * We are going to perform search based on employee name.
	 * Remaining parameters are used for implementing pagination.
	 * PageNumber and PageSize decides how many number of records needs to be fetched for current page.
	 * Eg: PageNumber: 0, PageSize: 3 - returns first 3 records
	 * Eg: PageNumber: 2, PageSize: 5 - skips first 10 records and returns next 5 records. 
	 * In the above example, pageSize is 5 which means each page will contain 5 records,
	 * since we want to get the records for pageNumber 2, it skips first 10 records
	 */
	@GetMapping("/employees")
	public Page<Employee> getAllEmployee(
			@RequestParam Optional<String> name,
			@RequestParam Optional<Integer> pageNumber,
			@RequestParam Optional<Integer> pageSize,
			@RequestParam Optional<String> sortBy
			){
		return empRepo.findAllByNameContainingIgnoreCase(name.orElse(""),PageRequest.of(pageNumber.orElse(0), pageSize.orElse(10),
				Sort.by(Sort.Direction.ASC, sortBy.orElse("id"))));
	}

}
