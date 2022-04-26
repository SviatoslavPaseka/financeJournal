package com.psm.financialJournal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.psm.financialJournal.model.MonthMoney;
@Repository
public interface MonthRepo extends JpaRepository<MonthMoney, Long>{
	List<MonthMoney> findByIsIncome(Boolean isIncome);
	@Query(value = "DELETE FROM month_money WHERE name =?1", nativeQuery = true)
	void deleteMonthMoneyByName(String name);
	@Query(value = "SELECT SUM(sum) FROM month_money WHERE is_income=?1", nativeQuery = true)
	Integer sumOfColumn(Boolean isIncome);
	@Query(value = "SELECT table_name "
			+ "FROM information_schema.tables "
			+ "WHERE table_schema='public' "
			+ "ORDER BY table_name",
			nativeQuery = true)
	List<String> allTablesName();
}
