package finantials;

import general.Input;
import general.Output;

public abstract class AbstractProjectCommand implements ProjectCommand {

	protected Input input;
	protected Output output;


	/**
	 * @see finantials.ProjectCommand#setInputStream(general.Input)
	 * 
	 *  
	 */
	public void setInputStream(Input input) {
		this.input = input;
	}


	/**
	 * @see finantials.ProjectCommand#setOutputStream(general.Output)
	 * 
	 *  
	 */
	public void setOutputStream(Output output) {
		this.output = output;
	}


	/**
	 * @see finantials.ProjectCommand#execute(finantials.Project)
	 * 
	 *  
	 */
	public void execute(Project project) {

	}

}
