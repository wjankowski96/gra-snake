package Snake;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 200, HEIGHT = 200;

	/**
	 * Create the frame.
	 */
	public Menu() {
		JFrame menu = new JFrame();
		menu.setUndecorated(true);
		menu.setFocusable(true);
		menu.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		menu.setResizable(false);
		menu.pack();
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0,1,0, 0));
		setContentPane(contentPane);
	}

}

