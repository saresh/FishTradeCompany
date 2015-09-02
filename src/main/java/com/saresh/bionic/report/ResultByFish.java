package com.saresh.bionic.report;

public class ResultByFish {
	private String fish;
	private Long weight;
	private Long income;
	private Long profit;		
	
	public ResultByFish(){}
	
	public ResultByFish(String fish, Long weight, Long income, Long profit){
		this.fish = fish;
		this.weight = weight;
		this.income = income;
		this.profit = profit;
	}
	
	public String getFish() {
		return fish;
	}	
	
	public void setFish(String fish) {
		this.fish = fish;
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
