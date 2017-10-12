package finantials;

import java.util.Date;

public abstract class AbstractCommander {

	protected Project project;

	public void createProject() {

	}

	public void openProject() {

	}

	public void insertPlanBase() {

	}

	public void insertBaseRealizedLastYear() {

	}

	public void createBudgetedPlan() {

	}

	public void changeBudgetedPlan() {

	}

	public void insertRealizedMonth(Date month, Realized realized) {

	}

	public void exportDrivesOfPeriod(int startMonth, int endMonth) {

	}

	public void exportDrivesOfMonth(int month) {

	}

	public void setBugetedPlanFreezeDate(Date data) {

	}

	public void keepRealizedFromLastYear() {

	}

	public void modifyBudgetedMonth(Date month, float value, boolean absolute) {

	}

	public void modifyBudgetedYear(float value, boolean absolute) {

	}

}
