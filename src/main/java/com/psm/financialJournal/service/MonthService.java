package com.psm.financialJournal.service;

import java.util.List;

import com.psm.financialJournal.model.MonthMoney;

public interface MonthService {
	List<MonthMoney> findAll();
	List<MonthMoney> findByIsIncomeAndThis_month(Boolean isIncome, String this_month);
	void save(MonthMoney monthMoney);
	
	void deleteByName(String name, String nameMonth);
	
	Integer sumOfColumn(Boolean isIncome, String this_month);
	
	List<String> getAllTables();
}
