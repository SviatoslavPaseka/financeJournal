package com.psm.financialJournal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psm.financialJournal.model.MonthMoney;
import com.psm.financialJournal.repo.MonthRepo;

@Service
public class MonthServiceImpl implements MonthService{
	@Autowired
	private MonthRepo monthRepo;
	@Override
	public List<MonthMoney> findByIsIncomeAndThis_month(Boolean isIncome, String nameMonth) {
		// TODO Auto-generated method stub
		return monthRepo.findByIsIncomeAndNameMonth(isIncome, nameMonth);
	}
	@Override
	public void save(MonthMoney monthMoney) {
		monthRepo.save(monthMoney);
	}
	@Override
	public void deleteByName(String name, String nameMonth) {
		monthRepo.deleteMonthMoneyByName(name, nameMonth);
	}
	@Override
	public Integer sumOfColumn(Boolean isIncome, String nameMonth) {
		// TODO Auto-generated method stub
		return monthRepo.sumOfColumn(isIncome, nameMonth);
	}
	@Override
	public List<String> getAllTables() {
		return monthRepo.allTablesName();
	}
	@Override
	public List<MonthMoney> findAll() {
		// TODO Auto-generated method stub
		return monthRepo.findAll();
	}
	
}
