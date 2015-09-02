package com.saresh.bionic.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.springframework.context.annotation.Scope;

import com.saresh.bionic.report.Result;
import com.saresh.bionic.report.ResultByDate;
import com.saresh.bionic.report.ResultByFish;
import com.saresh.bionic.service.ParcelService;

@Named
@Scope("session")
public class ReportBean implements Serializable {
	private static final long serialVersionUID = 14412312499929449L;
	
	private java.util.Date dateSince;
	private java.util.Date dateTo;
	
	private List<Result> reportList = new ArrayList<Result>();
	private List<ResultByFish> reportByFishList;
	private List<ResultByDate> reportByDateList;
	private String currentChart = "";
	
	private HorizontalBarChartModel weightChart;
	private HorizontalBarChartModel incomeAndProfitChart;
	
	@Inject
	ParcelService parcelService;
	
	public String updateTotalReport(){
		reportList.clear();
		java.sql.Date ds = new java.sql.Date(dateSince.getTime());
		java.sql.Date dt = new java.sql.Date(dateTo.getTime());
		
		reportList.add(parcelService.getTotalReport(ds, dt));
		
		return "/gm/totalReport";
	}
	
	public String updateReportByFish(){
		java.sql.Date ds = new java.sql.Date(dateSince.getTime());
		java.sql.Date dt = new java.sql.Date(dateTo.getTime());
		
		reportByFishList = parcelService.getReportByFish(ds, dt);		
		
		currentChart = "Fish";
		createWeightChartModel("Fish");
		createIncAndProfitChartModel("Fish");
		
		return "/gm/reportByFish";
	}
	
	public String updateReportByDate(){
		java.sql.Date ds = new java.sql.Date(dateSince.getTime());
		java.sql.Date dt = new java.sql.Date(dateTo.getTime());
		
		reportByDateList = parcelService.getReportByDate(ds, dt);
		
		currentChart = "Date";
		createWeightChartModel("Date");
		createIncAndProfitChartModel("Date");
		
		return "/gm/reportByDate";
	}

	public void createWeightChartModel(String type){
		weightChart = new HorizontalBarChartModel();
		
		ChartSeries weightCS; 
		
		if (type.equals("Fish")){
			weightCS = getWeightCSByFish();
		} else {
			weightCS = getWeightCSByDate();
		}
		weightCS.setLabel("Weight");
		
		weightChart.addSeries(weightCS);
		weightChart.setTitle("Weight sold");
		weightChart.setLegendPosition("e");
		
		Axis x = weightChart.getAxis(AxisType.X);
		x.setLabel("Tons");
		x.setMin(0);
		
		Axis y = weightChart.getAxis(AxisType.Y);
		y.setLabel(type);
				
	}
	
	private void createIncAndProfitChartModel(String type){
		incomeAndProfitChart = new HorizontalBarChartModel();
		
		ChartSeries income;
		ChartSeries profit;
		
		if (type.equals("Fish")){
			income = getIncomeCSByFish();
			profit = getProfitCSByFish();
		} else {
			income = getIncomeCSByDate();
			profit = getProfitCSByDate();
		}
		income.setLabel("Income");
		profit.setLabel("Profit");
				
		incomeAndProfitChart.addSeries(profit);
		incomeAndProfitChart.addSeries(income);
		incomeAndProfitChart.setTitle("Income and profit");
		incomeAndProfitChart.setLegendPosition("e");
		
		Axis x = incomeAndProfitChart.getAxis(AxisType.X);
		x.setMin(0);
		x.setLabel("Dollars");
	
		Axis y = incomeAndProfitChart.getAxis(AxisType.Y);
		y.setLabel(type);		
		
	}
	
	private ChartSeries getIncomeCSByFish(){
		ChartSeries cs = new ChartSeries();		
		for (ResultByFish res : reportByFishList){
			cs.set(res.getFish(), res.getIncome());
		}		
		return cs;	
	}
	
	private ChartSeries getProfitCSByFish(){
		ChartSeries cs = new ChartSeries();		
		for (ResultByFish res : reportByFishList){
			cs.set(res.getFish(), res.getProfit());
		}		
		return cs;	
	}
	
	private ChartSeries getIncomeCSByDate(){
		ChartSeries cs = new ChartSeries();
		for (ResultByDate res : reportByDateList){
			cs.set(res.getDate(), res.getIncome());
		}		
		return cs;	
	}
	
	private ChartSeries getProfitCSByDate(){
		ChartSeries cs = new ChartSeries();
		for (ResultByDate res : reportByDateList){
			cs.set(res.getDate(), res.getProfit());
		}		
		return cs;	
	}
	
	private ChartSeries getWeightCSByDate(){
		ChartSeries cs = new ChartSeries();
		for (ResultByDate res : reportByDateList){
			cs.set(res.getDate(), res.getWeight());
		}		
		return cs;		
	}
	
	private ChartSeries getWeightCSByFish(){
		ChartSeries cs = new ChartSeries();		
		for (ResultByFish res : reportByFishList){
			cs.set(res.getFish(), res.getWeight());
		}		
		return cs;		
	}
	
	public java.util.Date getDateSince() {
		return dateSince;
	}

	public void setDateSince(java.util.Date dateSince) {
		this.dateSince = dateSince;
	}

	public java.util.Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(java.util.Date dateTo) {
		this.dateTo = dateTo;
	}

	public List<Result> getReportList() {
		return reportList;
	}

	public void setReportList(List<Result> reportList) {
		this.reportList = reportList;
	}

	public List<ResultByFish> getReportByFishList() {
		return reportByFishList;
	}

	public void setReportByFishList(List<ResultByFish> reportByFishList) {
		this.reportByFishList = reportByFishList;
	}

	public List<ResultByDate> getReportByDateList() {
		return reportByDateList;
	}

	public void setReportByDateList(List<ResultByDate> reportByDateList) {
		this.reportByDateList = reportByDateList;
	}

	public HorizontalBarChartModel getWeightChart() {
		return weightChart;
	}

	public void setWeightChart(HorizontalBarChartModel weightChart) {
		this.weightChart = weightChart;
	}

	public HorizontalBarChartModel getIncomeAndProfitChart() {
		return incomeAndProfitChart;
	}

	public void setIncomeAndProfitChart(HorizontalBarChartModel incomeAndProfitChart) {
		this.incomeAndProfitChart = incomeAndProfitChart;
	}

	public String getCurrentChart() {
		return currentChart;
	}

	public void setCurrentChart(String currentChart) {
		this.currentChart = currentChart;
	}

	

}
