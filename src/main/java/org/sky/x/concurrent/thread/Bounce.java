package org.sky.x.concurrent.thread;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

import java.util.ArrayList;

/**
 * @author xieming 2013-10-17 ����09:32:56
 */
public class Bounce {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new BounceFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class BounceFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2976655801917611901L;
	private BallComponent comp;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	public static final int STEPS = 1000;
	public static final int DELAY = 5;

	/**
	 * �������ܣ����⣬��С��λ�õ� ���ð�ť�͵���¼�
	 */
	public BounceFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Bounce");
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "start", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addBall();
			}
		});
		addButton(buttonPanel, "close", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
	}

	/**
	 * click start? what happened?
	 * 
	 * @param c
	 * @param title
	 * @param listener
	 */
	public void addButton(Container c, String title, ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}

	/**
	 * ����С�򣬼��޸ĺ󰴶��̴߳���
	 */
	public void addBall() {
		Ball ball = new Ball();
		comp.add(ball);
		Runnable r = new BallRunnable(ball, comp);
		Thread t = new Thread(r);
		t.start();
		// for(int i=1;i<STEPS;i++){
		// //С���ƶ�
		// ball.move(comp.getBounds());
		// //�����ػ�
		// comp.paint(comp.getGraphics());
		// try {
		// //�ӳ�3s
		// Thread.sleep(DELAY);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
	}
}

class BallRunnable implements Runnable {
	private Ball ball;
	private Component component;
	public static final int STEPS = 1000;
	public static final int DELAY = 5;

	public BallRunnable(Ball ball, Component component) {
		this.ball = ball;
		this.component = component;
	}

	public void run() {
		for (int i = 1; i < STEPS; i++) {
			ball.move(component.getBounds());
			component.repaint();
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class BallComponent extends JPanel {

	private ArrayList<Ball> balls = new ArrayList<Ball>();

	public void add(Ball b) {
		balls.add(b);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Ball b : balls) {
			g2.fill(b.getShape());
		}
	}
}

class Ball {

	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;

	public void move(Rectangle2D bounds) {
		x += dx;
		y += dy;
		if (x < bounds.getMinX()) {
			x = bounds.getMaxX();
			dx = -dx;
		}
		if (x + XSIZE >= bounds.getMaxX()) {
			x = bounds.getMaxX() - XSIZE;
			dx = -dx;
		}
		if (y < bounds.getMinY()) {
			y = bounds.getMaxY();
			dy = -dy;
		}
		if (y + YSIZE >= bounds.getMaxY()) {
			y = bounds.getMaxY() - YSIZE;
			dy = -dy;
		}
	}

	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}
}
