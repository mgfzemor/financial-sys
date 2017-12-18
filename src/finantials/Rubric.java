package finantials;

import java.util.ArrayList;
import java.util.List;

public class Rubric {
	
	public enum RubricType { Debit, Credit }

	private List<Rubric> children;

	private float value;

	private RubricType type;

	private int classification;

	private int code;

	private String name;

	public Rubric() {
		children = new ArrayList<Rubric>();
	}
	
	public float CalcResult() {
		if (children.size() > 0) {
			float componentValue = 0;
			for (Rubric rubric : children) {
				float sum = 0;
				RubricType type= rubric.getType();
				switch(type) {
				case Debit: sum -= rubric.CalcResult();
					break;
				case Credit: sum += rubric.CalcResult();
					break;
				default:
					break;
				}				
				componentValue += sum;
			}
			return componentValue;
		}
		else return value;
	}

	public void addChildren(Rubric rubric) {
		children.add(rubric);
	}

	public Rubric[] getChildren() {
		return (Rubric[])children.toArray();
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public RubricType getType() {
		return type;
	}

	public void setType(RubricType type) {
		this.type = type;
	}

	public int getClassification() {
		return classification;
	}

	public void setClassification(int classification) {
		this.classification = classification;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Rubric clone() {
		Rubric rubric = new Rubric();
		
		rubric.setClassification(classification);
		rubric.setCode(code);
		rubric.setName(name);
		rubric.setType(type);
		rubric.setValue(value);
		
		return rubric;
	}
}
