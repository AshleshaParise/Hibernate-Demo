package com.cla.bookstoredemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadBookInformation {

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
			BookStoreDO bsd=new BookStoreDO("Chinmayi","Prakash Barve",25,300,
					"It is awesome book");
			
			BookStoreDO bsdtemp=new BookStoreDO("ABC","nfknf",20,200,
					"It is nice book");
			
			BookStoreDO bsdtemp2=new BookStoreDO("QRP","iwqkmedw",20,400,
					"It is good book");
			
			//start a transaction
			session.beginTransaction();
			
			//save the book store object
			System.out.println("Saving book store object.....");
			System.out.println(bsd);
			session.save(bsd);
			session.save(bsdtemp);
			session.save(bsdtemp2);

			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Saved Book Information, Generated id:  "+bsd.getBid());
			System.out.println("Done.....");
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve Details
			System.out.println("Getting Book Detail with id:  "+bsd.getBid());

			BookStoreDO tempBook=session.get(BookStoreDO.class, bsd.getBid());
			
			System.out.println("Complete...."+tempBook);

			session.getTransaction().commit();
			System.out.println("Done.....");
			


		} finally {
			session.close();
		}
		
		

	}

}

