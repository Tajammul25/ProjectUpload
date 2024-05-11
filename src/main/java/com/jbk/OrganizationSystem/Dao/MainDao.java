package com.jbk.OrganizationSystem.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.OrganizationSystem.entity.Country;
import com.jbk.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;

	// add country
	public String addCountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			msg = "Country added successfully";
			session.persist(c);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	// update country
	public String updateCountry(Country c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Country con = session.get(Country.class, c.getCid());

			con.setCname(c.getCname());

			session.merge(con);
			tx.commit();

			msg = "country updated successfully";

		} catch (Exception e) {
			e.printStackTrace();

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	// delete Country
	public String deleteCountry(int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Country con = session.get(Country.class, id);

			session.remove(con);

			tx.commit();
			msg = "country deleted successfully";

		} catch (Exception e) {
			e.printStackTrace();

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	// get All Country
	public List<Country> getAllCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> list = null;
		String hqlQuery = "from Country";

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Country> query = session.createQuery(hqlQuery, Country.class);

			list = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return list;
	}

	public Country getCountryById(int id) {
		Session session = null;
		Transaction tx = null;

		Country c = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			c = session.get(Country.class, id);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return c;
	}

	public String addEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg = "Employee Data added";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Employee> getalldata() {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee";

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			list = query.list();

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}
		return list;
	}

	public Employee getParticularRecord(int id) {

		Session session = null;
		Transaction tx = null;
		Employee emp = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			emp = session.get(Employee.class, id);

//		    Query<Employee> query= query.list();

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}

		}
		return emp;
	}

	public List<Employee> getRecordByStatus(String status) {

		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;

		try {

			session = factory.openSession();
			tx = session.getTransaction();

			String hqlQuery = "from Employee where status=:status";

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			
			query.setParameter("status", status);

			list = query.list();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public Employee login(Employee emp) {
		
		Session session = null;
		Transaction tx = null;
		Employee employee=null;
		
		try {
			
		 session =factory.openSession();
		 tx=session.getTransaction();
		 
		 String hqlQuery="from Employee where name=:name and mobileno=:mobileno";
		 
		Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
		
		query.setParameter("name", emp.getName());
		query.setParameter("mobileno", emp.getMobileno());
		
		employee= query.uniqueResult();
		
		tx.commit();
		 
			
		}catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		 return employee;
		
	}
	

}