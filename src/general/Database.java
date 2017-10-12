package general;

import finantials.Realized;
import finantials.RealizedYear;
import finantials.BudgetedYear;
import java.util.HashMap;
import java.util.Map;
import finantials.Budgeted;
import finantials.BasePlan;

public class Database {

	private BudgetedYear budgetedYear;
	private RealizedYear realizedYear;
	
	public Database(){
		 budgetedYear = new BudgetedYear();
	 }
	/**
	 *  
	 */
	public void storeRealized(int year, int month, Realized realized) {

	}

	/**
	 *  
	 */
	public void storeBudgeted(int year, Budgeted budgeted) {

	}

	/**
	 *  
	 */
	public Realized loadRealized(int month) {
		return null;
	}

	/**
	 *  
	 */
	public void loadBudgeted(int month) {

	}
	
	public void modifyBudgetedYear(int month, Budgeted budgeted) {
		this.budgetedYear.setBudgetedMonth(month, budgeted);
	}

	/**
	 *  
	 */
	public void storeBasePlan(BasePlan basePlan) {

	}
	
	public BudgetedYear getBudgetedYear() {
		return this.budgetedYear;
	}

}
