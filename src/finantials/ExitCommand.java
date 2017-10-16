/**
 * 
 */
package finantials;

/**
 * @author mgfzemor
 *
 */
public class ExitCommand extends AbstractProjectCommand {
	public void execute(Project project) {
		this.output.println("Exiting...");
	}
}
