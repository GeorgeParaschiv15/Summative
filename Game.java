import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

class Game extends JPanel {
	
	private       int i     = 0; //Used to keep track of how far the user has progressed in the game.
	private       int wall  = 1; //Used to decide which wall to display
	private       int key   = 0; //Used to keep track of how many keys the user has
	private       int y     = 201;
	
	private final JButton      start;
	private final JButton      instructions;
	private final JButton      chest1;
	private final JButton      chest2;
	private final JButton      chest3;
	private final JButton      chest4;
	private final JButton      chest5;
	private final JButton      chest6;
	private final JButton      odyssey;
	private final JButton      mirror;
	private final JButton      bridgetable;
	private final JButton      todo;
	private final JButton      backpack;
	private final JButton      mcmaster;
	private final JButton      finaldoor;
	
	/*
	Flags are used to tell us if a chest has been opened or not
	False means it hasn't been opened.
	True means it has been opened.
	 */
	private boolean flag1 = false;
	private boolean flag2 = false;
	private boolean flag3 = false;
	private boolean flag4 = false;
	private boolean flag5 = false;
	private boolean flag6 = false;
	
	//Game Constructor
	public Game(int width, int height) {
		Dimension dim = new Dimension(width, height);
		setSize(dim);
		setPreferredSize(dim);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setFocusable(true);
		setLayout(null);
		
		//Start Button
		start = new JButton("START");
		start.setFont(new Font("Gadugi", Font.BOLD, 20));
		start.setForeground(Color.white);
		start.setBounds((width - 100) / 2, (height - 40) / 2 + 50, 100, 40);
		start.setBackground(new Color(0, 0, 0, 0));
		add(start);
		
		//Instructions Button
		instructions = new JButton("INSTRUCTIONS");
		instructions.setFont(new Font("Gadugi", Font.BOLD, 20));
		instructions.setForeground(Color.white);
		instructions.setBounds((width - 180) / 2, (height - 40) / 2 + 100, 180, 40);
		instructions.setBackground(new Color(0, 0, 0, 0));
		add(instructions);
		
		//Chest1 Button
		chest1 = new JButton("");
		chest1.setBounds(19, 96, 233, 136);
		chest1.setBackground(new Color(0, 0, 0, 0));
		chest1.setBorderPainted(false);
		
		//Chest2 Button
		chest2 = new JButton("");
		chest2.setBounds(276, 96, 233, 136);
		chest2.setBackground(new Color(0, 0, 0, 0));
		chest2.setBorderPainted(false);
		
		//Chest3 Button
		chest3 = new JButton("");
		chest3.setBounds(532, 96, 233, 136);
		chest3.setBackground(new Color(0, 0, 0, 0));
		chest3.setBorderPainted(false);
		
		//Chest4 Button
		chest4 = new JButton("");
		chest4.setBounds(23, 434, 233, 136);
		chest4.setBackground(new Color(0, 0, 0, 0));
		chest4.setBorderPainted(false);
		
		//Chest5 Button
		chest5 = new JButton("");
		chest5.setBounds(267, 436, 233, 136);
		chest5.setBackground(new Color(0, 0, 0, 0));
		chest5.setBorderPainted(false);
		
		//Chest6 Button
		chest6 = new JButton("");
		chest6.setBounds(527, 436, 233, 136);
		chest6.setBackground(new Color(0, 0, 0, 0));
		chest6.setBorderPainted(false);
		
		//To Do List Button
		todo = new JButton("");
		todo.setBounds(414, 154, 160, 165);
		todo.setBackground(new Color(0, 0, 0, 0));
		todo.setBorderPainted(false);
		
		//Odyssey Button
		odyssey = new JButton("");
		odyssey.setBounds(132, 247, 17, 72);
		odyssey.setBackground(new Color(0, 0, 0, 0));
		odyssey.setBorderPainted(false);
		
		//Mirror button
		mirror = new JButton("");
		mirror.setBounds(141, 103, 106, 149);
		mirror.setBackground(new Color(0, 0, 0, 0));
		mirror.setBorderPainted(false);
		
		//Bridge Table Button
		bridgetable = new JButton("");
		bridgetable.setBounds(438, 335, 304, 25);
		bridgetable.setBackground(new Color(0, 0, 0, 0));
		bridgetable.setBorderPainted(false);
		
		//Backpack Button
		backpack = new JButton("");
		backpack.setBounds(35, 426, 102, 123);
		backpack.setBackground(new Color(0, 0, 0, 0));
		backpack.setBorderPainted(false);
		
		//McMaster Button
		mcmaster = new JButton("");
		mcmaster.setBounds(550, 201, 97, 103);
		mcmaster.setBackground(new Color(0, 0, 0, 0));
		mcmaster.setBorderPainted(false);
		
		//FinalDoor Button
		finaldoor = new JButton("");
		finaldoor.setBounds(301, 58, 181, 403);
		finaldoor.setBackground(new Color(0, 0, 0, 0));
		finaldoor.setBorderPainted(false);
		
		//Menu Page ActionListeners
		StartHandler handler1 = new StartHandler();
		start.addActionListener(handler1);
		InstructionsHandler handler2 = new InstructionsHandler();
		instructions.addActionListener(handler2);
		
		//Chest Wall ActionListeners
		ChestHandler1 chesthandler1 = new ChestHandler1();
		chest1.addActionListener(chesthandler1);
		ChestHandler2 chesthandler2 = new ChestHandler2();
		chest2.addActionListener(chesthandler2);
		ChestHandler3 chesthandler3 = new ChestHandler3();
		chest3.addActionListener(chesthandler3);
		ChestHandler4 chesthandler4 = new ChestHandler4();
		chest4.addActionListener(chesthandler4);
		ChestHandler5 chesthandler5 = new ChestHandler5();
		chest5.addActionListener(chesthandler5);
		ChestHandler6 chesthandler6 = new ChestHandler6();
		chest6.addActionListener(chesthandler6);
		
		//2nd wall ActionListeners
		OdysseyHandler odysseyhandler = new OdysseyHandler();
		odyssey.addActionListener(odysseyhandler);
		TodoHandler todohandler = new TodoHandler();
		todo.addActionListener(todohandler);
		
		//3rd wall ActionListeners
		BridgetableHandler bridgehandler = new BridgetableHandler();
		bridgetable.addActionListener(bridgehandler);
		MirrorHandler mirrorhandler = new MirrorHandler();
		mirror.addActionListener(mirrorhandler);
		
		//Door wall ActionListeners
		BackpackHandler backpackhandler = new BackpackHandler();
		backpack.addActionListener(backpackhandler);
		McMasterHandler mcmasterhandler = new McMasterHandler();
		mcmaster.addActionListener(mcmasterhandler);
		DoorHandler doorhandler = new DoorHandler();
		finaldoor.addActionListener(doorhandler);
		
	}
	
