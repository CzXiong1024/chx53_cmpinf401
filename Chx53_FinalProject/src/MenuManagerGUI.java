import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Class MenuManagerGUI is able to generate a window for creating menus
 * @author Chengzhuo Xiong
 * @created 11/17/2022
 */
public class MenuManagerGUI {

	private MenuManager menuManager;
	private JFrame mainWindow, childWindow;
	private JPanel pnlMain,pnlBUOM,pnlGAM,pnlCreatedMenus,pnlChild;
	private JLabel lblEntree, lblSide, lblSalad, lblDessert, lblCreatedMenus, lblChildEntree, lblChildSide,
	lblChildSalad, lblChildDessert, lblTotalCalories, lblTotalPrice;
	private JComboBox cboEntree, cboSide, cboSalad, cboDessert;
	private JButton btnCreateMenu, btnGenerateRandom, btnGenerateMin, btnGenerateMax, btnDetails, btnDeleteAll, btnSave;
	private JTextField txtTCalories,txtTPrice;
	private JTextArea txtEntree,txtSide,txtSalad,txtDessert;
	private JList<String> menuList;
	private ArrayList<Menu> menus = new ArrayList<Menu>();
	private DefaultListModel<String> menuModel = new DefaultListModel<>();

	public static void main(String[] args) {
		MenuManagerGUI gui = new MenuManagerGUI();
	}
	/**
	 * The constructor to initialize the main window of the application
	 */
	public MenuManagerGUI() {
		this.menuManager = new MenuManager("data/dishes.txt");
		buildMainWindow();
	}

