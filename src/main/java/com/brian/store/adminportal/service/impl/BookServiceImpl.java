package com.brian.store.adminportal.service.impl;

import java.util.List;

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
		return bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book findOne(Long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public void removeOne(Long id) {
		bookRepository.deleteById(id);
	}
	
}
