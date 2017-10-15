package general;

import finantials.Realized;
import finantials.RealizedYear;
import finantials.BudgetedYear;
import finantials.Rubric;

import java.util.Collection;
import java.util.List;
import finantials.Budgeted;
import finantials.BasePlan;

public class Database {

	private BudgetedYear budgetedYear;
	private RealizedYear realizedCurrentYear;
	private RealizedYear realizedLastYear;
	private BasePlan basePlan;
	
	public Database(){
		 budgetedYear = new BudgetedYear();
		 realizedCurrentYear = new RealizedYear();
		 realizedLastYear = new RealizedYear();
		 basePlan = new BasePlan();
	 }

	public void storeRealizedCurrentYear(Realized realized) {
		this.realizedCurrentYear.setRealized(realized);
	}
	
	public void storeRealizedLastYear(RealizedYear realizedLastYear) {
		this.realizedLastYear = realizedLastYear;
	}

	public void storeBudgeted(Budgeted budgeted) {
		this.budgetedYear.setBudgetedMonth(budgeted);
	}

	public void storeBasePlan(List<Rubric> rubricBase) {
		this.basePlan.setRubricsBase(rubricBase);
	}
	
	public Realized loadRealizedCurrentYearByMonth(int month) {
		return this.realizedCurrentYear.getRealized(month);
	}
	
	public Realized loadRealizedLastYearByMonth(int month) {
		return this.realizedLastYear.getRealized(month);
	}
	
	public Collection<Realized> loadRealizedsCurrentYear(){
		return this.realizedCurrentYear.getAllRealizeds();
	}
	
	public Collection<Realized> loadRealizedsLastYear(){
		return this.realizedLastYear.getAllRealizeds();
	}

	public Budgeted loadBudgetedByMonth(int month) {
		return this.budgetedYear.getBudgetedByMonth(month);

	}
	
	public Collection<Budgeted> loadBudgeteds(){
		return this.budgetedYear.getAllBudgeteds();
	}
	
	public BasePlan loadBasePlan() {
		return this.basePlan;
	}
}
