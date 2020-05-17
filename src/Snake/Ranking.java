package Snake;


import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
 


public class Ranking extends JPanel 
{
	

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 200, HEIGHT = 200;
	public static int[] kolejneWyniki = new int[5];
	Scanner scan;
	
	public Ranking(int WIDTH,int HEIGH)
	{ 
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT)); 
		
		odczyt();
		
		repaint(); 
	}
	
	public void odczyt() {
		
		try {
			scan = new Scanner(new File("wyniki.txt"));
		}catch(FileNotFoundException e) {
			System.out.print("Nie dziala");
		}
		int i = 0;
		
		do {
			kolejneWyniki[i]=scan.nextInt();
			
			i++;

		}while (scan.hasNext() && i<5);
		scan.close();
        
    }
	
	public void paint(Graphics g) 
	{
		
		Arrays.sort(kolejneWyniki);
		String[] konwer = new String[5];
		for(int i = 0; i<5; i++)
		{
		konwer[i] = ""+kolejneWyniki[i];
		Arrays.toString(kolejneWyniki);
		}
		
		g.drawString("Ranking graczy :", 10, 15);
		g.drawString("Gracz 1:", 10, 40);
		g.drawString(konwer[0],80,40);
		g.drawString("Gracz 2:", 10, 60);
		g.drawString(konwer[1],80,60);
		g.drawString("Gracz 3:", 10, 80);
		g.drawString(konwer[2],80,80);
		g.drawString("Gracz 4:", 10, 100);
		g.drawString(konwer[3],80,100);
		g.drawString("Gracz 5:", 10, 120);
		g.drawString(konwer[4],80,120);
		
	}
}
	
