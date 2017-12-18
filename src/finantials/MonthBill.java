package finantials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MonthBill {

	private HashMap<Integer, Rubric> rubricsByCode;

	private Rubric rootRubric;
	
	public MonthBill() {
		rubricsByCode = new HashMap<Integer, Rubric>();
	}

	public MonthBill compareWith(MonthBill other) {
		
		Rubric[] otherRubrics = other.getIndividualBillsDescription();
		MonthBill result = new MonthBill();
		result.setMainRubric(rootRubric);
		
		for (Rubric otherRubric : otherRubrics) {
			Rubric selfRubric = rubricsByCode.get(otherRubric.getCode());
			
			Rubric resultRubric = new Rubric();
			resultRubric.setValue(selfRubric.getValue() - otherRubric.getValue());
			resultRubric.setCode(otherRubric.getCode());
			resultRubric.setClassification(otherRubric.getClassification());
			resultRubric.setName(otherRubric.getName());
			resultRubric.setType(otherRubric.getType());
			
			result.setRubric(selfRubric);
		}
		
		return result;
	}

	public Rubric[] getIndividualBillsDescription() {
		List<Rubric> rubrics = new ArrayList<Rubric>(); 
		
		for (Rubric rubric : rubricsByCode.values()) {
			rubrics.add(rubric);
		}
		
		return (Rubric[])rubrics.toArray();
	}

	public void setMainRubric(Rubric rubric) {
		rootRubric = rubric;
	}
	
	public void setRubric(Rubric rubric) {
		rubricsByCode.put(rubric.getCode(), rubric);
	}
	
	public void setRubricRecusively(Rubric main) {
		setRubric(main);
		for(Rubric child : main.getChildren())
			setRubricRecusively(child);
	}
	
	public MonthBill clone() {
		
		MonthBill bill = new MonthBill();
		
		bill.rubricsByCode.putAll(rubricsByCode);
		bill.rootRubric = rootRubric.clone();
		
		return bill;
	}
	
}
