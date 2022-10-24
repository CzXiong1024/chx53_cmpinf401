/**
 * Class Menu
 * @author Chengzhuo Xiong
 * created:09/29/2022
 */
public class Menu {
	private String name;
	private Entree entree;
	private Salad salad;
	private Side side;
	private Dessert dessert;
	
	public Menu(String name) {
		this.name = name;
	}
	
	public Menu(String name, Entree entree, Side side) {
		this.name = name;
		this.entree = entree;
		this.side = side;
	}
	
	public Menu(String name, Entree entree, Side side, Salad salad, Dessert dessert) {
		this.name = name;
		this.entree = entree;
		this.side = side;
		this.salad = salad;
		this.dessert = dessert;
	}
	
	public int totalCalories() {
		int res = 0;
		int calEn = this.entree == null? 0:this.entree.getCalories();
		int calSide = this.side == null? 0:this.side.getCalories();
		int calSalad = this.salad == null? 0:this.salad.getCalories();
		int calDessert = this.dessert == null? 0:this.dessert.getCalories();
		res = calEn+calSide+calSalad+calDessert;
		return res;
	}
	
	public String description() {
		String desEntree = this.entree==null? "Entree:N/A\n":"Entree: "+this.entree.getName()+". "+this.entree.getDescription()+"\n";
		String desSide = this.side==null? "Side:N/A\n":"Side: "+this.side.getName()+". "+this.side.getDescription()+"\n";
		String desSalad = this.salad==null? "Salad:N/A\n":"Salad: "+this.salad.getName()+". "+this.salad.getDescription()+"\n";
		String desDessert = this.dessert==null? "Dessert:N/A\n":"Dessert: "+this.dessert.getName()+". "+this.dessert.getDescription()+"\n";
		String des=desEntree+desSide+desSalad+desDessert;
		return des;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Entree getEntree() {
		return entree;
	}
	public void setEntree(Entree entree) {
		this.entree = entree;
	}
	public Salad getSalad() {
		return salad;
	}
	public void setSalad(Salad salad) {
		this.salad = salad;
	}
	public Side getSide() {
		return side;
	}
	public void setSide(Side side) {
		this.side = side;
	}
	public Dessert getDessert() {
		return dessert;
	}
	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}
	
	public String toString() {
		String s = "======================"+this.name+"========================\n";
		s += "Total Calories:"+this.totalCalories()+"\n";
		s += this.description();
		return s;
	}
	

}
