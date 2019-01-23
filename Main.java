import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class Main implements Runnable {
	
	private final Thread    gameThread;
	private final Game      game;
	
	private       boolean running;
	
	private Main() {
		Dimension dim = new Dimension(800, 600);
		
		game = new Game(800, 600);
		
		
		JFrame frame = new JFrame("Escape Room Summative");
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
		int    TARGET_UPS  = 30;
		float  interval    = 1f / TARGET_UPS;
		double time;
		double lastCall    = System.nanoTime();
		
		running = true;
		//loop while running and the window hasn't received a close command
		while (running) {
			time = System.nanoTime();
			
			elapsed = (float) ((time - lastCall) / 1e9);
			lastCall = time;
			
			accumulated += elapsed;
			
			while (accumulated >= interval) {
				update();
				accumulated -= interval;
			}
			//render once per loop, then wait until the render time slot is over before restarting
			game.render();
			sync(lastCall / 1e9);
			
		}
		
		
	}
	
	/*
	 * Syncs rendering to the render interval
	 */
	private void sync(double lastCallTime) {
		int    TARGET_FPS     = 60;
		float  renderInterval = 1f / TARGET_FPS;
		double endTime        = lastCallTime + renderInterval;
		//while current time is less than allotted time, wait
		while (System.nanoTime() / 1e9 < endTime) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException ignored) {
			}
		}
	}
	
	private void update() {
		game.update();
	}
	
	public static void main(String... args) {
		Main main = new Main();
		main.start();
		
		//Background Music
			main.playmusic();
		
	}
	
	//Music PLaying Method
	private void playmusic(){
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("backgroundmusic.wav"));
			Clip             clip    = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch(UnsupportedAudioFileException | IOException | LineUnavailableException e){
			e.printStackTrace();
		}
	}
	
	//Distinguishes between MacOS and other OS's
	private void start() {
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
