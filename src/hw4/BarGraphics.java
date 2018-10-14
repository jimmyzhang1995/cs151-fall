package hw4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.abs;

public class BarGraphics extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTextField tf3;
	private JTextField tf1;
	private JTextField tf2;
	private boolean b = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarGraphics frame = new BarGraphics();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BarGraphics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNum1 = new JLabel("Number 1:");
		lblNum1.setBounds(46, 39, 61, 14);
		contentPane.add(lblNum1);

		JLabel lblNum2 = new JLabel("Number 2:");
		lblNum2.setBounds(46, 69, 61, 14);
		contentPane.add(lblNum2);

		JLabel lblNum3 = new JLabel("Number 3:");
		lblNum3.setBounds(46, 103, 61, 14);
		contentPane.add(lblNum3);
		
		tf1 = new JTextField();
		tf1.setBounds(117, 36, 86, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(117, 66, 86, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setBounds(117, 97, 86, 20);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		JButton btnGraphics = new JButton("Graphing");
		btnGraphics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				b = true;
				repaint();
			}
		});
		btnGraphics.setBounds(45, 138, 107, 37);
		contentPane.add(btnGraphics);
		addMouseListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (b == true) {
			String s1 = tf1.getText();
			String s2 = tf2.getText();
			String s3 = tf3.getText();
			try {
				int v1 = Integer.parseInt(s1);
				int v2 = Integer.parseInt(s2);
				int v3 = Integer.parseInt(s3);
				int higher = returnHigher(v1, v2, v3);

				int largo1 = v1 * 400 / higher;
				int largo2 = v2 * 400 / higher;
				int largo3 = v3 * 400 / higher;

				g.setColor(new Color(255, 0, 0));
				g.fillRect(100, 250, largo1, 40);
				g.drawString("Number 1", 10, 270);

				g.setColor(new Color(0, 128, 0));
				g.fillRect(100, 300, largo2, 40);
				g.drawString("Number 2", 10, 320);

				g.setColor(new Color(0, 0, 255));
				g.fillRect(100, 350, largo3, 40);
				g.drawString("Number 3", 10, 370);
			} catch (Exception e) {
				return;
			}
		}
	}

	private int returnHigher(int v1, int v2, int v3) {
		if (v1 > v2 && v1 > v3)
			return v1;
		else if (v2 > v3)
			return v2;
		else
			return v3;
	}

	private void ClickGraphics(int x) {
		String s1 = tf1.getText();
		String s2 = tf2.getText();
		String s3 = tf3.getText();

		int v1 = Integer.parseInt(s1);
		int v2 = Integer.parseInt(s2);
		int v3 = Integer.parseInt(s3);
		int higher = returnHigher(v1, v2, v3);

		if (higher > x) {
			int d = abs(higher - x - 100);
			v1 -= d;
			v2 -= d;
			v3 -= d;
		} else {
			int d = abs(higher + x + 100);
			v1 += d;
			v2 += d;
			v3 += d;
		}
		tf1.setText(String.valueOf(v1));
		tf2.setText(String.valueOf(v2));
		tf3.setText(String.valueOf(v3));
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//System.out.println("Click " + e.getX());
//ClickGraphics(e.getX());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Pressed " + e.getX());
		if (b)
			ClickGraphics(e.getX());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
