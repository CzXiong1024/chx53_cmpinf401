package chx53_Assignment1;

import javax.swing.JOptionPane;

public class DecomposingMoney {
	public static void main(String[] args) {
		int x = Integer.parseInt(JOptionPane.showInputDialog("Please enter an Integer representing an amount of money from 1 dollar to 9999 dollars:"));
		int grands = x/1000;
		int benjamins = (x / 100) % 10;
		int sawbucks = (x / 10) % 10;
		int bucks = x % 10;
		if (x>=1 && x<10) {
			JOptionPane.showMessageDialog(null, "The amount you entered is equal to :\n" + "$ " +bucks+" bucks");
		}else if (x>=10 && x<100) {
			JOptionPane.showMessageDialog(null, "The amount you entered is equal to :\n" + "$ " +sawbucks+" sawbucks\n"+"$ " +bucks+" bucks");
		}else if (x>=100 && x<1000) {
			JOptionPane.showMessageDialog(null, "The amount you entered is equal to :\n" + "$ " +benjamins+" Benjamins\n"+"$ " +sawbucks+" sawbucks\n"+"$ " +bucks+" bucks");
		}else if (x>=1000 && x<10000) {
			JOptionPane.showMessageDialog(null, "The amount you entered is equal to :\n" + "$ " +grands+" grands\n"+"$ " +benjamins+" Benjamins\n"+"$ " +sawbucks +" sawbucks\n"+"$ " +bucks+" bucks");
		}
	}
}
