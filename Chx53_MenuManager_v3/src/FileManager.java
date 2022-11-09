
/**
 * Class FileManager
 * @author: Chengzhuo Xiong
 * @created: 10/23/2022
 * Modified: 11/09/2022
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

	/**
	 * Method readItems
	 * 
	 * @param fileName: the file name that refers to a file in which consists of
	 *                  information of Items
	 * @return an ArrayList containing a set of items read from the file
	 */
	public static ArrayList<MenuItem> readItems(String fileName) {
		ArrayList<MenuItem> itemsArr = new ArrayList();
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader bf = new BufferedReader(fr);
			String line = null;
			while ((line = bf.readLine()) != null) {
				String[] box = line.split("@@");
				if (box.length == 5) {
					String type = box[1];
					if (type.equalsIgnoreCase("entree")) {
						Entree item = new Entree();
						item.setName(box[0]);
						item.setDescription(box[2]);
						item.setCalories(Integer.parseInt(box[3]));
						item.setPrice(Double.parseDouble(box[4]));
						itemsArr.add(item);
					}
					if (type.equalsIgnoreCase("Dessert")) {
						Dessert item = new Dessert();
						item.setName(box[0]);
						item.setDescription(box[2]);
						item.setCalories(Integer.parseInt(box[3]));
						item.setPrice(Double.parseDouble(box[4]));
						itemsArr.add(item);
					}
					if (type.equalsIgnoreCase("Salad")) {
						Salad item = new Salad();
						item.setName(box[0]);
						item.setDescription(box[2]);
						item.setCalories(Integer.parseInt(box[3]));
						item.setPrice(Double.parseDouble(box[4]));
						itemsArr.add(item);
					}
					if (type.equalsIgnoreCase("Side")) {
						Side item = new Side();
						item.setName(box[0]);
						item.setDescription(box[2]);
						item.setCalories(Integer.parseInt(box[3]));
						item.setPrice(Double.parseDouble(box[4]));
						itemsArr.add(item);
					}

				} else {
					System.out.println("Data exception happened. Please check your data file");
				}

			}
			bf.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("File Reading Exception Happens!");
			e.printStackTrace();
		}

		return itemsArr;
	}

	public static void writeMenu(String fileName, ArrayList<Menu> menus) {

		try {
			File fl = new File(fileName);
			fl.delete();
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < menus.size(); i++) {
				Menu menu = menus.get(i);
				if(i == menus.size()-1) {
					String s = menu.toString();
					s += "Entree: " + menu.getEntree().toString() + menu.getEntree().getDescription() + ". Calories: "
							+ menu.getEntree().getCalories() + " Price: " + menu.getEntree().getPrice() + "\n";
					s += "Side: " + menu.getSide().toString() + menu.getSide().getDescription() + ". Calories: "
							+ menu.getSide().getCalories() + " Price: " + menu.getSide().getPrice() + "\n";
					s += "Salad: " + menu.getSalad().toString() + menu.getSalad().getDescription() + ". Calories: "
							+ menu.getSalad().getCalories() + " Price: " + menu.getSalad().getPrice() + "\n";
					s += "Dessert: " + menu.getDessert().toString() + menu.getDessert().getDescription() + ". Calories: "
							+ menu.getDessert().getCalories() + " Price: " + menu.getDessert().getPrice() + "\n";
					s += "Menu Total Calories: " + menu.totalCalories() + "\tMenu Total Price: " + menu.totalPrice();
					bw.write(s);
				}else {
					String s = menu.toString();
					s += "Entree: " + menu.getEntree().toString() + menu.getEntree().getDescription() + ". Calories: "
							+ menu.getEntree().getCalories() + " Price: " + menu.getEntree().getPrice() + "\n";
					s += "Side: " + menu.getSide().toString() + menu.getSide().getDescription() + ". Calories: "
							+ menu.getSide().getCalories() + " Price: " + menu.getSide().getPrice() + "\n";
					s += "Salad: " + menu.getSalad().toString() + menu.getSalad().getDescription() + ". Calories: "
							+ menu.getSalad().getCalories() + " Price: " + menu.getSalad().getPrice() + "\n";
					s += "Dessert: " + menu.getDessert().toString() + menu.getDessert().getDescription() + ". Calories: "
							+ menu.getDessert().getCalories() + " Price: " + menu.getDessert().getPrice() + "\n";
					s += "Menu Total Calories: " + menu.totalCalories() + "\tMenu Total Price: " + menu.totalPrice()+"\n";
					bw.write(s);
				}
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
