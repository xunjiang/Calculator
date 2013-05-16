package xun.jiang.simcal.util;

public class Util {
	FlagUtil flagutil = new FlagUtil();
	DataUtil datautil = new DataUtil();

	public String handleNum(String original, String s) {
		/***
		 * Here is the problem come from, after equal, the first letter can not
		 * been shown (Solved)
		 */
		if (flagutil.equStatus()) {
			original = s;
			flagutil.chkEquOn(original, s);
		} else {
			if (flagutil.chkNumOn(s)) {
				// if(original.length() != 0){
				// if(flagutil.chk0frnt(original, s)){
				// s = "";
				// }
				// if(flagutil.chkdiv0(original, s)){
				// s = "";
				// original = "Number can not been divided by zero";
				// }
				// }
				if (flagutil.chk0frnt(original, s)) {
					original = original.substring(0, original.length() - 1);
				}
				original = original + s;
			}

		}
		return original;
	}

	public String handleOperator(String original, String s) {
		flagutil.chkEquOn(original, s);
		if ( flagutil.chkNgoptFirst(original, s) ) {
			original = original + s;
		} else {
			if (flagutil.chkoptstr(original, s)) {
				s = "";
			} else if (flagutil.chkopt(s)) {
				if (flagutil.chkoptcons(original, s)) {
					original = original.substring(0, original.length() - 1);

				}
				original = original + s;
			}

		}
		return original;
	}

	public String handleDot(String original, String s) {

		if (!flagutil.chkdotStatus(s)) {
			original = original + s;
		}
		flagutil.chkdot_on(s);
		return original;
	}

	public void handleLClear() {
		flagutil.initalFlag();
	}

	public String handleCancel(String original) {
		if (original.length() > 0) {
			flagutil.chkCancldot(original);
			original = original.substring(0, original.length() - 1);
		}
		return original;
	}

	public String handleZero(String original, String s) {
		if (flagutil.equStatus()) {
			original = s;
			flagutil.chkEquOn(original, s);
		} else {
			if (flagutil.chk0frnt(original, s)) {
				s = "";

			}
			original = original + s;
		}
		return original;
	}

	public String handleEqual(String original, String s) {
		flagutil.chkEquOn(original, s);
		if (flagutil.chkOptend(original)) {
			original = original.substring(0, original.length() - 1);
		}
		// sflagutil.initalFlag();
		return datautil.Calculation(original);
	}

}
