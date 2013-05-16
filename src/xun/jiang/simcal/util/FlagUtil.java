package xun.jiang.simcal.util;

import xun.jiang.simcal.data.Flag;

public class FlagUtil {
	Flag flag = Flag.getInstance();

	public FlagUtil() {
		initalFlag();
	}

	// At the very beginning, initialize all flag to false
	public void initalFlag() {
		flag.cons_operator = false;
		flag.divid_byzero = false;
		flag.opt_ends = false;
		flag.opt_stars = false;
		flag.zeros_infront = false;
		flag.operator_on = false;
		flag.num_on = false;
		flag.dot_on = false;
		flag.equal_on = false;
	}

	// This is one have to return because it will directly effect the screen
	public boolean chk0frnt(String front, String following) {
		chkNumOn(following);
		if (flag.num_on) {
			/********************
			 * leave for regx handle every word separate by operator
			 */
			String s[] = front.split("([-+X/()#])");
			if(s.length > 0){
				if (s[s.length-1].equals("0")
						&& (Integer.parseInt(following) <= 9
						&& Integer.parseInt(following) >= 0)) {
					flag.zeros_infront = true;
				} else {
					flag.zeros_infront = false;
				}
				
			}else{
				flag.zeros_infront = false;
			}

		}
		return flag.zeros_infront;

	}

	public boolean chkOptend(String following) {
		if (chkopt(following)) {
			flag.opt_ends = true;
		}
		return flag.opt_ends;
	}

	public boolean chkoptcons(String original, String following) {
		if (flag.operator_on) {
			original = original.substring(original.length() - 1);
			if (original.equals("+") || original.equals("-")
					|| original.equals("X") || original.equals("/")) {
				if (chkopt(following)) {
					flag.cons_operator = true;
				}
			}

		}

		return flag.cons_operator;
	}

	public boolean chkoptstr(String front, String following) {
		if (front.equals("")) {
			if (chkopt(following)) {
				flag.opt_stars = true;
			}
		}
		return flag.opt_stars;
	}

	public boolean chkopt(String following) {
		if (following.equals("+") || following.equals("-")
				|| following.equals("X") || following.equals("/")) {
			flag.operator_on = true;
			flag.num_on = false;
			flag.dot_on = false;
		} else {
			flag.operator_on = false;

		}
		return flag.operator_on;
	}

	public boolean chkNgoptFirst(String following, String s){
		if( following.equals("") && s.equals("-") ){
			return true;
		}else{
			return false;
			
		}
	}
	
	public boolean chkdiv0(String front, String following) {
		front = front.substring(front.length() - 1);
		if (front.equals("/") && following.equals("0")) {
			flag.divid_byzero = true;
		}
		return flag.divid_byzero;
	}

	public boolean chkNumOn(String following) {
		if (Integer.parseInt(following) <= 9
				&& Integer.parseInt(following) >= 0) {
			flag.num_on = true;
			flag.operator_on = false;
			flag.cons_operator = false;
			
			
		}
		return flag.num_on;
	}

	public boolean chkdot_on(String following) {
		if(following.equals(".")){
			flag.dot_on = true;				
		}
		//if(flag.dot_on){
			
			
		//}
		return flag.dot_on;
	}
	
	public boolean chkdotStatus(String following){
		
		return flag.dot_on;
	}
	
	public boolean chkCancldot(String following){
		
			following = following.substring(following.length() - 1);
			if(following.equals(".")){
				flag.dot_on = false;
			}
			
		return flag.dot_on;
	}
	
	public boolean chkEquOn(String following, String s){
		if(s.equals("=")){
			flag.num_on = true;
			flag.operator_on = false;
			flag.cons_operator = false;
			flag.dot_on = true;
			flag.zeros_infront = true;
			return flag.equal_on = true;
		}else{
			return flag.equal_on = false;
			
		}
	}
	
	public boolean equStatus(){
		return flag.equal_on;
	}
	
	
}
