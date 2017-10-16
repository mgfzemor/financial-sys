package finantials;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

public class Realized extends AbstractBill implements Cloneable {
	
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
	
	public void removeRubric(int code) {
		this.rubrics.remove(code);
	}
	
	public void removeAllRubrics() {
		this.rubrics.clear();
	}
	
	public String rubricsToString() {
		String string = "---------------------";
		for(Rubric rubric: this.getAllRubrics()) {
			string += rubric.toString();
		}
		string += "---------------------";
		return string;
	}
	
	public String toString() {
		String string = "realized month: "+ this.month;
		string += this.rubricsToString();
		return string;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
