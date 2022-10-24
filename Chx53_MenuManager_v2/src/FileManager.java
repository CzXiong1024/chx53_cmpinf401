/**
 * Class FileManager
 * @author: Chengzhuo Xiong
 * @created: 10/23/2022
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager {
	
	/**
	 * Method readEntrees
	 * @param fileName: the file name that refers to a file in which consists of information of entrees.
	 * @return an ArrayList containing a set of entrees read from the file
	 * @throws Exception
	 */
	public static ArrayList<Entree> readEntrees(String fileName) throws Exception {
		ArrayList<Entree> enArr = new ArrayList();
		FileReader fr = new FileReader(fileName);
		BufferedReader bf = new BufferedReader(fr);
		String line = null;
		while((line = bf.readLine()) != null) {
			Entree en = new Entree();
			String[] box = line.split("@@");
			en.setName(box[0]);
			en.setDescription(box[1]);
			en.setCalories(Integer.parseInt(box[2]));
			enArr.add(en);
		}
		bf.close();
		fr.close();
		return enArr;
	}
	/**
	 * Method read Sides
	 * @param fileName: the file name that refers to a file in which consists of information of sides.
	 * @return an ArrayList containing a set of sides read from the file
	 * @throws Exception
	 */
	public static ArrayList<Side> readSides(String fileName) throws Exception {
		ArrayList<Side> sidesArr = new ArrayList();
		FileReader fr = new FileReader(fileName);
		BufferedReader bf = new BufferedReader(fr);
		String line = null;
		while((line = bf.readLine()) != null) {
			Side en = new Side();
			String[] box = line.split("@@");
			en.setName(box[0]);
			en.setDescription(box[1]);
			en.setCalories(Integer.parseInt(box[2]));
			sidesArr.add(en);
		}
		bf.close();
		fr.close();
		return sidesArr;
	}
	/**
	 * Method readSalads
	 * @param fileName: the file name that refers to a file in which consists of information of salads.
	 * @return an ArrayList containing a set of salads read from the file
	 * @throws Exception
	 */
	public static ArrayList<Salad> readSalads(String fileName) throws Exception{
		ArrayList<Salad> saladsArr = new ArrayList();
		FileReader fr = new FileReader(fileName);
		BufferedReader bf = new BufferedReader(fr);
		String line = null;
		while((line = bf.readLine()) != null) {
			Salad en = new Salad();
			String[] box = line.split("@@");
			en.setName(box[0]);
			en.setDescription(box[1]);
			en.setCalories(Integer.parseInt(box[2]));
			saladsArr.add(en);
		}
		bf.close();
		fr.close();
		return saladsArr;
	}
	/**
	 * Method readDesserts
	 * @param fileName: the file name that refers to a file in which consists of information of desserts.
	 * @return an ArrayList containing a set of desserts read from the file
	 * @throws Exception
	 */
	public static ArrayList<Dessert> readDesserts(String fileName) throws Exception{
		ArrayList<Dessert> desArr = new ArrayList();
		FileReader fr = new FileReader(fileName);
		BufferedReader bf = new BufferedReader(fr);
		String line = null;
		while((line = bf.readLine()) != null) {
			Dessert en = new Dessert();
			String[] box = line.split("@@");
			en.setName(box[0]);
			en.setDescription(box[1]);
			en.setCalories(Integer.parseInt(box[2]));
			desArr.add(en);
		}
		bf.close();
		fr.close();
		return desArr;
	}
}
