package com.psm.financialJournal.service;

import java.util.List;

import com.psm.financialJournal.model.MonthMoney;

public interface MonthService {
	List<MonthMoney> findAll();
	List<MonthMoney> findByIsIncome(Boolean isIncome);

	void save(MonthMoney monthMoney);
	
	void deleteByName(String name);
	
	Integer sumOfColumn(Boolean isIncome);
	
	List<String> getAllTables();
}
