package finantials;

import general.AppUtils;

public class InsertBasePlanCommand extends AbstractProjectCommand {

	public void execute(Project project){
		// resources/Modelo_Controle_Orcamentario_Completo.csv
		this.output.print("enter the file path: ");
		String filePath = this.input.getString();
		RealizedYear realizedLastYear;
		try {
			realizedLastYear = AppUtils.readRealizedLastYear(filePath);
			project.setRealizedLastYear(realizedLastYear);
			this.output.println("file uploaded successfully");
		} catch (Exception e) {
			this.output.println("Error reading file");
			//e.printStackTrace();
		}
	}
}