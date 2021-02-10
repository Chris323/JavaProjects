package rb;

import java.awt.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

import javax.swing.*;

class Ball extends Thread {
	int x;
	int y;
	Color c;
	BallWindow bWindow;
	Lock winLock;
	Semaphore semaph;

	public Ball(int x, int y, Color c, BallWindow bWindow, Lock winLock, Semaphore semaph) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.bWindow = bWindow;
		this.winLock = winLock;
		this.semaph = semaph;
	}

	public void run() {
//winLock.lock();
		try {
			semaph.acquire();
		} catch (Exception e) {
		}
		while (true) {
			bWindow.repaint();
			y = y + 10;
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			if (y > 350)
				break;
		}
		semaph.release();
//winLock.unlock();
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y - 10, 50, 50);

		g.setColor(c);
		g.fillOval(x, y, 50, 50);
	}
}

class BallWindow extends JFrame {
	Ball[] balls;
	Lock winLock;
	Semaphore semaph;

	public BallWindow() {
		winLock = new ReentrantLock();
		semaph = new Semaphore(2);
		balls = new Ball[5];
		balls[0] = new Ball(100, 100, Color.red, this, winLock, semaph);
		balls[1] = new Ball(200, 100, Color.blue, this, winLock, semaph);
		balls[2] = new Ball(300, 100, Color.yellow, this, winLock, semaph);
		balls[3] = new Ball(400, 100, Color.green, this, winLock, semaph);
		balls[4] = new Ball(500, 100, Color.gray, this, winLock, semaph);

		for (int i = 0; i < 5; i++) {
			balls[i].start();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setVisible(true);
	}

	public void paint(Graphics g) {
		for (int i = 0; i < 5; i++) {
			balls[i].draw(g);
		}
	}
}

public class RunningBall {
	public static void main(String[] args) {
		new BallWindow();
	}
}