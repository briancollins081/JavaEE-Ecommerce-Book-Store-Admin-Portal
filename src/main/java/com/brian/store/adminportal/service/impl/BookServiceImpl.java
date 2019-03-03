package com.brian.store.adminportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.store.adminportal.domain.Book;
import com.brian.store.adminportal.repository.BookRepository;
import com.brian.store.adminportal.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;

	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}
	
}
