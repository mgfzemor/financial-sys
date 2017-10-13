package finantials;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

public class Realized extends AbstractBill {
	
	private Map<Integer, Rubric> rubrics;

	private int month;
	
	public Realized() {
		this.rubrics = new HashMap<Integer, Rubric>();
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setRubric(Rubric rubric) {
		this.rubrics.put(rubric.code, rubric);
	}
	
	public void setRubrics(Collection<Rubric> rubrics) {
		rubrics.forEach((rubric) -> {
			this.setRubric(rubric);
		});
	}
	
	public Rubric getRubric(int code) {
		return this.rubrics.get(code);
	}
	
	public Collection<Rubric> getAllRubrics(){
		return this.rubrics.values();
	}

}
