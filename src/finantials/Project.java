package finantials;

import general.Database;
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

	public void setRealizedLastYear(RealizedYear realizedLastYear) {

	}

	public boolean checkRubricsOnBasePlan(List<Rubric> rubrics) {
		return false;
	}
	
	public BudgetedYear getBudgetedYear() {
		return this.db.getBudgetedYear();
	}

}
