package com.example.demo.board.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

		@Resource(name="com.example.demo.board.service.BoardService")
		BoardService mBoardService;
		
		@RequestMapping("/list")
		private String boardList(Model model) throws Exception {
			model.addAttribute("list", mBoardService.boardListService());
			return "list"
		}
}
