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

public class SelectUsingProjection {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Criteria c = s.createCriteria(Employee.class);
		
		/*Projection p = Projections.avg("sal");
		c.setProjection(p);
		Double e =(double)c.uniqueResult();
		System.out.println("Average salary :"+e);*/
		
		//in case if we wanted to get two colums like name,email
		//then we need to apply two Projection on criteria
		
		Projection p1 = Projections.property("name");
		Projection p2 = Projections.property("email");
		Projection p3 = Projections.property("id");
		
		ProjectionList plist = Projections.projectionList();
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		
		c.setProjection(plist);
		
		java.util.List<Object[]> emplist = c.list();
		
		for(Object[] e : emplist )
		{
			System.out.println(e[0]);
			System.out.println(e[1]);
			
		}
		
		
		
		
		
		
		
		
		
		
	}
}
