import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameMake extends JFrame implements KeyListener, Runnable{

	int f_width = 800;
	int f_height = 700;
	
	
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image basic_car = tk.getImage("car.jpg");
	
	FrameMake(){
		
		init();
		start();
		
	
		
		setTitle("RaciongOnJava");
		setSize(f_width,f_height);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		int f_Wmid = (int)(screen.getWidth()/2-f_width/2);
		int f_Hmid = (int)(screen.getHeight()/2-f_height/2);
		
		setLocation(f_Wmid,f_Hmid);
		setResizable(false);
		setVisible(true);
	}
	
	public void init(){
		
	}
	
	public void start(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public void patin(Graphics g){
		g.clearRect(0, 0, f_width, f_height);
		g.drawImage(basic_car, 100, 100, this);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
