import javax.swing.*;
import java.awt.*;

public class Main implements Runnable {
	
	private Thread    gameThread;
	private int       width;
	private int       height;
	private Dimension dim;
	private Game      game;
	private JFrame    frame;
	
	private boolean running;
	private int     TARGET_UPS = 30;
	private int     TARGET_FPS = 60;
	
	public Main(int width, int height) {
		this.width = width;
		this.height = height;
		dim = new Dimension(width, height);
		
		game = new Game(width, height);
		
		
		frame = new JFrame("Escape Room Summative");
		frame.setSize(dim);
		frame.setPreferredSize(dim);
		frame.setMinimumSize(dim);
		frame.setMaximumSize(dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		//now the thing will probably display :DD
		
		gameThread = new Thread(this, "GAME_THREAD");
	}
	
	private void init() {
		running = true;
		game.init();
	}
	
	//function with the game loop
	private void loop() {
		float  elapsed;
		float  accumulated = 0f;
		float  interval    = 1f / TARGET_UPS;
		double time;
		double lastCall    = System.nanoTime();
		
		running = true;
		//loop while running and the window hasn't received a close command
		while (running) {
			time = System.nanoTime();
			
			elapsed = (float) ((time-lastCall) / 1e9);
			lastCall = time;
			
			accumulated += elapsed;
			
			while (accumulated >= interval) {
				update();
				accumulated -= interval;
			}
			//render once per loop, then wait until the render time slot is over before restarting
			game.render();
			sync(lastCall/1e9);
			
		}
		
		
	}
	
	/**
	 * Syncs rendering to the render interval
	 */
	private void sync(double lastCallTime) {
		float  renderInterval = 1f / TARGET_FPS;
		double endTime        = lastCallTime + renderInterval;
		//while current time is less than allotted time, wait
		while (System.nanoTime() / 1e9 < endTime) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}
	
	private void update() {
		game.update();
	}
	
	public static void main(String... args) {
		Main main = new Main(800, 600);
		main.start();
	}
	
	
	//Distinguishes between MacOS and other OS's
	public void start() {
		String osName = System.getProperty("os.name");
		if (osName.contains("Mac")) {
			gameThread.run();
		} else {
			gameThread.start();
		}
	}
	
	@Override
	public void run() {
		try {
			init();
			loop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
