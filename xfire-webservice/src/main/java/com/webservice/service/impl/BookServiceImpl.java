package com.webservice.service.impl;

import com.webservice.entriy.Book;
import com.webservice.service.BookService;

public class BookServiceImpl implements BookService {

	public Book getBookById(int id) {
		Book book = new Book(1, "china");
		return book;
	}

	public String sayHello(String str) {
		return "this is " + str + ".";
	}

}
