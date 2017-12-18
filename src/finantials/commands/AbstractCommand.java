package finantials.commands;

import general.Parameters;
import general.Database;

public abstract class AbstractCommand implements Command {

	protected Database database;
	protected Parameters params;
	
	public void setParams(Parameters params) {
		this.params = params;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

}
