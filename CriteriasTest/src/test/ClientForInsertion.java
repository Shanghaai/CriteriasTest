package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class ClientForInsertion {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Employee e1 = new Employee(10, "sahil", "sahilyahoo.siddiqui@gmail.com", 1000);
		Employee e2 = new Employee(20, "jhon", "jhon.siddiqui@gmail.com", 500000);
		Employee e3 = new Employee(40, "dhini", "dhoni.siddiqui@gmail.com", 200000);
		Employee e4 = new Employee(30, "shewag", "shewag.siddiqui@gmail.com", 10000);
		
		s.save(e1);
		s.save(e2);
		s.save(e3);
		s.save(e4);
		
		t.commit();
		s.close();
		sf.close();
		System.out.println("insertion success ");
		
	}
}
