package finantials.commands;

import finantials.MonthBill;
import finantials.Rubric;
import finantials.Rubric.RubricType;
import finantials.YearlyBills;
import finantials.YearlyBillsImpl;
import general.CSVResource;
import general.TableResource;

public class ReadRealizedFromLastYearCommand extends AbstractCommand {

	YearlyBills yearRealized;
	TableResource table;
	
	public void execute() {		
		table = new CSVResource();
		String filepath = params.getString("filepath");
		table.loadFromFile(filepath);
		
		YearlyBills realized = getYearRealized();
		database.setRealizedFromLastYear(realized);
	}
	
	public YearlyBills getYearRealized() {
		YearlyBills bills = new YearlyBillsImpl();
		
		setMonthBills(bills);
		
		return bills;
	}
	
	private void setMonthBills(YearlyBills bills) {
		
		for (int i = 0; i < 12; i++) {
			bills.setMonthBill(i, getMonthBill(i));
		}
	}

	private MonthBill getMonthBill(int month) {
		MonthBill monthBill = new MonthBill();
		
		Rubric mainRubric = getAllRubrics(month);
		monthBill.setMainRubric(mainRubric);
		monthBill.setRubricRecusively(mainRubric);
		
		return monthBill;
	}

	private Rubric getAllRubrics(int month) {
		
		Rubric root = new Rubric();
	
		Rubric parent = new Rubric();
		
		
		{
			Rubric credit = new Rubric();			
			int classification = table.getInt(2, 0);
			int code = table.getInt(2, 1);
			float value = table.getFloat(2, 3 + month);		
			String name = table.getString(2, 2);
			credit.setClassification(classification);
			credit.setCode(code);
			credit.setName(name);
			credit.setType(RubricType.Credit);
			credit.setValue(value);
			
			root.addChildren(credit);
		}
		
		for (int i = 6;i < table.rowCount();i++) {
			
			String name = table.getString(i, 2);

			if (name.length() > 0) {
				int classification = table.getInt(i, 0);
				int code = table.getInt(i, 1);
				float value = table.getFloat(i, 3 + month);
			
				Rubric rubric = new Rubric();
				rubric.setClassification(classification);
				rubric.setCode(code);
				rubric.setName(name);
				rubric.setValue(value);
				rubric.setType(RubricType.Debit);
				
				String rootClassificationString = parent != null ? "" + parent.getClassification() : "";
				String currentClassificationString = "" + rubric.getClassification();
				
				// root is father of the current classification
				if (rootClassificationString.length() < currentClassificationString.length() ) {
					parent.addChildren(rubric);				
				}
				else if (rootClassificationString.length() > currentClassificationString.length()) {
					parent = rubric;
				}
				
				root.addChildren(parent);
			}
		}
		
		return root;
	}
	
	
}
