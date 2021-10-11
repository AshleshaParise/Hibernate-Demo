package com.cla.bookstoredemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteBook {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(BookStoreDO.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
		
			int book_id=1;
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//deleting with id 1
			BookStoreDO tempBook=session.get(BookStoreDO.class, book_id);		
			//session.delete(tempBook);
			session.createQuery("delete from BookStoreDO where id=5").executeUpdate();
			
			session.getTransaction().commit();


		} finally {
			session.close();
		}
		
		

	}

}

