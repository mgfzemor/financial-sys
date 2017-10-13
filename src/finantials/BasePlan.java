package finantials;

import java.util.List;

public class BasePlan {

	private List<RubricBase> rubricsBase;

	public boolean checkRubrics(List<Rubric> rubrics) {
		return false;
	}

	public boolean checkRubric(Rubric rubric) {
		return false;
	}
	
	public void setRubricsBase(List<RubricBase> rubricsBase) {
		this.rubricsBase = rubricsBase;
	}

	public List<RubricBase> getRubricsBase() {
		return this.rubricsBase;
	}
}
