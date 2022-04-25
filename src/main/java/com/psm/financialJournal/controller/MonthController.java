package com.psm.financialJournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psm.financialJournal.model.MonthMoney;
import com.psm.financialJournal.service.MonthService;

@Controller("/")
public class MonthController {
	@Autowired
	private MonthService monthService;
	@GetMapping()
	public String getMonth(Model model) {
		Iterable<MonthMoney> exp = monthService.findByIsIncome(false);
		model.addAttribute("exp",exp);
		Iterable<MonthMoney> inc = monthService.findByIsIncome(true);
		model.addAttribute("inc",inc);
		model.addAttribute("exp_sum", monthService.sumOfColumn(false));
		model.addAttribute("inc_sum", monthService.sumOfColumn(true));
		return "index";
	}
	@RequestMapping("/addExpensive")	
	public String addExpensive(@RequestParam String name,@RequestParam Integer sum ,Model model) {
		MonthMoney monthMoney = new MonthMoney(name, sum, false);
		monthService.save(monthMoney);
		
		return "redirect:/";
	}
	@RequestMapping("/addIncome")	
	public String addIncome(@RequestParam String name,@RequestParam Integer sum ,Model model) {
		MonthMoney monthMoney = new MonthMoney(name, sum, true);
		monthService.save(monthMoney);
		
		return "redirect:/";
	}
	@DeleteMapping("/deleteLine/{name}")
	public String deleteLine(@PathVariable String name, Model model) {
		monthService.deleteByName(name);
		return "redirect:/";
	}
}
