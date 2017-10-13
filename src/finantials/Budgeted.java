package finantials;

import java.util.Map;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Budgeted extends AbstractBill {

	private Map<Integer, Rubric> rubrics;

	private Date month;
	
	public Budgeted() {
		this.rubrics = new HashMap<Integer, Rubric>();
	}
	
	public Date getMonth() {
		return this.month;
	}
	
	public void setMonth(Date month) {
		this.month = month;
	}
	
	public void setRubric(Rubric rubric) {
		this.rubrics.put(rubric.code, rubric);
	}
	
	public Rubric getRubric(int code) {
		return this.rubrics.get(code);
	}
	
	public Collection<Rubric> getAllRubrics(){
		return this.rubrics.values();
	}
}
