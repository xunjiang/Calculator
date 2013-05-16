package xun.jiang.simcal.data;

import java.util.Stack;

public class OperatorList {
	private static Stack<Operator> operatorlist = new Stack<Operator>();
	

	public void pushOperator(String s[]) {
		for (int i = s.length - 1; i >= 0; i--) {
			if (s[i].equals(Const.ADD) || s[i].equals(Const.MINUS)) {
				Operator op1 = new Operator();
				op1.setPriority(Const.LOW);
				op1.setOperator(s[i]);
				operatorlist.push(op1);
			} else if (s[i].equals(Const.MUL) || s[i].equals(Const.DIVIDE)) {
				Operator op = new Operator();
				op.setPriority(Const.HIGH);
				op.setOperator(s[i]);
				operatorlist.push(op);
			}
			
		}
		//return operatorlist;
	}

	public void pushOperator(Operator operator) {
		operatorlist.push(operator);
		//return operatorlist;
	}

	public Operator popOperator() {
		if(operatorlist.empty()){
			Operator wrong_op = new Operator();
			wrong_op.setOperator("unknow");
			wrong_op.setPriority(Const.LOW+2);
			return wrong_op;
		}
		Operator op = (Operator)operatorlist.pop();
		return op;
	}

	public int getSize() {
		return operatorlist.size();
	}
}
