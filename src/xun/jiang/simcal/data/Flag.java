package xun.jiang.simcal.data;

public class Flag {
	public boolean zeros_infront;
	public boolean cons_operator; 
	public boolean divid_byzero; 
	public boolean opt_ends;
	public boolean opt_stars;
	public boolean operator_on;
	public boolean num_on;
	public boolean dot_on;
	public boolean equal_on;
	private static Flag instance;
	public static Flag getInstance(){
		if(instance == null){
			instance = new Flag();
		}
		return instance;
	}
	
}
