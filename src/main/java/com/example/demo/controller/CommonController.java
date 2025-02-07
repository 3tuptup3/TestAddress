package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	// 完了後のリダイレクト先
	// リダイレクトでPOSTリクエストではなくGETリクエストとしてHTMLを返す
	@GetMapping("/complete")
	private String complate() {
		return "complete";
	}

}
