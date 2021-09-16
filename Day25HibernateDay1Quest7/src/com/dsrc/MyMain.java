package com.dsrc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.dsrc.bean.Department;

public class MyMain {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Department d=new Department();
		d.setDeptno(10);
		d.setDeptname("Sales");
		d.setLocation("Chennai");
		MyMain m=new MyMain();
		m.saveDepartment(d);
		 
		
	}
	
	public void saveDepartment(Department d) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		SessionFactory factory; 
		 factory = new AnnotationConfiguration().configure().buildSessionFactory();
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try {
	          tx = session.beginTransaction();
	          session.save(d);
	          tx.commit();
	       } catch (HibernateException e) {
	          if (tx!=null) tx.rollback();
	          e.printStackTrace(); 
	       } finally {
	          session.close(); 
	       }
		
	}

}
