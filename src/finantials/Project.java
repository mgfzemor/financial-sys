package finantials;

import general.Database;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import general.AppUtils;

public class Project extends AbstractCommander {

	private Database db = new Database();

	/**
	 *  
	 */
	public void generateReportDrivesPeriod(int startMonth, int endMonth) {

	}

	/**
	 *  
	 */
	public void calculateDrivePeriod(int startMonth, int endMonth) {

	}

	/**
	 *  
	 */
	public void calculateDrivesMonth(int month) {

	}

	/**
	 *  
	 */
	public void calculateDrivesDiffForEachRubric(BudgetedYear budgeted, RealizedYear realized) {

	}

	/**
	 *  
	 */
	public Database calculateDriveRubricDiff(BudgetedYear budgeted, RealizedYear realized, int rubricCode) {
		return null;
	}

	public void useRealizedAsBudgeted() {

	}

	public void insertRealizedMonth(Date month, Realized realized) {

	}

	public void generateReportDrivesMonth(int month) {

	}

	public void setBasePlan(BasePlan basePlan) {

	}

	public boolean checkRubricsOnBasePlan(List<Rubric> rubrics) {
		return false;
	}
	
	
	public void setRealizedCurrentYear(Realized realized) {
		this.db.storeRealizedCurrentYear(realized);
	}
	
	public void setRealizedLastYear(RealizedYear realized) {
		this.db.storeRealizedLastYear(realized);
	}

	public void setBudgeted(Budgeted budgeted) {
		this.db.storeBudgeted(budgeted);
	}

	public void setBasePlan(List<Rubric> rubricBase) {
		this.db.storeBasePlan(rubricBase);
	}
	
	public Realized getRealizedCurrentYearByMonth(int month) {
		return this.db.loadRealizedCurrentYearByMonth(month);
	}
	
	public Realized getRealizedLastYearByMonth(int month) {
		return this.db.loadRealizedLastYearByMonth(month);
	}
	
	public Collection<Realized> getRealizedsCurrentYear(){
		return this.db.loadRealizedsCurrentYear();
	}
	
	public Collection<Realized> getRealizedsLastYear(){
		return this.db.loadRealizedsLastYear();
	}

	public Budgeted getBudgetedByMonth(int month) {
		return this.db.loadBudgetedByMonth(month);

	}
	
	public Collection<Budgeted> getBudgeteds(){
		return this.db.loadBudgeteds();
	}
	
	public BasePlan getBasePlan() {
		return this.db.loadBasePlan();
	}

}
