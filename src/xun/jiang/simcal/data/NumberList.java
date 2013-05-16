package xun.jiang.simcal.data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public  class NumberList {
	private static Stack<Double> numberlist = new Stack<Double>();
	private static double number;
	
	
	public Stack<Double> pushNumber(String[] s) {
		
		for(int i =  s.length - 1; i >= 0  ; i--){
			/***
			 * Actually later might need double check whether the string passed here will be number
			 * author: Xun Jiang
			 */
			String sub = s[i].substring(0, 1);
			if( sub.equals(Const.DOT) ){
				//if user start the first letter as dot, then append 0 in front; 
				s[i] = "0" + s[i]; 
			}
			number = Double.parseDouble(s[i]);
			numberlist.push(number);
		}
		return numberlist;
	}

	public Stack<Double> pushNumber(double s) {
			number = s;
			numberlist.push(number);
		return numberlist;
	}
	public Double popNumber() {
		double number = (Double)numberlist.pop();
		return number;
	}

	public int getSize() {
		return numberlist.size();
	}

}
