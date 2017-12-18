package finantials.commands;

import finantials.YearlyBills;
import finantials.YearlyBillsImpl;

public class CreateBudgetedPlanCommand extends AbstractCommand {

	public void execute() {
		boolean useFromLastYear = params.getInt("clone_realized_last_year") == 1;
		
		if (useFromLastYear) {
			YearlyBills realized = database.getRealizedFromLastYear().clone();
			database.setBudgetPlan(realized);
		}
		else {
			YearlyBills newplan = new YearlyBillsImpl();
			database.setBudgetPlan(newplan);
		}
	}

}
