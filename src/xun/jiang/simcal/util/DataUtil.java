package xun.jiang.simcal.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import xun.jiang.simcal.data.Const;
import xun.jiang.simcal.data.NumberList;
import xun.jiang.simcal.data.Operator;
import xun.jiang.simcal.data.OperatorList;

public class DataUtil {
	private static NumberList numlist = new NumberList();
	private static OperatorList optlist = new OperatorList();

	public String Calculation(String s) {
		String result = null;
//		numlist = null;
//		optlist = null;
		if((s.substring(0, 1)).equals("-")){
			String numLists[] = s.split("([+X/()#])");
			numlist.pushNumber(numLists);
			String optList[] = s.split("([0-9.-]+)");
			optlist.pushOperator(optList);
		}else{
			String numLists[] = s.split("([-+X/()#])");
			numlist.pushNumber(numLists);
			String optList[] = s.split("([0-9.]+)");
			optlist.pushOperator(optList);
		}
		
		// Here the regex is not fully functional, always have one empty
		// character in the front.
		if (numlist.getSize() == (optlist.getSize() + 1)) {
			/***
			 * How to design the for loop that first time it will pop two
			 * operator and after that every time it will pop out one
			 */
			if( optlist.getSize() == 0 && numlist.getSize() ==1 ){
				numlist.popNumber();
			}
			while (optlist.getSize() > 0) {
				ArrayList<Operator> optTmp = new ArrayList<Operator>();
				ArrayList<Double> numTmp = new ArrayList<Double>();
				//int size_of_optlist = optlist.getSize();
				optTmp.add(Const.FIRST, optlist.popOperator());
				numTmp.add(Const.FIRST, numlist.popNumber());
				numTmp.add(Const.SECOND, numlist.popNumber());
				if (optlist.getSize() != 0) {
					optTmp.add(Const.SECOND, optlist.popOperator());
					if (optTmp.get(Const.FIRST).getPriority() == Const.LOW
							&& optTmp.get(Const.SECOND).getPriority() == Const.HIGH) {
						numTmp.add(Const.THRID, numlist.popNumber());
						numlist.pushNumber(symbolCal(numTmp.get(Const.SECOND),
								numTmp.get(Const.THRID),
								optTmp.get(Const.SECOND).getOperator()));
						numlist.pushNumber(numTmp.get(Const.FIRST));
						optlist.pushOperator(optTmp.get(Const.FIRST));
					} else {
						numlist.pushNumber(symbolCal(numTmp.get(Const.FIRST),
								numTmp.get(Const.SECOND),
								optTmp.get(Const.FIRST).getOperator()));
						optlist.pushOperator(optTmp.get(Const.SECOND));

					}
				} else {
					result = ""
							+ symbolCal(numTmp.get(Const.FIRST),
									numTmp.get(Const.SECOND),
									optTmp.get(Const.FIRST).getOperator());
				}

			}
		} else {
			result = "Dear, this is not working...";
		}
		return result;
	}

	private double symbolCal(double num1, double num2, String op) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("+", 0);
		map.put("-", 1);
		map.put("X", 2);
		map.put("/", 3);
		double result = 0;
		switch (map.get(op)) {
		case 0:
			result = num1 + num2;
			break;
		case 1:
			result = num1 - num2;
			break;
		case 2:
			result = num1 * num2;
			break;
		case 3:
			result = num1 / num2;
			break;
		default:
			/***
			 * Think a better way to handle this, we have to detect this is
			 * operator is not been considered Date: Feb 18, 2013 Author: Xun
			 * Jiang
			 */
			result = 0;
			break;
		}
		return result;
	}
}
