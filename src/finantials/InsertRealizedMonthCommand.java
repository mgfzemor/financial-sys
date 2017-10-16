package finantials;

import general.AppUtils;

public class InsertRealizedMonthCommand extends AbstractProjectCommand {
	@Override
	public void execute(Project project) {
		this.output.print("enter the file path: ");
		String filePath = this.input.getString();
		try {
			Realized realized = AppUtils.readRealizedMonth(filePath);
			project.setRealizedCurrentYear(realized);
			this.output.println("Realized uploaded successfully.");
		} catch (Exception e) {
			this.output.println("Error reading file.");
		}
	}
}
