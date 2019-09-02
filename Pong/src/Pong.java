import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Stroke;
import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Rectangle;

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
		repaint();
	}
	//adding after here
	private void update() {
	}
	
	 @Override
	 public void paintComponent(Graphics g) {
	     super.paintComponent(g);
	     paintDottedLine(g);
	     //g.setColor(Color.WHITE); // only for testing
	     //g.fillRect(20, 20, 100, 100); // first two position from top left, next 2 the size
	 }
	 
	 private void paintDottedLine(Graphics g) {
	      Graphics2D g2d = (Graphics2D) g.create();
	         Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
	         g2d.setStroke(dashed);
	         g2d.setPaint(Color.WHITE);
	         g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
	         g2d.dispose();
	 }
}

class Sprite{
	private int xPosition, yPosition; 
	private int xVelocity, yVelocity;
	private int width, height;
    private int initialXPosition, initialYPosition;
    private Color colour;
	
    public int getXPosition() { return xPosition; }
    public int getYPosition() { return yPosition; }
    public int getXVelocity() { return xVelocity; }
    public int getYVelocity() { return yVelocity; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public Color getColour() { return colour; }
    
    public void setXPosition(int newX) {
        xPosition = newX;
    }
    public void setYPosition(int newY) {
        yPosition = newY;
    }
    
    public void setXPosition(int newX, int panelWidth) {
        xPosition = newX;
        if(xPosition < 0) {
            xPosition = 0;
        } else if(xPosition + width > panelWidth) {
            xPosition = panelWidth - width;
        }
    }
    public void setYPosition(int newY, int panelHeight) {
        yPosition = newY;
        if(yPosition < 0) {
            yPosition = 0;
        } else if(yPosition + height > panelHeight) {
            yPosition = panelHeight - height;
        }
    }
    
    public void setXVelocity(int newXVelocity) {
        xVelocity = newXVelocity;
    }
    public void setYVelocity(int newYVelocity) {
        yVelocity = newYVelocity;
    }
    
    public void setWidth(int newWidth) {
        width = newWidth;
    }
    public void setHeight(int newHeight) {
        height = newHeight;
    }
    
    public void setColour(Color newColour) {
        colour = newColour;
    }
    
    public void setInitialPosition(int initialX, int initialY) {
          initialXPosition = initialX;
          initialYPosition = initialY;
    }
    public void resetToInitialPosition() {
         setXPosition(initialXPosition);
         setYPosition(initialYPosition);
    }
    
    public Rectangle getRectangle() {
        return new Rectangle(getXPosition(), getYPosition(), getWidth(), getHeight());
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
