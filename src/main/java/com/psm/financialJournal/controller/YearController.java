package com.psm.financialJournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.psm.financialJournal.service.MonthService;

@Controller
public class YearController {
	@Autowired
	private MonthService monthService;
	@GetMapping()
	public String getYear(Model model) {
		Iterable<String> tables = monthService.getAllTables();
		model.addAttribute("tables", tables);
		return "year";
	}
}
