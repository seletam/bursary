package com.bursary.bursary.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * Seleta M. Mootwane
 * 2018-08-23
 */
@Entity
@Table(name = "CompanyRevenue")
public class CompanyRevenue {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "Revenue_Month", nullable = false)
	private String month;

	private double revenue;

	private double expense;

	private double margins;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public double getMargins() {
		return margins;
	}

	public void setMargins(double margins) {
		this.margins = margins;
	}

}