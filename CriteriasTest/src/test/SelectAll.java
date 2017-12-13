package test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;


import beans.Employee;

public class SelectAll {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Criteria c = s.createCriteria(Employee.class);
		
		java.util.List<Employee> list = c.list();
		
		for (Employee emp : list) 
		{
			System.out.println("Employe Email : "+emp.getEmail());
			System.out.println("Employe sal : "+emp.getSal());
			System.out.println("Employe Name :"+emp.getName());
			System.out.println("Employe ID : "+emp.getId());
			
		}
	}
}
