package ui;

import java.io.PrintStream;
import java.util.Scanner;

import finantials.commands.Command;
import finantials.commands.CreateBudgetedPlanCommand;
import finantials.commands.EditBudgetPlanCommand;
import finantials.commands.FreezeBudgetPlanCommand;
import finantials.commands.ReadRealizedFromLastYearCommand;
import finantials.commands.ViewBudgetPlanEntriesCommand;
import general.Database;
import general.Parameters;

public class CommandExecutorViaCmd implements CommandExecutor {

	private Database database;
	private Scanner scanner;
	private PrintStream out;
	private boolean running;
	private int menuLevel;

	public CommandExecutorViaCmd() {
		this.scanner = new Scanner(System.in);
		this.out = System.out;
		this.running = true;
		this.menuLevel = 0;
	}
	
	public void start() {
		
		while(running) {
			Command command = null;
			
			if (menuLevel == 0) {				
				printMainMenu();
				int option = getSelectedOption();
				switch(option) {
				case 1:
					command = new ReadRealizedFromLastYearCommand();
					Parameters params = getReadRealizedFromLastYearParameters();
					command.setParams(params);
					command.setDatabase(database);
					command.execute();
					menuLevel+=1;
					break;
					
				case 0:
					running = false;
					break;
					
				default:
					defaultSelected();
					break;
				}
			}
			else if (menuLevel == 1) {
				printCreateBudgetPlan();
				int option = getSelectedOption();
				command = new CreateBudgetedPlanCommand();
				Parameters params = new Parameters();
				
				switch(option) {
				case 1:					
					params.setInt("clone_realized_last_year", 1);
					command.setParams(params);
					command.execute();
					menuLevel+=1;
					break;
					
				case 2:
					params.setInt("clone_realized_last_year", 0);
					command.setParams(params);
					command.execute();
					menuLevel+=1;
					break;
					
				case 0:
					running = false;
					break;
					
				default:
					defaultSelected();
					break;
				}
			}
			else if (menuLevel == 2) {
				printVisualizeOrModifyBudgetPlan();
				
				int option = getSelectedOption();
				
				switch(option) {
				case 1:
					command = new ViewBudgetPlanEntriesCommand();
					command.execute();
					out.println("Abra o arquivo 'view_budgetplan.csv");
					break;
					
				case 2:
					menuLevel+=1;
					break;
					
				case 0:
					running = false;
					break;
					
				default:
					defaultSelected();
					break;
				}
			}
			else if (menuLevel == 3) {
				printEditBudgetPlanMenu();
				int option = getSelectedOption();
				
				command = new EditBudgetPlanCommand();
				out.print("entre com um valor: ");
				float value = scanner.nextFloat();
				Parameters params = new Parameters();
				params.setFloat("value", value);
				
				switch(option) {
				case 1:
					params.setInt("relative", 1);
					command.setParams(params);
					command.execute();					
					break;
					
				case 2:
					params.setInt("relative", 0);
					command.setParams(params);
					command.execute();					
					break;
					
				case 3:
					command = new FreezeBudgetPlanCommand();
					command.execute();
					menuLevel += 1;
					out.println("Plano de contas congelado. Não é mais possível edita-lo");
					break;
					
				case 4:
					menuLevel -= 1;
					break;
					
				case 0:
					running = false;
					break;
					
				default:
					defaultSelected();
					break;
				}
			}
			else if (menuLevel == 4) {
				printEnterWithRealizations();
				int option = getSelectedOption();
				
				switch(option) {
				case 1:
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				case 4:
					
					break;
					
				case 0:
					running = false;
					break;
					
				default:
					defaultSelected();
					break;					
				}
			}
		}
	}
	
	public void setDatabase(Database database) {
		this.database = database;
	}

	private void printMainMenu() {
		out.println("1 - Ler realizado do ano anterior");
		out.println("0 - Sair");
	}
	
	private void printCreateBudgetPlan() {
		out.println("1 - Criar plano com base no realizado do ano anterior");
		out.println("2 - Criar um plano base novo");
		out.println("0 - Sair");
	}
	
	private void printVisualizeOrModifyBudgetPlan() {
		out.println("1 - Visualizar o plano base");
		out.println("2 - Editar plano base");
		out.println("0 - Sair");
	}
	
	private void printEditBudgetPlanMenu() {
		out.println("1 - Incrementar relativamente em percentagem todas as rubrica");
		out.println("2 - Incrementar absolutamente em reais todas as rubricas");
		out.println("3 - Congelar o plano de orçamento");
		out.println("4 - Retornar ao menu anterior");
		out.println("0 - Sair");
	}
	
	private void printEnterWithRealizations() {
		out.println("1 - Visualizar o plano base");
		out.println("2 - Visualizar realizados até o momento");
		out.println("3 - Visualizar realizado do ano anterior");
		out.println("4 - Entrar com realizado do mês");
		out.println("0 - Sair");
	}
	
	private int getSelectedOption() {
		return scanner.nextInt();
	}
	
	private void defaultSelected() {
		out.println("Opção desconhecida. Tente novamente");
	}
	
	private Parameters getReadRealizedFromLastYearParameters() {
		out.print("Insira o caminha do realizado do ano anterior: ");
		String filePath = scanner.nextLine();
		Parameters params = new Parameters();
		params.setString("filepath", filePath);
		
		return params;
	}
}
