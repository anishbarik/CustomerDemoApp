package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CustomerService;
import com.example.demo.entity.Customer;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService custm;
	
	@PostMapping("/save")
	public ResponseEntity<?> addCustomer(@Valid  @RequestBody Customer customer)
	{
		return  new ResponseEntity<>(custm.addCustomer(customer) , HttpStatus.CREATED);
		
	//reqbody will bind the body of http request and convert json data to java object 	
	}
	
	@GetMapping("/")
	public ResponseEntity<?> GetAll()
	{
		
		return new ResponseEntity<>(custm.GetAll() ,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> GetById(@PathVariable int id )
	{
		
		return new ResponseEntity<>(custm.GetById(id) ,HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> DeleteCustomer(@PathVariable int id)
	{
		
		return new ResponseEntity<>(custm.DeleteCustomer(id),HttpStatus.OK);
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<?> EditCustomer(@RequestBody Customer customer, @PathVariable int id)
	{
		
		return new ResponseEntity<>(custm.Edit(customer, id), HttpStatus.CREATED);
	}
	

}
                           