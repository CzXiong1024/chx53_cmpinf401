import java.util.Random;

import javax.swing.JOptionPane;

public class Lab7 {

	public static void main(String[] args) {
		String num = "";
		while(true) {
			num = JOptionPane.showInputDialog("Please type a number (Positive Integer) indicating the size of an array:");
			if(!checkPositiveInteger(num)) {
				JOptionPane.showMessageDialog(null, "Wrong input type, please re-enter a positive integer!");
				continue;
			}
			int n = Integer.valueOf(num);
			double[] data = new double[n];
			Random r = new Random();
			String s = "[";
			for(int i = 0; i < n; i++) {
				data[i] = r.nextDouble(-100.00,100.01);
				if(i==n-1) {
					s +=data[i]+"]";
				}else {
					s += data[i]+", ";
				}
			}
			double max = max(data);
			double min = min(data);
			double sum = sum(data);
			double avg = avg(data);
			JOptionPane.showMessageDialog(null, "The newly generated array with a size of "+n+" is:\n"+s
					+"\nThe maximum value of this array is:\n"+max+"\nThe minimum value of this array is:\n"+min+
					"\nThe sum value of this array is:\n"+sum+"\nThe average value of this array is:\n"+avg);
			String next = JOptionPane.showInputDialog(null, "Do you wish another round? \nEnter 'Y' to run another round. \nEnter anything else to end the program.");
			if(!next.equalsIgnoreCase("y")) {
				break;
			}
			
		}
	}
	
	public static double max(double[] data) {
		double max = data[0];
		for(int i=0;i<data.length;i++) {
			max = data[i]>max? data[i]:max;
		}
		return max;
	}
	
	public static double min(double[] data) {
		double min = data[0];
		for(int i=0;i<data.length;i++) {
			min = data[i]<min? data[i]:min;
		}
		return min;
	}

	public static double sum(double[] data) {
		double sum = 0.00;
		for(int i=0;i<data.length;i++) {
			sum += data[i];
		}
		return sum;
	}
	
	public static double avg(double[] data) {
		double avg = sum(data)/data.length;
		return avg;
	}
	
	public static boolean checkPositiveInteger(String in) {
		char[] inChar = in.toCharArray();
		for(char i : inChar) {
			int num = (int) i ;
			if(num<48||num>57) {
				return false;
			}
		}
		return true;
	}

}
