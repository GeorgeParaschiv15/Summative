import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game extends JPanel {
	
	private int width, height;
	private Dimension dim;
	
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
		
		addKeyListener(new KeyHandler());
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseHandler());
		
	}
	
	//TODO RENDERING TAKES PLACE HERE :DD
	public void render() {
	}
	
	
	//TODO UPDATES GO HERE :DD
	public void update() {
	
	}
	
}
