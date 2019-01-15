import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game extends JPanel {
	
	private int width, height;
	private Dimension dim;
	
	private KeyHandler kh;
	private MouseHandler mh;
	
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		dim = new Dimension(width, height);
		setSize(dim);
		setPreferredSize(dim);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setFocusable(true);
	}
	
	//TODO idk if you want to put initializations in here
	public void init() {
		//lol you monkeys boosted
		//it works this way :P
		kh = new KeyHandler();
		mh = new MouseHandler();
		
		addKeyListener(kh);
		addMouseListener(mh);
		addMouseMotionListener(mh);
	}
	
	//TODO RENDERING TAKES PLACE HERE :DD
	public void render() {
		//call repaint to call paintComponent
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		demoFunc(g,50,193,Color.magenta);
		demoFunc(g,325,132,Color.green);
		demoFunc(g,111,111,Color.blue);
	}
	
	public void demoFunc(Graphics g, int x, int y, Color c){
		g.setColor(c);
		g.fillRect(x,y,100,100);
	}
	
	
	//TODO UPDATES GO HERE :DD
	public void update() {
	
	}
	
}
