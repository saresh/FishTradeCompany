package com.saresh.bionic.report;

public class Result {
	private Long weight;
	private Long income;
	private Long profit;
	
	public Result(){}	
	
	public Result(Long weight, Long income, Long profit) {		
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
	

}
