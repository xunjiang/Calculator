package xun.jiang.simcal.data;

public class Operator {
	//if priority is 0 is high , if it is 1, is low
	private int priority;
	private String operator;

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