	/*
	These CheckWall methods help us to figure out what buttons to remove.
	Wall is used in these methods to tell us which wall we were on before we switched.
	 */
	private void checkwall1() {
		/*
		The if block here checks for if a chest has already been solved before switching.
		Before switching from one wall to another we need to know which buttons to remove.
		If it has been solved, then the button has already been removed somewhere else, so we don't remove it here.
		If it hasn't been removed then the button gets removed.
		 */
		if (wall == 1) {
			if (flag1 == false) {
				remove(chest1);
			}
			if (flag2 == false) {
				remove(chest2);
			}
			if (flag3 == false) {
				remove(chest3);
			}
			if (flag4 == false) {
				remove(chest4);
			}
			if (flag5 == false) {
				remove(chest5);
			}
			if (flag6 == false) {
				remove(chest6);
			}
		}
	}
	
	private void checkwall2() {
		remove(todo);
		remove(odyssey);
	}
	
	private void checkwall3() {
		remove(bridgetable);
		remove(mirror);
	}
	
	private void checkwall4() {
		if (wall == 4) {
			remove(backpack);
			remove(mcmaster);
			remove(finaldoor);
		}
	}
	
	//KeyHandler Class
	class KeyHandler implements KeyListener {
		
		@Override
		public void keyTyped(KeyEvent e) {
		
		}
		
