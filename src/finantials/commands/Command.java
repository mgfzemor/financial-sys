package finantials.commands;

import general.Parameters;
import general.Database;

public interface Command {

	public abstract void setParams(Parameters params);

	public abstract void setDatabase(Database database);

	public abstract void execute();

}
