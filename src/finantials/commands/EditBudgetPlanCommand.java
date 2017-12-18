package finantials.commands;
import finantials.*;

public class EditBudgetPlanCommand extends AbstractCommand {

	@Override
	public void execute() {
		
		boolean isRelative = params.getInt("relative") == 1;
		float value = params.getFloat("value");
		YearlyBills budgetplan = database.getBudgetPlan();
		if (isRelative) {
			alterBudgetPlanRelatively(budgetplan, value);
		}
		else {
			alterBudgetPlanAbsoluteValue(budgetplan, value);
		}
		
		database.setBudgetPlan(budgetplan);
	}
	
	private void alterBudgetPlanRelatively(YearlyBills budgetplan, float increasePercentage) {
		
		for (int i = 0; i < 12; i++) {
			
			MonthBill monthBill = budgetplan.getMonthBill(i);
			
			Rubric[] rubrics = monthBill.getIndividualBillsDescription();
			
			for (int j = 0; j < rubrics.length; j++) {
				
				float value = rubrics[j].getValue() + rubrics[j].getValue() * increasePercentage;
				rubrics[i].setValue(value);
				monthBill.setRubric(rubrics[i]);
			}
			
			budgetplan.setMonthBill(i, monthBill);
		}
	}
	
	private void alterBudgetPlanAbsoluteValue(YearlyBills budgetplan, float value) {
		
		for (int i = 0; i < 12; i++) {
			
			MonthBill monthBill = budgetplan.getMonthBill(i);
			
			Rubric[] rubrics = monthBill.getIndividualBillsDescription();
			
			for (int j = 0; j < rubrics.length; j++) {
				rubrics[i].setValue(rubrics[j].getValue() + value);
				monthBill.setRubric(rubrics[i]);
			}
			
			budgetplan.setMonthBill(i, monthBill);
		}		
	}

}
