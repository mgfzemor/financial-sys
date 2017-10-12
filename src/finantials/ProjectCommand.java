package finantials;

import general.Input;
import general.Output;

public interface ProjectCommand {

	/**
	 *  
	 */
	public abstract void setInputStream(Input input);

	/**
	 *  
	 */
	public abstract void setOutputStream(Output output);

	/**
	 *  
	 */
	public abstract void execute(Project project);

}
