/**
 * Class MenuRandomize
 * @author: Chengzhuo Xiong
 * @created: 10/23/2022
 */

import java.util.ArrayList;
import java.util.Random;

public class MenuRandomize {
	private ArrayList<Entree> entrees;
	private ArrayList<Side> sides;
	private ArrayList<Salad> salads;
	private ArrayList<Dessert> desserts;
	
	/**
	 * Constructor MenuRandomize: Instantiate an object containing ArrayLists of entrees, sides, salads and desserts read from files respectively.
	 * @param entreeFile: the file name that refers to a file in which consists of information of entrees.
	 * @param sideFile: the file name that refers to a file in which consists of information of sides.
	 * @param saladFile: the file name that refers to a file in which consists of information of salads.
	 * @param dessertFile: the file name that refers to a file in which consists of information of desserts.
	 * @throws Exception
	 */
	public MenuRandomize(String entreeFile, String sideFile, String saladFile, String dessertFile) throws Exception {
		entrees = FileManager.readEntrees(entreeFile);
		sides = FileManager.readSides(sideFile);
		salads = FileManager.readSalads(saladFile);
		desserts = FileManager.readDesserts(dessertFile);
	}
	
	/**
	 * Method randomMenu
	 * @return a Menu object consisting of a set of random entree, side, salad and desserts from the files.
	 */
	public Menu randomMenu() {
		Random r = new Random();
		Menu menu = new Menu("A Random Menu",entrees.get(r.nextInt(0,5)),
				sides.get(r.nextInt(0,5)),salads.get(r.nextInt(0,5)),desserts.get(r.nextInt(0,5)));
		return menu;
	}
}
