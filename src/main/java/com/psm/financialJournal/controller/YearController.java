package com.psm.financialJournal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YearController {
	@GetMapping()
	public String getYear(Model model) {
		return "year";
	}
}
