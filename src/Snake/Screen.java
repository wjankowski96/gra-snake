package Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable, KeyListener {
	

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 200, HEIGHT = 200;
	private Thread thread; // wątek
	
	private boolean running = false; // flaga uruchomienia 
	private BodyPart b; //część węża
	private ArrayList<BodyPart> snake; // wąż 
	private Apple apple; //jabłko
	private ArrayList<Apple> apples; // jabłka 
	private Random r;
	
	private int xCoor = 10, yCoor = 10; // początkowe położenie 
	private int size = 5; //początkowy rozmiar
	private int snakeSpeed = 250000 * 5; // prędkość węża
	
	// początkowy kierunek ruchu
	private boolean right = true, left = false, up = false, down = false;
	private int ticks = 0; // licznik tików

	public Screen(int WIDTH,int HEIGH) { 
	setFocusable(true);
	addKeyListener(this);
	setPreferredSize(new Dimension(WIDTH, HEIGHT)); 
	r = new Random();
	snake = new ArrayList<BodyPart>(); 
	apples = new ArrayList<Apple>(); 
	start();
	
	}
	
	//----------------
	
	public void tick() 
	{
		//jezeli nie ma weza to stworz
		
		if (snake.size() == 0) {
				
			//nowa czesc weza (x,y,rozmiar kwadratu w siatce)
				
			b = new BodyPart(xCoor, yCoor, 10); 
			
			//dodanie czesci do listy weza 
			
			snake.add(b);
		}
		
		//jezeli nie ma jablka to stworz
		if(apples.size() == 0) { 
			//losowanie wsp dla jablka
			int xCoor = r.nextInt(19); 
			int yCoor = r.nextInt(19); 
			
			//dodanie jablka
			
			apple = new Apple(xCoor, yCoor, 10);
		    apples.add(apple);
		}
		
		// sprawdzenie czy waz zjadl jablko
		//jezeli tak to zwieksz rozmiar i usun jablko 
		
		for(int i = 0; i < apples.size(); i++) 
		{
			if(xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()) 
			{
			         size++;
			         apples.remove(i);
			         i++;
			} 
			
		}
		
		
		// sprawdzenie czy waz nie ugryzl ogona
		
		for(int i =0; i < snake.size(); i++) 
		{ 
			if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()) 
			{ 
				if(i != snake.size() - 1) 
				{
					stop(); 
				}
				
			}
		}
	
	
		// sprawdzenie czy wąż wszedł w ścianę
		if(xCoor<0||xCoor>19||yCoor<0||yCoor>19)
		{
			stop();
		}

		ticks++;

		// po wykonaniu tej metody wiecej razy niż wartosc snakeSpeed 

		if(ticks > snakeSpeed) 
		{
	
			// sprawdzenie który przycisk byl wcisniety
			// dodanie lub odjecie 1 od odpowiednich wspolrzednych
	
			if(right)xCoor++;
			if(left)xCoor--;
			if(up)yCoor--;
			if(down)yCoor++; 
			
			// wyzerowanie licznika 
			
			ticks = 0;
			
			// dodawanie elementu węża dla nowych wspolrzednych
			
			b=new BodyPart(xCoor,yCoor,10);
			snake.add(b);
			snakeSpeed = snakeSpeed - 2000;
			
			// sprawdzenie czy wąż jest większy od wartości size 
			//jezeli tak to usuwana jest ostatnia czesc 
			
			if(snake.size() > size) 
				{
				snake.remove(0);
				}
		}
	}
	
	
	//----------------
	
		public void paint(Graphics g) 
		{ 
			g.clearRect(0, 0, WIDTH, HEIGHT); 
			g.setColor(Color.GREEN); 
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.BLACK);
			
			for (int i=0;i< WIDTH /10;i++)
			{
			g.drawLine(i * 10, 0, i * 10, HEIGHT); 
			}
			
			for (int i=0;i< HEIGHT /10;i++)
			{ 
				g.drawLine(0, i * 10, WIDTH, i * 10);
			}
			
			for (int i = 0; i < snake.size(); i++) 
			{ 
				snake.get(i).draw(g);
			}
			
			for(int i = 0; i < apples.size(); i++) 
			{
			    apples.get(i).draw(g);
			}
		}
	
		//----
		
		public void start() 
		{ 
			running = true;
			thread = new Thread(this);
			thread.start();
		}
		
		//--- 
		
		public void stop() 
		{
			running = false;
			setVisible(false);
			
			final Frame[] frames = Frame.getFrames(); 
			
			for (final Frame frame : frames) 
			{
				if (frame.isVisible() && frame.isActive()) 
				{ 
					frame.dispose();
				} 
			}
			
			
				try 
				{ 
					thread.join();
				} catch (InterruptedException e) {
				
					e.printStackTrace();
			    } 
		}
		
		//---- 
		
		public void run() 
		{ 		
				while (running) 
				{
					tick();
					repaint(); 
				}
		}
		
		//----
		
		@Override
		
		public void keyPressed(KeyEvent e) {
			
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_RIGHT && !left) {
				up = false; 
				down = false; 
				right = true;
			
			}
			
			if(key == KeyEvent.VK_LEFT && !right) {
				up = false; 
				down = false; 
				left = true;
			}
			
			if(key == KeyEvent.VK_UP && !down) {
				left = false; 
				right = false; 
				up = true;
			}
			
			if(key == KeyEvent.VK_DOWN && !up) {
				left = false; 
				right = false; 
				down = true;
			}
			
		}
		
		//---- 
		
		@Override
		
		public void keyReleased(KeyEvent arg0) {
			
		}
		public void keyTyped(KeyEvent arg0) {
		}
		
		
	
//-------------- koniec	
}	
	
