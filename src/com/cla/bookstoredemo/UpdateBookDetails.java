package com.cla.bookstoredemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateBookDetails {

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
			
		
			
			//start a transaction
			session.beginTransaction();
			
			//save the book store object
			System.out.println("Saving book store object.....");
			System.out.println(bsd);
			session.save(bsd);
			session.save(bsdtemp);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done.....");
			
			int book_id=1;
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve Details
			System.out.println("Getting Book Detail with id:  "+bsd.getBid());

			BookStoreDO tempBook=session.get(BookStoreDO.class, book_id);
			
			//Updating book author
			
			tempBook.setAuthor("vavajhb");
			System.out.println("Complete...."+tempBook);

			session.getTransaction().commit();
			System.out.println("Updating with id Done.....");
			
			System.out.println("Updating all column");

			session=factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update BookStoreDO set no_of_book=28").executeUpdate();
			
			session.getTransaction().commit();


		} finally {
			session.close();
		}
		
		

	}

}


