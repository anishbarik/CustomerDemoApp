package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer ,Integer>{
	
	
	Customer findByName(String name);
	
	Customer findByEmail(String email);
	
	Customer findByNameAndEmail(String name, String email);
	
	@Query("select u from Customer u where u.name=?1 and u.phone=?2")
	Customer getByNameAndNumber(String nm,String num);
	
	@Query("select u from Customer u")
	List<Customer> getAll();
	
	@Query("select m from Customer m where m.name=?1 and m.email=?2")
	Customer getByNameAndEmail(String name , String email);
	

}
