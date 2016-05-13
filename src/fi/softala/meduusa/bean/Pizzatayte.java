package fi.softala.meduusa.bean;

public class Pizzatayte {
	
	
	String pizzaid;
	String tayteid;
	
	public Pizzatayte() {
		
	}
	
	public Pizzatayte(String pizzaid, String tayteid) {
		
		this.pizzaid = pizzaid;
		this.tayteid = tayteid;
	}

	public String getPizzaid() {
		return pizzaid;
	}

	public void setPizzaid(String pizzaid) {
		this.pizzaid = pizzaid;
	}

	public String getTayteid() {
		return tayteid;
	}

	public void setTayteid(String tayteid) {
		this.tayteid = tayteid;
	}
	
	@Override
	public String toString() {
		return "Pizzatayte [pizzaid=" + pizzaid + ", tayteid=" + tayteid + "]";
	}
	
	public Object hv() {
		return null;
	}
	
	

}
