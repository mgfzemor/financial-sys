package finantials;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Rubric extends RubricBase {

	private Map<Integer, Rubric> childrens;

	private float value;

	private RubricType type;
	
	public Rubric() {
		childrens = new HashMap<Integer, Rubric>();
	}
	
	public float getValue() {
		return this.value;
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
		childrens.put(rubric.code , rubric);
	}
	
	public void removeChildren(Rubric rubric) {
		this.childrens.remove(rubric.getCode());
	}
	
	public void removeAllChildrens() {
		this.childrens.clear();
	}
	
	public Collection<Rubric> getAllChildrens(){
		return this.childrens.values();
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
				case DEBIT: sum -= rubric.getValue();
					break;
				case CREDIT: sum += rubric.getValue();
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
