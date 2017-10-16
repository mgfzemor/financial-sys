package ui;
import finantials.AbstractProjectCommand;
import finantials.CreateBudgetedPlanCommand;
import finantials.ExitCommand;
import finantials.InsertBasePlanCommand;
import finantials.InsertRealizedMonthCommand;
import finantials.ModifyBudgetedMonthCommand;
import finantials.ModifyBudgetedYearCommand;
import finantials.ShowRealizationsUntilNowCommand;
import finantials.ShowRealizedLastYear;
import finantials.UnknownCommand;
import general.CmdInput;
import general.CmdOutput;
public class MenuOptionsCmd extends AbstractMenuOptions implements MenuOptions {
	CmdInput input;
	CmdOutput output;
	AbstractProjectCommand command;
	int option;
	
	public MenuOptionsCmd(){
		this.input = new CmdInput();
		this.output = new CmdOutput();
	}

	/**
	 * @see ui.MenuOptions#show()
	 */
	public void show() {
		this.showMenuOptions();
		do {		
			this.output.println("-----------------------------");
			this.output.print("finantial-sys@command ~ $ ");
			option = this.input.getInt();
			switch(this.option) {
				case 1:
					this.command = new InsertBasePlanCommand();
					break;
				case 2:
					this.command = new CreateBudgetedPlanCommand();
					break;
				case 3:
					this.command = new ModifyBudgetedMonthCommand();
					break;
				case 4:
					this.command = new ModifyBudgetedYearCommand();
					break;
				case 5:
					this.command = new InsertRealizedMonthCommand();
					break;
				case 6:
					this.command = new ShowRealizedLastYear();
					break;
				case 7:
					this.command = new ShowRealizationsUntilNowCommand();
					break;
				case 0:
					this.command = new ExitCommand();
					break;
				default:
					this.command = new UnknownCommand();
					break;
			}
			
			this.command.setInputStream(this.input);
			this.command.setOutputStream(this.output);
			this.command.execute(project);
		} while(option != 0);
	}
	
	private void showMenuOptions() {
		this.output.println("Finantial-SYS");
		this.output.println("-----------------------------");
		this.output.println("API Options");
		this.output.println("1 - Import Realized Last Year\n"
						  + "2 - Create  a Budget plan\n"
						  + "3 - Change Budgeted month\n"
						  + "4 - Change Budgeted year\n"
						  + "5 - Import Realized month\n"
						  + "6 - Show Realized Last Year\n"
						  + "7 - Show Realizeds current year ");
	}
}
