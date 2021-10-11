package com.cla.bookstoredemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SearchBookDetail {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(BookStoreDO.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			
			
			//start a transaction
			session.beginTransaction();
			
			List<BookStoreDO> bstemp=session.createQuery("from BookStoreDO").list();
			
            displaydetail(bstemp);
            
            bstemp=session.createQuery("from BookStoreDO b where b.bookname='wings of fire' ").list();
            
            System.out.println("Requested detail");
            displaydetail(bstemp);
          
            
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done.....");
			
		} finally {
			session.close();
		}
		
		

	}

	private static void displaydetail(List<BookStoreDO> bstemp) {
		for(BookStoreDO booktemp:bstemp) {
			System.out.println(booktemp);
		}
	}

}

