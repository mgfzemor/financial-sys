package finantials.commands;

import general.*;
import finantials.*;

public class ViewBudgetPlanEntriesCommand extends AbstractCommand {

	@Override
	public void execute() {
		TableResource table = new CSVResource();
		
		YearlyBills budgetPlan = database.getBudgetPlan();
		
		//build file header
		String[] header = {"Classification","Code","Name","Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov","Dec"};
		
		for (int i = 0; i < header.length; i++) {			
			table.setValue(0, i, header[i]);
		}
		
		// build file out as string to save as csv
		for (int month = 0; month < 12; month++) {
			
			MonthBill bill = budgetPlan.getMonthBill(month);
			Rubric[] rubrics = bill.getIndividualBillsDescription();
			
			for (int i = 0; i < rubrics.length; i++) {
				
				Rubric rubric = rubrics[i];
				table.setValue(i + 1, month + 0, rubric.getClassification());
				table.setValue(i + 1, month + 1, rubric.getCode());
				table.setValue(i + 1, month + 2, rubric.getName());
				table.setValue(i + 1, month + 3, rubric.getValue());
			}			
		}
		
		table.saveToFile("view_budgetplan.csv");		
	}

}
