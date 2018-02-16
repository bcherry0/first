package com.spring.blog.presentation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.blog.domain.model.Entity.Post;
import com.spring.blog.infrastructure.dao.PostDao;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostDao postDao;

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String form(Post post) {
		return "form";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Post post) {
		post.setRegDate(new Date());
		return "redirect:/post/" + postDao.save(post).getId();
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<Post> postList = postDao.findAll();
		model.addAttribute("postList", postList);
		return "blog";
	}

	@RequestMapping("/{id}")
	public String view(Model model, @PathVariable int id) {
		Post post = postDao.findOne(id);
        post.setContent(post.getContent().replaceAll("<", "&lt"));
        post.setContent(post.getContent().replaceAll(">", "&gt"));
        post.setContent(post.getContent().replaceAll("\"", "&quot;"));
        post.setContent(post.getContent().replaceAll("\n", "<br>"));
		model.addAttribute("post", post);
		return "post";
	}
}