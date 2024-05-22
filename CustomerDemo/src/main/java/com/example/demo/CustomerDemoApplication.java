package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.Repository.CustomerRepository;
import com.example.demo.entity.Customer;

@SpringBootApplication
public class CustomerDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(CustomerDemoApplication.class, args);
		
		CustomerRepository cusrepo=context.getBean(CustomerRepository.class);
		
		
		Customer cust =cusrepo.findByName("Radha");
		System.out.println(cust);
//		
//		
//		 Customer cust1=cusrepo.findByEmail("aks@gmail.com");
//		 System.out.println(cust1);
//		 
//		 
		// Customer cust2 = cusrepo.findByNameAndEmail("Anish", "aks@gmail.com");
		 //System.out.println(cust2);
		 
		 
//		 Customer cust3=cusrepo.getByNameAndNumber("Anish", "6725242466");
//
//		 System.out.println(cust3);
		
		
		//List<Customer> cust4= cusrepo.getAll();
		//cust4.forEach(e->System.out.print(e));
		
       Customer cust5  = cusrepo.getByNameAndEmail("hari","hri@gmail.com");
     //  cust5.forEach(e->System.out.print(e));
      System.out.println(cust5);
		
	}

}
