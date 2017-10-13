package finantials;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BudgetedYear {

	private Map<Integer,Budgeted> budgeted;
	private Date freezingDate;
	
	public BudgetedYear() {
		budgeted = new HashMap<Integer,Budgeted>();
	}
	
	public Budgeted getBudgetedByMonth(int month) {
		return this.budgeted.get(month);
	}
	
	public void setBudgetedMonth(int month, Budgeted budgeted) {
		this.budgeted.put(month, budgeted);
	}
	
	public Collection<Budgeted> getAllBudgeteds(){
		return this.budgeted.values();
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
	
}
