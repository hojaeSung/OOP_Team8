
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class game extends JFrame implements KeyListener {

	BackGround B1, B2;
	Image image;
	Graphics graphics;
	CopyOnWriteArrayList<BackGround> BG = new CopyOnWriteArrayList<BackGround>();
	
	public game() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Rinding On JAVA"); //Frame name Setting
		this.setSize(600, 700); //Frame Size Setting
	
		addKeyListener(this);
		
		B1 = new BackGround(0);
		BG.add(B1);
		B2 = new BackGround(-600);
		BG.add(B2);

		this.setVisible(true);

	}

	public static void main(String[] ar) {
		game game = new game();
	}

	public void paint(Graphics g) {

		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		paintComponent(graphics);

		g.drawImage(image, 0, 100, null); // image start at (0,100)
		
		repaint();
	}

	private void paintComponent(Graphics g) {
		
		for (BackGround B : BG) {  // BackGound image 내려오게
			B.update();
			B.draw(g);
			if (B.yPos == this.getHeight()) {
				B2 = new BackGround(-600);
				BG.add(B2);
				BG.remove(B);
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
