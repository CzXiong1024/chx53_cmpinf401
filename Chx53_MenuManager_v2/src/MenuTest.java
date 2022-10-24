/**
 * Class MenuTest
 * @author Chengzhuo Xiong
 * created:09/29/2022
 */
import javax.swing.JOptionPane;

public class MenuTest {

	public static void main(String[] args) {
		
		Entree e1 = new Entree("Sirloin Steak","A delicious piece of 1/2 "
				+ "a pound of our carefully selected meat grilled and seasoned.",200);
		Entree e2 = new Entree("Spring Rolls","A wonderful Chinese starter made by meat rolled with starch.",150);
		Side side1 = new Side("Rice and Avocado","Premium quality indian rice mixed with avacado.",88);
		Salad salad1 = new Salad("Butter Lettuce","Lettuce with butter, very delicious!",60);
		Salad salad2 = new Salad("Purple Cabbage","Cabbage!Color is Purple!Children will love it!",90);
		Dessert d1 = new Dessert("Wonderful Dessert","A Dish with many sweet cakes!You will not regret this!",350);
		
		Menu m1 = new Menu("King's Script");
		m1.setEntree(e1);
		m1.setSalad(salad1);
		Menu m2 = new Menu("Great Britain",e2,side1,salad2,d1);
		
		System.out.print(m1);
		System.out.print(m2);
		JOptionPane.showMessageDialog(null, m1);
		JOptionPane.showMessageDialog(null, m2);
		
	}

}
