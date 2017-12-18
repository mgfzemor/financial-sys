package general;

import finantials.YearlyBills;

public class MemoryDatabase implements Database {

	private YearlyBills realized;

	private YearlyBills budgetPlan;

	private YearlyBills budgetPlanRealizations;

	public void setRealizedFromLastYear(YearlyBills realized) {
		this.realized = realized;
	}

	public void setBudgetPlan(YearlyBills budgetPlan) {
		this.budgetPlan = budgetPlan;
	}

	public void setBudgetPlanRealization(YearlyBills budgetPlanRealization) {
		this.budgetPlanRealizations = budgetPlanRealization;
	}

	public YearlyBills getRealizedFromLastYear() {
		return this.realized;
	}

	public YearlyBills getBudgetPlan() {
		return this.budgetPlan;
	}

	public YearlyBills getBudgetPlanRealization() {
		return this.budgetPlanRealizations;
	}

}
