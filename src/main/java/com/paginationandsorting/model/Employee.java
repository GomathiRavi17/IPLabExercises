package com.paginationandsorting.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This is the model which represents the table employee structure in the database.
 * We have used lombok annotations to generate getters, setters, public and private constructors, toString method
 * @AllArgsConstructor - generates the constructor will all parameters
 * @NoArgsConstructor - default constructor with no arguments
 * @Data - generates getters, setters, toString methods
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
	//mark the attribute with @Id annotation which is the primary key in the table
	@Id
	private int id;
	private String name;
	private String dept;
	private String designation;
	private int salary;
}
