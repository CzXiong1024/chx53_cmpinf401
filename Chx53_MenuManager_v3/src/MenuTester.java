import java.util.ArrayList;

/**
 * Class MenuTester Self_Customized tester for Assignment 3, INFSCI 0401,
 * 2022Fall
 * 
 * @author: Chengzhuo Xiong
 * @created: 10/23/2022
 * @modified: 11/09/2022
 */

public class MenuTester {

	public static void main(String[] args) throws Exception {
		MenuManager manager = new MenuManager("data/dishes.txt");
		ArrayList<Menu> menus = new ArrayList<>();
		for (int i = 1; i <= 8; i++) {
			Menu myMenu = manager.randomMenu("Random Menu No. " + i);
			System.out.println(myMenu.toString() + myMenu.description() + "Total calories: " + myMenu.totalCalories()
					+ "\nTotal price: " + myMenu.totalPrice());
			menus.add(myMenu);
		}
		Menu minCalMenu = manager.minCaloriesMenu("Menu with Minimum Calories");
		Menu maxCalMenu = manager.maxCaloriesMenu("Menu with Maximum Calories");
		System.out.println(minCalMenu.toString() + minCalMenu.description() + "Total calories: "
				+ minCalMenu.totalCalories() + "\nTotal price: " + minCalMenu.totalPrice());
		System.out.println(maxCalMenu.toString() + maxCalMenu.description() + "Total calories: "
				+ maxCalMenu.totalCalories() + "\nTotal price: " + maxCalMenu.totalPrice());
		menus.add(minCalMenu);
		menus.add(maxCalMenu);
		FileManager.writeMenu("data/menus.txt", menus);
	}

}
