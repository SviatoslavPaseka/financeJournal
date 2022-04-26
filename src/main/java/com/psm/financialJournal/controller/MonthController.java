package com.psm.financialJournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psm.financialJournal.model.MonthMoney;
import com.psm.financialJournal.service.MonthService;

@Controller
@RequestMapping(value="/month")
public class MonthController {
	@Autowired
	private MonthService monthService;
	@GetMapping
	public String getMonth(Model model) {
			Iterable<MonthMoney> exp = monthService.findByIsIncome(false);
			model.addAttribute("exp",exp);
			Iterable<MonthMoney> inc = monthService.findByIsIncome(true);
			model.addAttribute("inc",inc);
			if (!monthService.findByIsIncome(false).isEmpty()) {
				model.addAttribute("exp_sum", monthService.sumOfColumn(false));
			}else model.addAttribute("exp_sum", 0);
			if (!monthService.findByIsIncome(true).isEmpty()) {
				model.addAttribute("inc_sum", monthService.sumOfColumn(true));
			}else model.addAttribute("inc_sum", 0);
		
		return "month";
	}
	@RequestMapping("/addExpensive")	
	public String addExpensive(@RequestParam String name,@RequestParam Integer sum ,Model model) {
		MonthMoney monthMoney = new MonthMoney(name, sum, false, "April");
		monthService.save(monthMoney);
		
		return "redirect:/month";
	}
	@RequestMapping("/addIncome")	
	public String addIncome(@RequestParam String name,@RequestParam Integer sum ,Model model) {
		MonthMoney monthMoney = new MonthMoney(name, sum, true, "April");
		monthService.save(monthMoney);
		
		return "redirect:/month";
	}
	@SuppressWarnings("finally")
	@RequestMapping("/deleteLine/{name}")
	public String deleteLine(@PathVariable String name, Model model) {
		try {
			monthService.deleteByName(name);
		} finally {
			return "redirect:/month";
		}
		
	}
	
}
