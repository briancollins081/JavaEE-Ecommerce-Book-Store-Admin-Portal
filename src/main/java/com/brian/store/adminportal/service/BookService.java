package com.brian.store.adminportal.service;

import java.util.List;

import com.brian.store.adminportal.domain.Book;

public interface BookService {
	Book save(Book book);

	List<Book> findAll();
	
	Book findOne(Long id);
}
