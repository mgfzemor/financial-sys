package finantials;

import java.util.Collection;

public class CreateBudgetedPlanCommand extends AbstractProjectCommand {
	Budgeted budgeted = new Budgeted();
	
	@Override
	public void execute(Project project) {
		boolean keep = true;
		do {
			int month = this.showMonthOptions();
			Realized realized = project.getRealizedLastYearByMonth(month);
			this.output.println(realized.rubricsToString());
			this.output.println("Select a rubric code to budget: ");
			int code = this.input.getInt();
			Rubric rubric = realized.getRubric(code);
			int option = this.showRubricOptions();
			rubric = this.executeOption(option, rubric);
			this.output.println("new amount:");
			this.output.println(rubric.toString());
			budgeted.setRubric(rubric);
			budgeted.setMonth(month);
			project.setBudgeted(budgeted);
			keep = this.showInsertMore();
		} while(keep);
	}
	
	private Rubric executeOption(int option, Rubric rubric) {
		switch(option) {
			case 1:// Percentage
				int signal = this.showSignalOprions();
				this.output.println("Insert percentage: ");
				float percentage = this.input.getFloat();
				rubric = this.subCommandPercentage(percentage, signal, rubric);
				break;
			case 2: // Fixed
				this.output.print("Insert the new amount: ");
				float amount = this.input.getFloat();
				rubric = this.subCommandFixed(amount, rubric);
				break;
			case 3:// Unchanged
				break;
			default:
				break;
		}
		
		return rubric;
	}
	
	private Rubric subCommandFixed(float amount, Rubric rubric) {
		rubric.setValue(amount);
		return rubric;
	}
	
	private Rubric subCommandPercentage(float percentage, int operationSignal, Rubric rubric) {
		float newAmount = rubric.getValue();
		newAmount += (newAmount* (percentage/100))*operationSignal;
		rubric.setValue(newAmount);
		return rubric;
	}
	

	private int showMonthOptions() {
		int option = 0;
		this.output.println("---------------------");
		this.output.println("| 1 - January\n"
						  + "| 2 - February\n"
						  + "| 3 - March\n"
						  + "| 4 - April\n"
						  + "| 5 - May\n"
						  + "| 6 - June\n"
						  + "| 7 - July\n"
						  + "| 8 - August\n"
						  + "| 9 - September\n"
						  + "| 10 - October\n"
						  + "| 11 - November\n"
						  + "| 12 - December");
		do {
			this.output.println("---------------------");
			this.output.print("Select a month for budget: ");
			option = this.input.getInt();
		} while (option < 1 || option > 12);
		return option;
	}
	
	private int showRubricOptions() {
		int option = 0;
		this.output.println("---------------------");
		this.output.println("| 1 - Percentage\n"
						  + "| 2 - Fixed\n"
				          + "| 3 - Unchanged");
		do {
			this.output.println("---------------------");
			this.output.print("Select the type of modification: ");
			option = this.input.getInt();
		} while(option < 1 || option > 3);
		return option;
	}
	
	private int showSignalOprions() {
		int option = 0;
		int signal = 1;
		this.output.println("---------------------");
		this.output.println("| 1 - Increase\n"
				  		  + "| 2 - Decrease");
		do {
			this.output.println("---------------------");
			this.output.print("Select operation type");
			option = this.input.getInt();
			
			switch(option) {
				case 1: //Increase
					signal = 1;
					break;
				case 2: //Decrease
					signal = -1;
					break;
				default:
					this.output.println("Invalid option");
					break;
			}
		} while(option< 1 || option > 2);
		return signal;
	}
	
	private boolean showInsertMore() {
		boolean ret = true;
		this.output.println("---------------------");
		this.output.println("| 1 - Yes\n"
		  		          + "| 2 - No");
		this.output.println("---------------------");
		this.output.print("Continue budget? ");
		int option = this.input.getInt();
		switch(option) {
		case 1: //Increase
			ret = true;
			break;
		case 2: //Decrease
			ret = false;
			break;
		default:
			break;
		}
		return ret;
	}
	
}
