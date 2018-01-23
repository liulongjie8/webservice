package com.webservice.service;

import com.webservice.entriy.Book;

public interface BookService {

	public Book getBookById(int id);

	public String sayHello(String str);
}
