package finantials;

public class ShowRealizationsUntilNowCommand extends AbstractProjectCommand {
	
	@Override
	public void execute(Project project) {
		for(Realized realized: project.getRealizedsCurrentYear()) {
			this.output.println(realized.toString());
		}
	}

}
