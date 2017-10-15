package finantials;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Rubric extends RubricBase {

	public enum RubricType {
		Debit, Credit
	}
	
	private Map<Integer, Rubric> children;

	private float value;

	private RubricType type;
	
	public Rubric() {
		children = new HashMap<Integer, Rubric>();
	}
	
	public float CalcResult() {
		if (getAllChildrens().size() > 0) {
			float componentValue = 0;
			for (Rubric rubric : getAllChildrens())
				componentValue += rubric.CalcResult();
			return componentValue;
		}
		else return value;
	}
	
	public void setValue(float value) {
		this.value = value;
	}
	
	public void setType(RubricType type) {
		this.type = type;
	}

	public RubricType getType() {
		return this.type;
	}
	
	public void setChildren(Rubric rubric) {
		children.put(rubric.code , rubric);
	}
	
	public void removeChildren(Rubric rubric) {
		this.children.remove(rubric.getCode());
	}
	
	public void removeAllChildrens() {
		this.children.clear();
	}
	
	public Collection<Rubric> getAllChildrens(){
		return this.children.values();
	}

	private float sumRubrics(Collection<Rubric> rubrics) {
		if (rubrics == null) {
			return 0;
		}
		else {
			float sum = 0;
			for(Iterator<Rubric> iterator = rubrics.iterator(); iterator.hasNext();) {
				Rubric rubric = iterator.next();
				RubricType type= rubric.getType();
				switch(type) {
				case Debit: sum -= rubric.CalcResult();
					break;
				case Credit: sum += rubric.CalcResult();
					break;
				default:
					break;
				}
				sum += this.sumRubrics(rubric.getAllChildrens());
			}
			return sum;
		}
	}
}
