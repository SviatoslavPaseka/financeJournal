package com.psm.financialJournal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.psm.financialJournal.model.MonthMoney;
@Repository
public interface MonthRepo extends JpaRepository<MonthMoney, Long>{
	List<MonthMoney> findByIsIncomeAndNameMonth(Boolean isIncome, String nameMonth);
	@Query(value = "DELETE FROM month_money WHERE name =?1 AND name_month=?2", nativeQuery = true)
	void deleteMonthMoneyByName(String name, String nameMonth);
	@Query(value = "SELECT SUM(sum) FROM month_money WHERE is_income=?1 AND name_month=?2",
		   nativeQuery = true)
	Integer sumOfColumn(Boolean isIncome, String nameMonth);
	@Query(value = "SELECT table_name "
			+ "FROM information_schema.tables "
			+ "WHERE table_schema='public' "
			+ "ORDER BY table_name",
			nativeQuery = true)
	List<String> allTablesName();
}
