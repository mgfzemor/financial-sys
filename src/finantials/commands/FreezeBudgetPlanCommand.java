package finantials.commands;

import finantials.YearlyBills;

public class FreezeBudgetPlanCommand extends AbstractCommand {

	@Override
	public void execute() {

		YearlyBills budgetPlan = database.getBudgetPlan();
		budgetPlan.freezeBills();
		database.setBudgetPlan(budgetPlan);

	}

}
