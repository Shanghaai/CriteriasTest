package test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;

import beans.Employee;

public class SelectUsingRestriction {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Criteria c = s.createCriteria(Employee.class);
		
			//Criterion cr =Restrictions.eq("id", 10);
			Criterion cr = Restrictions.gt("sal", 500); //it will return employee whose sal greater than 500
			c.add(cr);
			java.util.List<Employee> emp = (java.util.List<Employee>)c.list();
			System.out.println("======================================");
			
			for (Employee e : emp) 
			{
				System.out.println(e.getEmail()+" : "+e.getName());
			}
	}
}
