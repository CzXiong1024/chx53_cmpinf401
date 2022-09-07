package lab2;

import javax.swing.JOptionPane;

public class Lab2_Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Please input two numbers corresponding to the sides of the triangle \n ps:type them one by one:";
		JOptionPane.showMessageDialog(null,input);
		double a = Double.parseDouble(JOptionPane.showInputDialog("a ="));
		double b = Double.parseDouble(JOptionPane.showInputDialog("b ="));
		double pSum = Math.pow(a, 2)+Math.pow(b,2);
		double c = Math.sqrt(pSum);
		String res = String.format("%.2f", c);
		JOptionPane.showMessageDialog(null, "The hypotenuse is "+ res);
	}

}
