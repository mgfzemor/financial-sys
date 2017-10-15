package finantials;

public class ShowBudgetedPlanCommand extends AbstractProjectCommand {

	@Override
	public void execute(Project project) {
		
		int month = input.getInt();
		for (Budgeted budgeted : project.getBudgeteds()) {
			output.println(""+budgeted.getMonth());
			
			for (Rubric rubric : budgeted.getAllRubrics()) {
				output.println(rubric.getName());
				output.println(""+rubric.CalcResult());
			}
		}
	}
}
