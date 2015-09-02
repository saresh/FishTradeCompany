package com.saresh.bionic.report;

public class ResultByDate {
	private java.sql.Date date;
	private Long weight;
	private Long income;
	private Long profit;
	
	public ResultByDate(){}	
	
	public ResultByDate(java.sql.Date date, Long weight, Long income, Long profit) {
		this.date = date;
		this.weight = weight;
		this.income = income;
		this.profit = profit;
	}
	
	public Long getWeight() {
		return weight;
	}
	public void setWeight(Long weight) {
		this.weight = weight;
	}
	public Long getIncome() {
		return income;
	}
	public void setIncome(Long income) {
		this.income = income;
	}
	public Long getProfit() {
		return profit;
	}
	public void setProfit(Long profit) {
		this.profit = profit;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}
}
