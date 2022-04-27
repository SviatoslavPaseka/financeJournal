package com.psm.financialJournal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MonthMoney{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Integer sum;
	private Boolean isIncome;
	private String nameMonth;
	public MonthMoney(String name, Integer sum, Boolean isIncome, String nameMonth) {
		this.name = name;
		this.sum = sum;
		this.isIncome = isIncome;
		this.nameMonth = nameMonth;
	}
	
	
}

