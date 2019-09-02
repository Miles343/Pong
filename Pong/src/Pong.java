import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class PongPanel extends JPanel implements ActionListener, KeyListener{
	
	private final static Color BACKGROUND_COLOUR = Color.BLACK;
	private final static int TIMER_DELAY = 5;
	
	public PongPanel() {
		setBackground(BACKGROUND_COLOUR);
		Timer timer = new Timer(TIMER_DELAY, this);
        timer.start();
	}
	@Override
	public void keyPressed(KeyEvent event) {
	}

	@Override
	public void keyReleased(KeyEvent event) {
	}

	@Override
	public void keyTyped(KeyEvent event) {
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
	//adding after here
	private void update() {
		
	}
	
	 @Override
	 public void paintComponent(Graphics g) {
	     super.paintComponent(g);
	     g.setColor(Color.WHITE);
	     g.fillRect(20, 20, 100, 100); // first two position from top left, next 2 the size
	 }
}

public class Pong extends JFrame {
	
    private final static String WINDOW_TITLE = "Pong";
    private final static int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
	
	public Pong() {
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new PongPanel());
	}
	public static void main(String[] args) {
		new Pong();
		//new PongPanel(); doesn't work must be in the Pong constructor window
	}

}
