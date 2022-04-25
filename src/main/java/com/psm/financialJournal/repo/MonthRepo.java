package com.psm.financialJournal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.psm.financialJournal.model.MonthMoney;
@Repository
public interface MonthRepo extends JpaRepository<MonthMoney, Long>{
	List<MonthMoney> findByIsIncome(Boolean isIncome);
	void deleteMonthMoneyByName(String name);
	@Query(value = "SELECT SUM(sum) FROM month_money WHERE is_income=?1", nativeQuery = true)
	Integer sumOfColumn(Boolean isIncome);
}
