import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JOptionPane;

//Chengzhuo Xiong wrote this program on Sep25, 2022.

public class Lab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		while(true) {
			String input = JOptionPane.showInputDialog("Please enter a positive Integer n to indicate "
					+ "the number of times \nyou want to roll the two dices:\nn=:");
			if(!checkPositiveInteger(input)||input==null||input.equals("")) {
				JOptionPane.showMessageDialog(null, "Wrong format or not a positve integer, please re-enter!");
				continue;
			}
			int n = Integer.valueOf(input);
			if(n==0) {
				JOptionPane.showMessageDialog(null, "please enter an interger greater than 0!");
				continue;
			}
			rollDice(n,r);
			String ask = JOptionPane.showInputDialog("Do you wish another round of roll?\n"
					+ "Enter 'yes' or '1' to restart, enter any other to exit!");
			if(!ask.equalsIgnoreCase("yes")&&!ask.equals("1")||ask==null||ask.equals("")) {
				System.out.print("ByeBye~~!");
				break;
			}
		}

	}
	
	static void rollDice(int n, Random r) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			int d1 = r.nextInt(1,7);
			int d2 = r.nextInt(1,7);
			int sum = d1 + d2;
			if(map.containsKey(sum)) {
				map.put(sum, map.get(sum)+1);
			}else {
				map.put(sum, 1);
			}
		}
		String output1 = String.format("The result of n = "+n+" times of rolling two dices:\n %-8s%-18s%-13s%-19s%n"
				,"Value","NumberOfTimes","Fraction","ExpectedFraction");
		String output2 = "";
		for(int i = 2; i<13 ; i++) {
			if(map.containsKey(i)) {
				double f = (double)map.get(i)/n;
				double ef = 0.0;
				if(i<=7) {
					ef = (i-1.0)/36.0;
				}else {
					ef = (13.0-i)/36.0;
				}
				String add = String.format("    %-17d%-21d%-20.3f%-19.3f%n", i,map.get(i),f,ef);
				output2 += add;
			}
		}
		String output3 = String.format("The result of n = "+n+" times of rolling two dices:\n  %-17s%-22s%-16s%-19s%n"
				,"Value","NumberOfTimes","Fraction","ExpectedFraction");
		System.out.print(output3+output2+"\n");
		JOptionPane.showMessageDialog(null, output1+output2);
	}
	
	static boolean checkPositiveInteger(String in) {
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