		/*
		KeyPressed checks for user input of keys 1, 2, 3, 4.
		CheckWall methods used to tell us what buttons to remove
		Wall is set to a value that is used later to tell us what buttons to add.
		Revalidate and Repaint are called after to do the background drawing and button adding.
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_1) {
				checkwall2();
				checkwall3();
				checkwall4();
				wall = 1;
				/*
				This if block is used to tell us which buttons to re-add after switching back to the first room.
				Flag tells us if the chest has been solved.
				If the chest has been solved already, it won't be re-added.
				 */
				if (flag1 == false) {
					add(chest1);
				}
				if (flag2 == false) {
					add(chest2);
				}
				if (flag3 == false) {
					add(chest3);
				}
				if (flag4 == false) {
					add(chest4);
				}
				if (flag5 == false) {
					add(chest5);
				}
				if (flag6 == false) {
					add(chest6);
				}
				revalidate();
				repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_2) {
				checkwall1();
				checkwall3();
				checkwall4();
				wall = 2;
				revalidate();
				repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_3) {
				checkwall1();
				checkwall2();
				checkwall4();
				wall = 3;
				revalidate();
				repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_4) {
				checkwall1();
				checkwall2();
				checkwall3();
				wall = 4;
				revalidate();
				repaint();
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
		
		}
	}
	
	//Initializations
	public void init() {
		KeyHandler kh = new KeyHandler();
		addKeyListener(kh);
	}
	
	//Class for start button click events
	private class StartHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			i += 1; //Increments i by one so that later the screen and instructions buttons wont be re-added.
			remove(start);
			remove(instructions);
			revalidate();
			repaint();
		}
	}
	
	//Class for instructions button click events
	private class InstructionsHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(Game.this, "This is an escape room game. \nTo control the game you use the mouse and the keyboard. \nUse the keys 1, 2, 3, 4 to switch between the different views of the room. \nUse the mouse to click on objects and try to escape. \nGood Luck!", "Instructions", JOptionPane.PLAIN_MESSAGE, null);
		}
	}
	
	//Class for chest1 button click events
	private class ChestHandler1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String code = JOptionPane.showInputDialog("What is the answer to your homework?");
			if (code.equals("3975")) {
				flag1 = true;
				key++;
				JOptionPane.showMessageDialog(Game.this, "You have " + key + keychecker(key), "You got a key.", JOptionPane.PLAIN_MESSAGE, null);
				remove(chest1);
				revalidate();
				repaint();
			} else {
				JOptionPane.showMessageDialog(Game.this, "That code is incorrect, try again.", "Incorrect Code", JOptionPane.PLAIN_MESSAGE, null);
			}
			
		}
	}
	
	//Class for chest2 button click events
	private class ChestHandler2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String code = JOptionPane.showInputDialog("Go study some art.");
			if (code.equalsIgnoreCase("SNAP")) {
				flag2 = true;
				key++;
				JOptionPane.showMessageDialog(Game.this, "You have " + key + keychecker(key), "You got a key.", JOptionPane.PLAIN_MESSAGE, null);
				remove(chest2);
				revalidate();
				repaint();
			} else {
				JOptionPane.showMessageDialog(Game.this, "That code is incorrect, try again.", "Incorrect Code", JOptionPane.PLAIN_MESSAGE, null);
			}
			
		}
	}
	
	//Class for chest3 button click events
	private class ChestHandler3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String code = JOptionPane.showInputDialog("Go Play Some Bridge");
			if (code.equalsIgnoreCase("2C2H")) {
				flag3 = true;
				key++;
				JOptionPane.showMessageDialog(Game.this, "You have " + key + keychecker(key), "You got a key.", JOptionPane.PLAIN_MESSAGE, null);
				remove(chest3);
				revalidate();
				repaint();
			} else {
				JOptionPane.showMessageDialog(Game.this, "That code is incorrect, try again.", "Incorrect Code", JOptionPane.PLAIN_MESSAGE, null);
			}
			
		}
	}
	
	//Class for chest4 button click events
	private class ChestHandler4 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String code = JOptionPane.showInputDialog("Mirror mirror on the wall.");
			if (code.equalsIgnoreCase("conner")) {
				flag4 = true;
				key++;
				JOptionPane.showMessageDialog(Game.this, "You have " + key + keychecker(key), "You got a key.", JOptionPane.PLAIN_MESSAGE, null);
				remove(chest4);
				revalidate();
				repaint();
			} else {
				JOptionPane.showMessageDialog(Game.this, "That code is incorrect, try again.", "Incorrect Code", JOptionPane.PLAIN_MESSAGE, null);
			}
			
		}
	}
	
	//Class for chest5 button click events
	private class ChestHandler5 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String code = JOptionPane.showInputDialog("Check your todo's.");
			if (code.equals("17")) {
				flag5 = true;
				key++;
				JOptionPane.showMessageDialog(Game.this, "You have " + key + keychecker(key), "You got a key.", JOptionPane.PLAIN_MESSAGE, null);
				remove(chest5);
				revalidate();
				repaint();
			}
			else {
				JOptionPane.showMessageDialog(Game.this, "That code is incorrect, try again.", "Incorrect Code", JOptionPane.PLAIN_MESSAGE, null);
			}
			
		}
	}
	
	//Class for chest6 button click events
	private class ChestHandler6 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String code = JOptionPane.showInputDialog("A book a day keeps the doctor away.");
			if (code.equals("6240")) {
				flag6 = true;
				key++;
				JOptionPane.showMessageDialog(Game.this, "You have " + key + keychecker(key), "You got a key.", JOptionPane.PLAIN_MESSAGE, null);
				remove(chest6);
				revalidate();
				repaint();
			} else {
				JOptionPane.showMessageDialog(Game.this, "That code is incorrect, try again.", "Incorrect Code", JOptionPane.PLAIN_MESSAGE, null);
			}
			
		}
	}
	
	//Class for odyssey button click events
	private class OdysseyHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispImg("Odyssey.jpg","The Odyssey");
			remove(odyssey);
			revalidate();
			repaint();
		}
	}
	
	//Class for todo button click events
	private class TodoHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispImg("ToDoList.jpg", "Todo List");
			remove(todo);
			revalidate();
			repaint();
		}
	}
	
	//Class for mirror button click events
	private class MirrorHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispImg("Mirror.png", "Mirror");
			remove(mirror);
			revalidate();
			repaint();
		}
	}
	
	//Class for bridgetable button click events
	private class BridgetableHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispImg("Bridge.png", "Bridge Games");
			remove(bridgetable);
			revalidate();
			repaint();
		}
	}
	
	//Class for mcmaster button click events
	private class McMasterHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < 103; i++) {
				if (y > 98)
					y--;
			}
			remove(mcmaster);
			revalidate();
			repaint();
		}
	}
	
	//Class for backpack button click events
	private class BackpackHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispImg("MathHomework.png", "Homework");
			remove(backpack);
			revalidate();
			repaint();
		}
	}
	
	//Class for door button click events
	private class DoorHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (key == 6) {
				remove(backpack);
				remove(mcmaster);
				remove(finaldoor);
				wall++;
				revalidate();
				repaint();
			} else {
				JOptionPane.showMessageDialog(Game.this, "You need 6 keys to unlock this door. \nYou currently have " + key + keychecker(key), "Not Enough Keys", JOptionPane.PLAIN_MESSAGE, null);
				remove(finaldoor);
				revalidate();
				repaint();
			}
			
		}
	}
	
	//Rendering
	public void render() {
		//Call repaint to call paintComponent
		repaint();
	}
	
	//PaintComponent is where the image drawing occurs
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawImg(g, "Menu.jpg", 0, 0, 800, 600);
		
		//If statements check for what wall you are on
		if (i >= 1 && wall == 1) {
			drawImg(g, "ChestWall.jpg", 0, 0, 800, 600);
			add(chest1);
			add(chest2);
			add(chest3);
			add(chest4);
			add(chest5);
			add(chest6);
			if (flag1 == true) {
				remove(chest1);
			}
			if (flag2 == true) {
				remove(chest2);
			}
			if (flag3 == true) {
				remove(chest3);
			}
			if (flag4 == true) {
				remove(chest4);
			}
			if (flag5 == true) {
				remove(chest5);
			}
			if (flag6 == true) {
				remove(chest6);
			}
		}
		
		if (i >= 1 && wall == 2) {
			drawImg(g, "Todowall.png", 0, 0, 800, 600);
			add(todo);
			add(odyssey);
		}
		
		if (i >= 1 && wall == 3) {
			drawImg(g, "MirrorWall.png", 0, 0, 800, 600);
			add(bridgetable);
			add(mirror);
		}
		
		if (i >= 1 && wall == 4) {
			drawImg(g, "FinalDoorWall.png", 0, 0, 800, 600);
			drawImg(g, "McMaster.png", 550, y, 97, 103);
			add(backpack);
			add(mcmaster);
			add(finaldoor);
		}
		
		if (i >= 1 && wall == 5) {
			drawImg(g, "CreditsScreen.png", 0, 0, 800, 600);
		}
	}
	
	//Method for drawing images
	private void drawImg(Graphics g, String filename, int x, int y, int w, int h) {
		BufferedImage name = null;
		try {
			name = ImageIO.read(getClass().getResource(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(name, x, y, w, h, null);
	}
	
	//Method for displaying images as a popup
	private void dispImg(String filename, String title) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource(filename));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JLabel x = new JLabel(new ImageIcon(Objects.requireNonNull(image)));
		JOptionPane.showMessageDialog(Game.this, x, title, JOptionPane.PLAIN_MESSAGE, null);
	}
	
	//Method that returns either key or keys based on how many keys there are.
	private String keychecker(int x) {
		if (x == 1) {
			return " key.";
		} else {
			return " keys.";
		}
	}
	
	//Updates
	public void update() {
	
	}
}
