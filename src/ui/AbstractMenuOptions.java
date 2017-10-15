package ui;

import finantials.Project;

public class AbstractMenuOptions implements MenuOptions {

	protected Project project;
	protected AbstractMenuOptions(){
		this.project = new Project();
	}

	/**
	 * @see ui.MenuOptions#show()
	 */
	public void show() {

	}
}
