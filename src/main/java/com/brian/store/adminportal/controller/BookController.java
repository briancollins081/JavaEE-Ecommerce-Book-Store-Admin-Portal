package com.brian.store.adminportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brian.store.adminportal.domain.Book;

@Controller
@RequestMapping("/book")
public class BookController {
	@RequestMapping("/add")
	public String addBook(Model model) {
		Book book=new Book();
		model.addAttribute("book",book);
		return "addBook";
	}
}
