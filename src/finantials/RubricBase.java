package finantials;

public class RubricBase {

	protected int classification;

	protected int code;

	protected String name;
	
	protected int getClassification() {
		return this.classification;
	}
	
	protected void setClassification(int classification) {
		this.classification = classification;
	}
	
	protected int getCode() {
		return this.code;
	}
	
	protected void setCode(int code) {
		this.code = code;
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
}
