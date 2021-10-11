package com.cla.bookstoredemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="bookstore")

public class BookStoreDO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int bid;
	
	@Column(name="book_name")
	private String bookname;
	
	@Column(name="book_author")
	private String author;
	
	@Column(name="no_of_book")
	private int no_of_book;
	
	@Column(name="price_of_book")
	private int price_book;
	
	@Column(name="description_of_book")
	private String desc_of_book;
	
	public BookStoreDO() {
		
	}

	public BookStoreDO(String bookname, String author, int no_of_book, int price_book, String desc_of_book) {
		this.bookname = bookname;
		this.author = author;
		this.no_of_book = no_of_book;
		this.price_book = price_book;
		this.desc_of_book = desc_of_book;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNo_of_book() {
		return no_of_book;
	}

	public void setNo_of_book(int no_of_book) {
		this.no_of_book = no_of_book;
	}

	public int getPrice_book() {
		return price_book;
	}

	public void setPrice_book(int price_book) {
		this.price_book = price_book;
	}

	public String getDesc_of_book() {
		return desc_of_book;
	}

	public void setDesc_of_book(String desc_of_book) {
		this.desc_of_book = desc_of_book;
	}

	@Override
	public String toString() {
		return "BookStore [bid=" + bid + ", bookname=" + bookname + ", author=" + author + ", no_of_book=" + no_of_book
				+ ", price_book=" + price_book + ", desc_of_book=" + desc_of_book + "]";
	}
	
	
	
}
