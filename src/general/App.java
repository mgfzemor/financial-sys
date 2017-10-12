package general;

import finantials.*;

import ui.MenuOptions;

public class App {

	private static Project p = new Project();
	private static MenuOptions menuOptions;

	public static void main(String args[]) {
		p.getBudgetedYear().setFreezingDate(13,9, 2017);
		if(p.getBudgetedYear().isFrozen()) {
			System.out.println("frozen");
		}
		else {
			System.out.println("not frozen yet");
		}
	}

}
