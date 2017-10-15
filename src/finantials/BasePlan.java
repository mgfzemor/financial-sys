package finantials;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BasePlan {

	private Map<Integer, Rubric> rubricsBase;
	
	public BasePlan() {
		rubricsBase = new HashMap<Integer, Rubric>();
	}
	
	public void setRubric(Rubric rubric) {
		this.rubricsBase.put(rubric.getCode(), rubric);
	}
	
	public Rubric getRubric(int code) {
		return this.rubricsBase.get(code);
	}
	
	public void removeRubric(int code) {
		this.rubricsBase.remove(code);
	}
	
	public void setRubricsBase(List<Rubric> rubricsBase) {
		for(Iterator<Rubric> iterator = rubricsBase.iterator(); iterator.hasNext();) {
			Rubric rubric = iterator.next();
			this.rubricsBase.put(rubric.getCode(),rubric);
		}
	}
	
	public Collection<Rubric> getRubricsBase() {
		return this.rubricsBase.values();
	}
	
	public void removeAllRubrics() {
		this.rubricsBase.clear();
	}
	
	public boolean checkRubric(Rubric rubric) {
		return rubricsBase.containsKey(rubric.getCode());
	}
	
	public boolean checkRubrics(List<Rubric> rubrics) {
		boolean ret = true;
		for(Iterator<Rubric> iterator = rubrics.iterator(); iterator.hasNext();) {
			Rubric rubric = iterator.next();
			if(rubricsBase.containsKey(rubric.getCode())) {
				ret = false;
				break;
			}
		}
		return ret;
	}
}
