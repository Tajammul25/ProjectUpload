package com.jbk.OrganizationSystem.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.OrganizationSystem.Dao.MainDao;
import com.jbk.OrganizationSystem.entity.Country;
import com.jbk.OrganizationSystem.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	
	public String addCountry(Country c) {
		String msg = dao.addCountry(c);
		
		 if (msg == null) {
		  msg = "Country not added...";
	     }
		return msg;
	}

	public String updateCountry(Country c) {
	
		String msg= dao.updateCountry(c);
		
		if(msg==null) {
			msg="country not updated..";
		}
		
		return msg;
	}

	public String deleteCountry(int id) {
		
		String msg= dao.deleteCountry(id);
		
		return msg;
	}

	public List<Country> getAllCountry() {
		
		List<Country> list= dao.getAllCountry();
		
		return list;
	}

	public Country getCountryById(int id) {

		Country c= dao.getCountryById(id);
		
		if(c==null) {
			
			c=null;
		}
		
		return c;
	}
	

	public String addEmployee(Employee emp) {
		
		String msg= dao.addEmployee(emp);
		
		if(emp==null) {
		  msg="Employee not added";
		}
		
		return msg;
		
	}

	public List<Employee> getalldata() {
		List<Employee> list= dao.getalldata();
		return list;
	}

	public Employee getParticularRecord(int id) {
		
		Employee emp= dao.getParticularRecord(id);
		
		if(emp==null) {
			return null;
		}
		
		return emp;
	}

	public List<Employee> getRecordByStatus(String status) {
		
		List<Employee> list= dao.getRecordByStatus(status);
		
		if(list==null) {
			return null;
		}
		
		return list;
	}

	public HashMap login(Employee emp) {
	
		
		   Employee e= dao.login(emp);
		   
		  HashMap map = new HashMap();
		 
		 if(e==null) {
			 map.put("msg", "InvalidUser");
			 map.put("user", null);
		 }else {
			 map.put("msg", "validUser");
			 map.put("user", e);
		 }
		 return map;
	}
}

	
	
	
	