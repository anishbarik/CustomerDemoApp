package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.CustomerNotFoundException;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	
	public Customer addCustomer(Customer customer)
	{
		
		 return repo.save(customer);
	}
	
	public List<Customer> GetAll()
	{
		
		 return  repo.findAll();
	}
	
	public Customer GetById(int id)
	{
//		Optional<Customer> cust = repo.findById(id);
//		
//		if(cust.isPresent())
//		{
//			return cust.get();
//		}
//		
//		return null ;
		
		if(repo.findById(id).isEmpty())
			throw new CustomerNotFoundException("customer details does not exits!!");
		
		return repo.findById(id).get();
	}
	
	public String DeleteCustomer(int id)
	{
		Customer customer=repo.findById(id).get();
		
		if(customer != null)
		{
			
			repo.delete(customer);
			return "customer deleted..";
		}
		 return "not found";
	}
	
	public Customer Edit(Customer ct , int id)
	{
		Customer old =repo.findById(id).get();
		//here we get the old details based on id then set new details and return 
		old.setName(ct.getName());
		old.setEmail(ct.getEmail());
		old.setPhone(ct.getPhone());
		
		return repo.save(old) ;
	}
}
