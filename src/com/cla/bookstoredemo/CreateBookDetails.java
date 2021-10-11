package com.cla.bookstoredemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateBookDetails {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(BookStoreDO.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//create a bookstore object
			System.out.println("Creating book store object.....");
			BookStoreDO bs=new BookStoreDO("Wings Of Fire","Abdul Kalam",18,500,
					"It is best seller book");
			
			//start a transaction
			session.beginTransaction();
			
			//save the book store object
			System.out.println("Saving book store object.....");

			session.save(bs);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done.....");
			
		} finally {
			session.close();
		}
		
		

	}

}
