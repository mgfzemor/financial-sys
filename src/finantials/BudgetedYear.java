package finantials;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BudgetedYear {

	private Map<Integer,Budgeted> budgeteds;
	private Date freezingDate;
	
	public BudgetedYear() {
		budgeteds = new HashMap<Integer,Budgeted>();
	}
	
	public Budgeted getBudgetedByMonth(int month) {
		return this.budgeteds.get(month);
	}
	
	public void setBudgetedMonth(Budgeted budgeted) {
		this.budgeteds.put(budgeted.getMonth(), budgeted);
	}
	
	public Collection<Budgeted> getAllBudgeteds(){
		return this.budgeteds.values();
	}
	
	public void setFreezingDate(int day, int month, int year) {
		if(freezingDate == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month, day);
			this.freezingDate = calendar.getTime();
		}
	}
	
	public Date getFreezingDate() {
		return this.freezingDate;
	}
	
	public boolean isFrozen() {
		boolean frozen = false;
		Date currentDate = new Date();
		if(!(freezingDate == null)) {
			if(currentDate.after(this.freezingDate)){
				frozen = true;
			}
		}
		return frozen;
	}
	
	public void removeBudgeted(int month) {
		this.budgeteds.remove(month);
	}
	
	public void removeAllBudgeteds() {
		this.budgeteds.clear();
	}
	
}
