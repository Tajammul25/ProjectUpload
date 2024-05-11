package com.jbk.OrganizationSystem.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.OrganizationSystem.Service.MainService;
import com.jbk.OrganizationSystem.entity.Country;
import com.jbk.OrganizationSystem.entity.Employee;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	MainService service;
	
	//API 1
	@PostMapping("/addcountry")
	public String addCountry(@RequestBody Country c) {
		String msg = service.addCountry(c);
		return msg;
	}
	
	//API 2
	
    @PutMapping("/updatecountry")
	public String updateCountry(@RequestBody Country c) {
		String msg= service.updateCountry(c);
		return msg;
	}
    
    // API 3
    @DeleteMapping("/deletecountry/{id}")
    public String deleteCountry(@PathVariable int id) {
        String msg= service.deleteCountry(id);
    	return msg;
    	
    }
    
    // API 4
    
    @GetMapping("/getAllCountry")
    public  List<Country> getAllCountry(){
    	List<Country> list= service.getAllCountry();
    	return list;
    }
    
    // API 5 
    
    @GetMapping("/getCountryById/{id}")
    public Country getCountryById(@PathVariable int id) {
    	
    	Country c = service.getCountryById(id);
    	
    	return c;
    }
    
    // API 6
    
    @PostMapping("/addemployee")
    public String addEmployee(@RequestBody Employee emp) {
    	String msg= service.addEmployee(emp);
    	return msg;
    }
    
    // delete and update api for home work
    
    // API 7 get all data
    @GetMapping("/getallemp")
    public List<Employee> getalldata(){
    	
          List<Employee> list= service.getalldata();
    	
    	return list;
    }
    
    // get Particular record
    
    @GetMapping("/getparticularRecord/{id}")
    public Employee getParticularRecord(@PathVariable int id) {
    	
    	Employee emp= service.getParticularRecord(id);
    	
    	return emp;
    	
    }
    
    // get record by status
    @GetMapping("/getbystatus/{status}")
    public List<Employee> getRecordByStatus(@PathVariable String status){
    	
    	List<Employee> list= service.getRecordByStatus(status);
    	
    	return list;
    }
    
    // login API
    @PostMapping("/login")
    public HashMap login(@RequestBody Employee emp) {
    	
    	HashMap map= service.login(emp);
    	
    	return map;
    	
    }
    
   
}
