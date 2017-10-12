package finantials;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rubric extends RubricBase {

	private Map<Integer, Rubric> children;

	private float value;

	private Enum type;
	
	public Rubric() {
		children = new HashMap<Integer, Rubric>();
	}

	/**
	 *  
	 */
	public float CalcResult() {
		return 0;
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
