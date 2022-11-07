
public class Staff extends Person{
	private String school;
	private double pay;
	public Staff(String name, String address, double pay) {
		super();
		this.setName(name);
		this.setAddress(address);
		this.pay = pay;
	}
	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * @return the pay
	 */
	public double getPay() {
		return pay;
	}
	/**
	 * @param pay the pay to set
	 */
	public void setPay(double pay) {
		this.pay = pay;
	}
	@Override
	public String toString() {
		String s = "Staff Name: "+this.getName()+"\n"+"Staff Address:"+this.getAddress()+"\n"
				+"Staff School:"+this.getSchool()+"\n"+"Pay:"+this.getPay()+"\n";
		return s;
	}
	
}
