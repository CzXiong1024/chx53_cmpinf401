//Chengzhuo Xiong wrote this program on Sep19, 2022.

import javax.swing.JOptionPane;

public class Lab4 {

	public static void main(String[] args) {
		boolean flag = true;
		while(flag) {
			String inputX = JOptionPane.showInputDialog("Please enter integer number X as the log(X>0):\n" 
					+ "ps:enter 'exit' to exit the program");
			if(inputX.equalsIgnoreCase("exit")) {
				flag = false;
				continue;
			}
			String inputB = JOptionPane.showInputDialog("Please enter integer number b as the base(b>1):\n" 
					+ "ps:enter 'exit' to exit the program");
			if(inputB.equalsIgnoreCase("exit")) {
				flag = false;
				continue;
			}
			if(!checkInteger(inputX)||!checkInteger(inputB)){
				JOptionPane.showMessageDialog(null, "Wrong format or range!!\nPlease re-enter the correct positive interger numbers");
				continue;
			}
			int x = Integer.valueOf(inputX);
			int b = Integer.valueOf(inputB);
			if(!checkXandBRange(x,b)) {
				JOptionPane.showMessageDialog(null, "Wrong range!!\nPlease re-enter the correct positive interger numbers.\n"
						+ "Notice that x must greater than 0 and b must greater than 1!!");
				continue;
			}else {
				int result = floorLog(x,b);
				JOptionPane.showMessageDialog(null, "The result Y = Log("+inputX+")(base:"+inputB+") is:\n"+"Y = " + result);
				String nextInput = JOptionPane.showInputDialog("Do you wish another logarithm calculation? "
						+ "Type 'yes' to do another one.\n"
						+ "Otherwise the program is going to exit!");
				if(nextInput.equalsIgnoreCase("yes")) {
					continue;
				}else {
					flag = false;
				}
			}
		}
		
		
	}
	
	public static int floorLog(int x,int b) {
		
		int count = 0;
		while(x >= b) {
			x /= b;
			count ++;
		}
		
		return count;
	}
	
	public static boolean checkInteger(String in) {
		char[] inChar = in.toCharArray();
		for(char i : inChar) {
			int num = (int) i ;
			if(num<48||num>57) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkXandBRange(int x, int b) {
		if(x>0&&b>1) {
			return true;
		}
		return false;
	}
}
