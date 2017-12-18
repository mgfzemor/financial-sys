package general;

import ui.CommandExecutor;
import ui.CommandExecutorViaCmd;

public class App {

	private CommandExecutor menuOptions;

	public static void main(int args) {
		
		App app = new App();
		app.start();
	}
	
	public void start() {
		menuOptions = new CommandExecutorViaCmd();
		menuOptions.setDatabase(new MemoryDatabase());
		menuOptions.start();
	}

}
