package Snake;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Menu extends JFrame {

	// private JPanel contentPane;
	
	private static final long serialVersionUID = 1L; private JPanel contentPane;
	private static final int WIDTH = 200, HEIGHT = 220;

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

	/**
	 * Create the frame.
	 */
	
	

	
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame game = new JFrame();
				Screen screen = new Screen( WIDTH, HEIGHT ) ; 
				game.getContentPane().add(screen); 
				game.setUndecorated(true); 
				game.setResizable(false); 
				game.pack(); 
				game.setLocationRelativeTo(null); 
				game.setVisible(true);
			}
		});
		
		btnNewButton.setBackground(new Color(238, 238, 238));
		btnNewButton.setFont(new Font("Bangla Sangam MN", Font.BOLD, 24));
		contentPane.add(btnNewButton, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnNewButton_1.setFont(new Font("Gurmukhi Sangam MN", Font.BOLD, 24));
		contentPane.add(btnNewButton_1, BorderLayout.CENTER);
		
		JButton btnNewButton_2 = new JButton("Ranking");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_2, BorderLayout.EAST);
		

		JFrame menu = new JFrame(); 
		menu.setUndecorated(true);
		menu.setFocusable(true);
		menu.setPreferredSize(new Dimension(WIDTH, HEIGHT)); menu.setResizable(false);
		menu.pack(); menu.setLocationRelativeTo(null); menu.setVisible(true);
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		
	}

}