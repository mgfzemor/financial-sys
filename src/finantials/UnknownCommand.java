/**
 * 
 */
package finantials;

/**
 * @author mgfzemor
 */
public class UnknownCommand extends AbstractProjectCommand {
	public void execute(Project project) {
		this.output.println("command not found");
	}
}
