package com.spring.blog.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blog.domain.model.Entity.Hello;
import com.spring.blog.infrastructure.dao.HelloDao;

@RestController
public class HelloRestController {

	@Autowired
	private HelloDao helloDao;

	@RequestMapping("/add")
	public Hello add(Hello hello) {

		Hello helloData = helloDao.save(hello);

		return helloData;
	}

	@RequestMapping("/list")
	public List<Hello> list(Model model) {

		List<Hello> helloList = helloDao.findAll();

		return helloList;
	}
	
	@RequestMapping("/delete/{id}")
	public List<Hello> delete(@PathVariable(value = "id") Integer id) {
		
	     helloDao.delete(id);
			List<Hello> helloList = helloDao.findAll();

			return helloList;
	 }

	@RequestMapping("/")
	public String index() {
		return "helloworld!";
	}
}