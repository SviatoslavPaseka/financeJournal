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
@RequestMapping(value="/month/{nameOfMonth}")
public class MonthController {
	@Autowired
	private MonthService monthService;
	@GetMapping
	public String getMonth(Model model, @PathVariable String nameOfMonth) {
			model.addAttribute("nom", nameOfMonth);
			Iterable<MonthMoney> exp = monthService.findByIsIncomeAndThis_month(false, nameOfMonth);
			model.addAttribute("exp",exp);
			Iterable<MonthMoney> inc = monthService.findByIsIncomeAndThis_month(true, nameOfMonth);
			model.addAttribute("inc",inc);
			if (!monthService.findByIsIncomeAndThis_month(false, nameOfMonth).isEmpty()) {
				model.addAttribute("exp_sum", monthService.sumOfColumn(false, nameOfMonth));
			}else model.addAttribute("exp_sum", 0);
			if (!monthService.findByIsIncomeAndThis_month(true, nameOfMonth).isEmpty()) {
				model.addAttribute("inc_sum", monthService.sumOfColumn(true, nameOfMonth));
			}else model.addAttribute("inc_sum", 0);
		
		return "month";
	}
	@RequestMapping("/addExpensive")	
	public String addExpensive(@RequestParam String name,@RequestParam Integer sum, @PathVariable String nameOfMonth ,Model model) {
		MonthMoney monthMoney = new MonthMoney(name, sum, false, nameOfMonth);
		monthService.save(monthMoney);
		
		return "redirect:/month/{nameOfMonth}";
	}
	@RequestMapping("/addIncome")	
	public String addIncome(@RequestParam String name,@RequestParam Integer sum, @PathVariable String nameOfMonth ,Model model) {
		MonthMoney monthMoney = new MonthMoney(name, sum, true, nameOfMonth);
		monthService.save(monthMoney);
		
		return "redirect:/month/{nameOfMonth}";
	}
	@SuppressWarnings("finally")
	@RequestMapping("/deleteLine/{name}")
	public String deleteLine(@PathVariable String name, @PathVariable String nameOfMonth, Model model) {
		try {
			monthService.deleteByName(name, nameOfMonth);
		} finally {
			return "redirect:/month/{nameOfMonth}";
		}
		
	}
	
}
