package test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;

import beans.Employee;

public class AggregateFuctionUsingProjection {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Criteria c = s.createCriteria(Employee.class);
		
		Projection p = Projections.max("sal");
		//Projection p = Projections.min("sal");
		//Projection p = Projections.sum("sal");
		//Projection p = Projections.count("sal");
		c.setProjection(p);
		int max_sal = (Integer)c.uniqueResult();
		System.out.println("max  salary : "+max_sal);
		
		
		
		
	}
}