	/**
	 * Method buildmainWindow is used to generate the main window in the constructor
	 */
	private void buildMainWindow() {
		this.mainWindow = new JFrame("Menu Manager");
		mainWindow.setBounds(500, 300, 800, 520);
		//set the close operation, when the user close the window, the system is going to exit too.
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainWindow.setLayout(null);

		//create the components for the panel of 'Build your own Menu'
		//Labels generated here
		this.lblEntree = new JLabel("Entree");
		lblEntree.setBounds(60,35,60,30);
		this.lblSide = new JLabel("Side");
		lblSide.setBounds(lblEntree.getX(),lblEntree.getY()+lblEntree.getHeight()+10,lblEntree.getWidth(),lblEntree.getHeight());
		this.lblSalad = new JLabel("Salad");
		lblSalad.setBounds(lblEntree.getX(),lblEntree.getY()+lblEntree.getHeight()*2+20,lblEntree.getWidth(),lblEntree.getHeight());
		this.lblDessert = new JLabel("Dessert");
		lblDessert.setBounds(lblEntree.getX(),lblEntree.getY()+lblEntree.getHeight()*3+30,lblEntree.getWidth(),lblEntree.getHeight());

		//combo box generated here
		this.cboEntree = new JComboBox(menuManager.getEntrees().toArray());
		cboEntree.setBounds(lblEntree.getX()+lblEntree.getWidth()+10,lblEntree.getY(),200,30);
		this.cboSide = new JComboBox(menuManager.getSides().toArray());
		cboSide.setBounds(lblSide.getX()+lblSide.getWidth()+10,lblSide.getY(),cboEntree.getWidth(),cboEntree.getHeight());
		this.cboSalad = new JComboBox(menuManager.getSalads().toArray());
		cboSalad.setBounds(lblSalad.getX()+lblSalad.getWidth()+10,lblSalad.getY(),cboEntree.getWidth(),cboEntree.getHeight());
		this.cboDessert = new JComboBox(menuManager.getDesserts().toArray());
		cboDessert.setBounds(lblDessert.getX()+lblDessert.getWidth()+10,lblDessert.getY(),cboEntree.getWidth(),cboEntree.getHeight());


		//button of "Create Menu with these dishes" inside "Build your own Menu"
		this.btnCreateMenu = new JButton("Create Menu with these dishes");
		btnCreateMenu.setBounds(lblDessert.getX()-10,lblDessert.getY()+50,cboEntree.getWidth()+90,cboEntree.getHeight()+5);

		//create the panel of 'Build your own Menu' and add all the components onto it.
		this.pnlBUOM = new JPanel();
		//this.pnlBUOM.setPreferredSize(new Dimension(400,300));
		this.pnlBUOM.setLayout(null);
		this.pnlBUOM.setBorder(BorderFactory.createTitledBorder("Build your own Menu"));
		this.pnlBUOM.setBounds(10, 10, mainWindow.getWidth()/2-10, mainWindow.getHeight()/2);
		this.pnlBUOM.add(lblEntree);
		this.pnlBUOM.add(lblSide);
		this.pnlBUOM.add(lblSalad);
		this.pnlBUOM.add(lblDessert);
		this.pnlBUOM.add(cboEntree);
		this.pnlBUOM.add(cboSide);
		this.pnlBUOM.add(cboSalad);
		this.pnlBUOM.add(cboDessert);
		this.pnlBUOM.add(btnCreateMenu);

		//create the buttons for the panel of "Or generate a Menu"
		this.btnGenerateRandom = new JButton("Generate a Random Menu");
		btnGenerateRandom.setBounds(btnCreateMenu.getX(),lblEntree.getY(),btnCreateMenu.getWidth(),btnCreateMenu.getHeight());
		this.btnGenerateMin = new JButton("Generate a Minimum Calories Menu");
		btnGenerateMin.setBounds(btnGenerateRandom.getX(),btnGenerateRandom.getY()+btnGenerateRandom.getHeight()+20,btnCreateMenu.getWidth(),btnCreateMenu.getHeight());
		this.btnGenerateMax = new JButton("Generate a maximum Calories Menu");
		btnGenerateMax.setBounds(btnGenerateRandom.getX(),btnGenerateMin.getY()+btnGenerateMin.getHeight()+20,btnCreateMenu.getWidth(),btnCreateMenu.getHeight());

		//create the panel of "Or generate a Menu" and add the above three buttons onto it
		this.pnlGAM = new JPanel();
		this.pnlGAM.setLayout(null);
		this.pnlGAM.setBorder(BorderFactory.createTitledBorder("Generate a Menu"));
		this.pnlGAM.setBounds(10, pnlBUOM.getY()+pnlBUOM.getHeight()+10, mainWindow.getWidth()/2-10, mainWindow.getHeight()/2-50);
		this.pnlGAM.add(btnGenerateRandom);
		this.pnlGAM.add(btnGenerateMin);
		this.pnlGAM.add(btnGenerateMax);

		//create the text area displaying for the "Created Menus"
		this.menuList = new JList(menuModel);
		menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		menuList.setVisibleRowCount(12);
		menuList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		menuList.setBounds(20, 30,mainWindow.getWidth()/2-50, mainWindow.getHeight()-150);


		//create the buttons for the 'details','delete all' & 'Save to file'
		this.btnDetails = new JButton("Details");
		btnDetails.setBounds(menuList.getX(),menuList.getY()+menuList.getHeight()+20,menuList.getWidth()/3-5,btnCreateMenu.getHeight());
		this.btnDeleteAll = new JButton("Delete all");
		btnDeleteAll.setBounds(btnDetails.getX()+btnDetails.getWidth()+5,btnDetails.getY(),btnDetails.getWidth(),btnDetails.getHeight());
		this.btnSave = new JButton("Save to file");
		btnSave.setBounds(btnDeleteAll.getX()+btnDeleteAll.getWidth()+5,btnDeleteAll.getY(),btnDeleteAll.getWidth(),btnDeleteAll.getHeight());

		this.pnlCreatedMenus = new JPanel();
		this.pnlCreatedMenus.setLayout(null);
		this.pnlCreatedMenus.setBorder(BorderFactory.createTitledBorder("Created Menus"));
		this.pnlCreatedMenus.setBounds(pnlBUOM.getWidth()+20, pnlBUOM.getY(), mainWindow.getWidth()/2-10, mainWindow.getHeight()-40);
		this.pnlCreatedMenus.add(menuList);
		this.pnlCreatedMenus.add(btnDetails);
		this.pnlCreatedMenus.add(btnDeleteAll);
		this.pnlCreatedMenus.add(btnSave);



		//create the main panel on the main window & add the panels into it
		this.pnlMain = new JPanel();
		this.pnlMain.setLayout(null);
		this.pnlMain.setBounds(mainWindow.getX(), mainWindow.getY(), mainWindow.getWidth(), mainWindow.getHeight());
		this.mainWindow.setContentPane(pnlMain);
		this.pnlMain.add(this.pnlBUOM);
		this.pnlMain.add(this.pnlGAM);
		this.pnlMain.add(this.pnlCreatedMenus);

		/**
		 * Add ActionListeners and ActionHandlers to the button of "Create Menu with these dishes"
		 */
		btnCreateMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ownMenuName = JOptionPane.showInputDialog("Please enter the name of your own Menu:");
				if(ownMenuName==null||ownMenuName.equals("")) {
					JOptionPane.showMessageDialog(null, "You have to name the menu before creating it!");
					return;
				}
				Entree entree = (Entree) cboEntree.getSelectedItem();
				Side side = (Side) cboSide.getSelectedItem();
				Salad salad = (Salad) cboSalad.getSelectedItem();
				Dessert dessert = (Dessert) cboDessert.getSelectedItem();
				Menu menu = new Menu(ownMenuName,entree,side,salad,dessert);
				menus.add(menu);
				menuModel.addElement(menu.getName());
				menuList.setModel(menuModel);
			}
		});

		/**
		 * Add ActionListeners and ActionHandlers to the button of "Generate a Random Menu"
		 */
		btnGenerateRandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String randomName = JOptionPane.showInputDialog("Please enter the name of the coming random menu:");
				if(randomName==null||randomName.equals("")) {
					JOptionPane.showMessageDialog(null, "You have to name the menu before creating it!");
					return;
				}
				Menu menu = menuManager.randomMenu(randomName);
				menus.add(menu);
				menuModel.addElement(menu.getName());
				menuList.setModel(menuModel);
			}
		});
		
		/**
		 * Add ActionListeners and ActionHandlers to the button of "Generate a Minimum Calories Menu"
		 */
		btnGenerateMin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu menu = menuManager.minCaloriesMenu("Minimum Calories Menu");
				menus.add(menu);
				menuModel.addElement(menu.getName());
				menuList.setModel(menuModel);
			}
		});

		/**
		 * Add ActionListeners and ActionHandlers to the button of "Generate a Maximum Calories Menu"
		 */
		btnGenerateMax.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu menu = menuManager.maxCaloriesMenu("Maximum Calories Menu");
				menus.add(menu);
				menuModel.addElement(menu.getName());
				menuList.setModel(menuModel);
			}
		});

		/**
		 * Add ActionListeners and ActionHandlers to the button of "Details"
		 */
		btnDetails.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int curIndex = menuList.getSelectedIndex();
				if(curIndex == -1) {
					JOptionPane.showMessageDialog(null, "Warning!\nYou have to select a specific menu to view its detailed information!");
					return;
				}
				Menu curMenu = menus.get(curIndex);
				generateChildWindow(curMenu);
			}
		});

		/**
		 * Add ActionListeners and ActionHandlers to the button of "Delete all"
		 */
		btnDeleteAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menus.removeAll(menus);
				menuModel.removeAllElements();
				menuList.setModel(menuModel);
			}
		});

		/**
		 * Add ActionListeners and ActionHandlers to the button of "Save to file", creating and writing the data into "menus.txt" file
		 */
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(menus.size()==0) {
					JOptionPane.showMessageDialog(null, "No menu generated! Please generate at least one menu first!");
					return;
				}
				FileManager.writeMenu("data/menus.txt", menus);
				JOptionPane.showMessageDialog(null, "Congratulations! The TXT file is successfully saved!\nYou can find it inside the fold \"data\"!");
			}
		});

		mainWindow.setVisible(true);
	}

	/**
	 * Method generateChildWindow generates the child window showing the detail of the selected menu
	 * @param menu
	 */
	public void generateChildWindow(Menu menu) {
		this.childWindow = new JFrame("Menu:  "+menu.getName());
		childWindow.setLayout(null);
		childWindow.setBounds(mainWindow.getX()+100,mainWindow.getY()-60,mainWindow.getWidth()-20,mainWindow.getHeight()+100);

		//create the label & the text area for the content of the Entree inside the specific menu
		lblChildEntree = new JLabel("Entree");
		lblChildEntree.setBounds(40,30,lblEntree.getWidth()+30,lblEntree.getHeight());

		txtEntree = new JTextArea();
		String entreeString = menu.getEntree().getName()+"\n"+menu.getEntree().getDescription()
				+".\nCalories: "+menu.getEntree().getCalories()+"\nPrice: "+menu.getEntree().getPrice();
		txtEntree = new JTextArea(entreeString);
		txtEntree.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtEntree.setLineWrap(true);
		txtEntree.setWrapStyleWord(true);
		txtEntree.setBounds(lblChildEntree.getX()+lblChildEntree.getWidth()+40,lblChildEntree.getY(),
				childWindow.getWidth()-lblChildEntree.getWidth()-120,btnGenerateRandom.getHeight()*2+20);
		txtEntree.setEditable(false);


		//create the label & the text area for the content of the Side inside the specific menu
		lblChildSide = new JLabel("Side");
		lblChildSide.setBounds(lblChildEntree.getX(),txtEntree.getY()+txtEntree.getHeight()+20,
				lblChildEntree.getWidth(),lblChildEntree.getHeight());

		txtSide = new JTextArea();
		String sideString = menu.getSide().getName()+"\n"+menu.getSide().getDescription()
				+".\nCalories: "+menu.getSide().getCalories()+"\nPrice: "+menu.getSide().getPrice();
		txtSide = new JTextArea(sideString);
		txtSide.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtSide.setLineWrap(true);
		txtSide.setWrapStyleWord(true);
		txtSide.setBounds(txtEntree.getX(),lblChildSide.getY(),txtEntree.getWidth(),txtEntree.getHeight());
		txtSide.setEditable(false);

		//create the label & the text area for the content of the Salad inside the specific menu
		lblChildSalad = new JLabel("Salad");
		lblChildSalad.setBounds(lblChildSide.getX(),lblChildSide.getY()+txtSide.getHeight()+20,
				lblChildSide.getWidth(),lblChildSide.getHeight());

		txtSalad = new JTextArea();
		String saladString = menu.getSalad().getName()+"\n"+menu.getSalad().getDescription()
				+".\nCalories: "+menu.getSalad().getCalories()+"\nPrice: "+menu.getSalad().getPrice();
		txtSalad = new JTextArea(saladString);
		txtSalad.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtSalad.setLineWrap(true);
		txtSalad.setWrapStyleWord(true);
		txtSalad.setBounds(txtSide.getX(),lblChildSalad.getY(),txtSide.getWidth(),txtSide.getHeight());
		txtSalad.setEditable(false);

		//create the label & the text area for the content of the Salad inside the specific menu
		lblChildDessert = new JLabel("Dessert");
		lblChildDessert.setBounds(lblChildSalad.getX(),lblChildSalad.getY()+txtSalad.getHeight()+20,
				lblChildSalad.getWidth(),lblChildSalad.getHeight());

		txtDessert = new JTextArea();
		String dessertString = menu.getDessert().getName()+"\n"+menu.getDessert().getDescription()
				+".\nCalories: "+menu.getDessert().getCalories()+"\nPrice: "+menu.getDessert().getPrice();
		txtDessert = new JTextArea(dessertString);
		txtDessert.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtDessert.setLineWrap(true);
		txtDessert.setWrapStyleWord(true);
		txtDessert.setBounds(txtSalad.getX(),lblChildDessert.getY(),txtSalad.getWidth(),txtSalad.getHeight());
		txtDessert.setEditable(false);
		
		
		//Create the label and text field for the total Carlories of the current menu
		lblTotalCalories = new JLabel("Total calories:");
		lblTotalCalories.setBounds(lblChildEntree.getX(),txtDessert.getY()+txtDessert.getHeight()+20
				,lblChildEntree.getWidth(),lblChildEntree.getHeight());
		
		String cal = String.valueOf(menu.totalCalories());
		txtTCalories = new JTextField(cal);
		txtTCalories.setBounds(txtDessert.getX(),lblTotalCalories.getY(),lblTotalCalories.getWidth(),btnCreateMenu.getHeight());
		txtTCalories.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtTCalories.setEditable(false);
		
		//Create the label and text field for the total Price of the current menu
		lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setBounds(lblTotalCalories.getX(),lblTotalCalories.getY()+lblTotalCalories.getHeight()+20
				,lblTotalCalories.getWidth(),lblTotalCalories.getHeight());
		
		String price = "$"+String.valueOf(menu.totalPrice());
		txtTPrice = new JTextField(price);
		txtTPrice.setBounds(txtDessert.getX(),lblTotalPrice.getY(),lblTotalPrice.getWidth(),btnCreateMenu.getHeight());
		txtTPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtTPrice.setEditable(false);
		
		childWindow.getContentPane().add(lblChildEntree);
		childWindow.getContentPane().add(txtEntree);
		childWindow.getContentPane().add(lblChildSide);
		childWindow.getContentPane().add(txtSide);
		childWindow.getContentPane().add(lblChildSalad);
		childWindow.getContentPane().add(txtSalad);
		childWindow.getContentPane().add(lblChildDessert);
		childWindow.getContentPane().add(txtDessert);
		childWindow.getContentPane().add(lblTotalCalories);
		childWindow.getContentPane().add(txtTCalories);
		childWindow.getContentPane().add(lblTotalPrice);
		childWindow.getContentPane().add(txtTPrice);

		childWindow.setVisible(true);

	}
}
