package general;

import finantials.YearlyBills;

public interface Database {

	public abstract void setRealizedFromLastYear(YearlyBills realized);

	public abstract void setBudgetPlan(YearlyBills budgetPlan);

	public abstract void setBudgetPlanRealization(YearlyBills budgetPlanRealization);

	public abstract YearlyBills getRealizedFromLastYear();

	public abstract YearlyBills getBudgetPlan();

	public abstract YearlyBills getBudgetPlanRealization();

}
