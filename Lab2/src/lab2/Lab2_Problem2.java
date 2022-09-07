package lab2;

import javax.swing.JOptionPane;
public class Lab2_Problem2 {
	public static void main(String[] args) {
		final double PI = 3.1415926;
		double r = Double.parseDouble(JOptionPane.showInputDialog("Please enter the radius of a circle "));
		double area = PI*r*r;
		String a = String.format("%.2f",area);
		double perimeter = 2*PI*r;
		String p = String.format("%.2f",perimeter);
		JOptionPane.showMessageDialog(null,"The circle with radius "+r+" has an area of "+a+" and a perimeter of "+p+".");
	}
}
