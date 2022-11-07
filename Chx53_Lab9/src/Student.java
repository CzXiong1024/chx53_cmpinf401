
public class Student extends Person{
	private String program;
	private int year;
	private double fee;
	
	public Student(String name, String address, String program, int year, double fee) {
		super();
		this.setName(name);
		this.setAddress(address);
		this.program = program;
		this.year = year;
		this.fee = fee;
	}

	/**
	 * @return the program
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * @param program the program to set
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the fee
	 */
	public double getFee() {
		return fee;
	}

	/**
	 * @param fee the fee to set
	 */
	public void setFee(double fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		String s = "Student Name: "+this.getName()+"\n"+"Student Address:"+this.getAddress()+"\n"
				+"Student Program:"+this.getProgram()+"\n"+"Year:"+this.getYear()+"\n"+"Fee:"+this.getFee()+"\n";
		return s;
	}
	
}
