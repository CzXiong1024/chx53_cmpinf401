import javax.swing.JOptionPane;

public class unitConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = true;
		String input = null;
		String output = null;
		while(flag) {
			input = JOptionPane.showInputDialog("This is a unit converter(enter \"-1\" to exit)\nThe content format should be like: number+\" \"+a unit of measurement!\nPlease type in what you want to convert:");
			if(input.equals("-1")) {
				System.exit(0);
			}
			int s = input.indexOf(" ");
			if (s == -1) {
				JOptionPane.showMessageDialog(null, "the content or format you entered is incorrect, please re-enter!");
			}else {
				double num = Double.valueOf(input.substring(0, s));
				String unit = input.substring(s+1, input.length());
				if (unit.equalsIgnoreCase("cm")||unit.equalsIgnoreCase("in")||unit.equalsIgnoreCase("yd")||unit.equalsIgnoreCase("m")) {
					output = lenthUnitConvertion(num,unit);
					flag = false;
				}else if (unit.equalsIgnoreCase("oz")||unit.equalsIgnoreCase("gm")||unit.equalsIgnoreCase("kg")||unit.equalsIgnoreCase("lb")||unit.equalsIgnoreCase("g")) {
					output = massUnitConvertion(num,unit);
					flag = false;
				}else {
					JOptionPane.showMessageDialog(null, "the content or format you entered is incorrect, please re-enter!");
				}	
			}
		}
		JOptionPane.showMessageDialog(null, input+" = "+ output);
	}

	private static String massUnitConvertion(double num,String unit) {
		// TODO Auto-generated method stub
		String output = null;
		if (unit.equalsIgnoreCase("oz")) {
			output = String.format("%.4f", 28.3495*num) + " gm";
		}else if (unit.equalsIgnoreCase("gm")||unit.equalsIgnoreCase("g")) {
			output = String.format("%.4f", 0.03527396*num) + " oz";
		}else if (unit.equalsIgnoreCase("kg")) {
			output = String.format("%.4f", 2.20462262*num) + " lb";
		}else if (unit.equalsIgnoreCase("lb")) {
			output = String.format("%.4f", 0.453*num) + " kg";
		}
		
		return output;
	}

	private static String lenthUnitConvertion(double num,String unit) {
		// TODO Auto-generated method stub
		String output = null;
		if (unit.equalsIgnoreCase("cm")) {
			output = String.format("%.4f", 0.3937*num) + " in";
		}else if (unit.equalsIgnoreCase("in")) {
			output = String.format("%.4f", 2.54*num) + " cm";
		}else if (unit.equalsIgnoreCase("yd")) {
			output = String.format("%.4f", 0.9144*num) + " m";
		}else if (unit.equalsIgnoreCase("m")) {
			output = String.format("%.4f", 1.094*num) + " yd";
		}
		return output;
	}

}
