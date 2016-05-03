import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FrameMake extends JFrame implements KeyListener, Runnable{

	int f_width = 800;

	int f_height = 600;

	int x, y; // 캐릭터의 좌표 변수

	boolean KeyUp = false; // 키보드 입력 처리를 위한 변수

	boolean KeyDown = false;

	boolean KeyLeft = false;

	boolean KeyRight = false;

	Thread th; // 스레드 생성

	Toolkit tk = Toolkit.getDefaultToolkit();

	Image me_img = tk.getImage("src/car.png");

	FrameMake() {

		init();

		start();

		setTitle("RideOnJava");

		setSize(f_width, f_height);

		Dimension screen = tk.getScreenSize();

		int f_xpos = (int) (screen.getWidth() / 2 - f_width / 2);

		int f_ypos = (int) (screen.getHeight() / 2 - f_height / 2);

		setLocation(f_xpos, f_ypos);

		setResizable(false);

		setVisible(true);

	}

	public void init() {

		x = 100; // 캐릭터의 최초 좌표.

		y = 100;

	}

	public void start() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addKeyListener(this); // 키보드 이벤트 실행

		th = new Thread(this); // 스레드 생성

		th.start(); // 스레드 실행

	}

	public void run() { // 스레드가 무한 루프될 부분

		try { // 예외옵션 설정으로 에러 방지

			while (true) { // while 문으로 무한 루프 시키기

				KeyProcess(); // 키보드 입력처리를 하여 x,y 갱신

				repaint(); // 갱신된 x,y값으로 이미지 새로 그리기

				Thread.sleep(20); // 20 milli sec 로 스레드 돌리기

			}

		} catch (Exception e) {
		}

	}

	public void paint(Graphics g) {

		g.clearRect(0, 0, f_width, f_height);

		g.drawImage(me_img, x, y, this);

		// 변경되는 좌표에 따라 이미지가 새로 그려지게 하기.

	}

	public void keyPressed(KeyEvent e) {

		// 키보드가 눌러졌을때 이벤트 처리하는 곳

		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:

			KeyUp = true;

			break;

		case KeyEvent.VK_DOWN:

			KeyDown = true;

			break;

		case KeyEvent.VK_LEFT:

			KeyLeft = true;

			break;

		case KeyEvent.VK_RIGHT:

			KeyRight = true;

			break;

		}

	}

	public void keyReleased(KeyEvent e) {

		// 키보드가 눌러졌다가 때어졌을때 이벤트 처리하는 곳

		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:

			KeyUp = false;

			break;

		case KeyEvent.VK_DOWN:

			KeyDown = false;

			break;

		case KeyEvent.VK_LEFT:

			KeyLeft = false;

			break;

		case KeyEvent.VK_RIGHT:

			KeyRight = false;

			break;

		}

	}

	public void keyTyped(KeyEvent e) {
	}

	// 키보드가 타이핑 될때 이벤트 처리하는 곳

	public void KeyProcess() {

		// 실제로 캐릭터 움직임 실현을 위해

		// 위에서 받아들인 키값을 바탕으로

		// 키 입력시마다 5만큼의 이동을 시킨다.

		if (KeyUp == true)
			y -= 5;

		if (KeyDown == true)
			y += 5;

		if (KeyLeft == true)
			x -= 5;

		if (KeyRight == true)
			x += 5;

	}

}