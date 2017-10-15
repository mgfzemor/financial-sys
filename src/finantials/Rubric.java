package finantials;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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

	/**
	 *  
	 */
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

	/**
	 *  
	 */
	public void setChildren(Rubric rubric) {
		children.put(rubric.code , rubric);
	}
	
	public Collection<Rubric> getAllChildrens(){
		return this.children.values();
	}

}
