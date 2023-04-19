import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class Dodgeball extends JFrame implements ActionListener {
	

	
	private Insets insets;
	private Rectangle rectangle;
	
	private Shooter p1;
	private Shooter p2;
	
	private ArrayList<Balls> p1Balls = new ArrayList<Balls>();
	private ArrayList<Balls> p2Balls = new ArrayList<Balls>();
	
	
	private boolean ualive1;
	private boolean ualive2;
	
	private Frame frame;
	private boolean enabler = true;
	private boolean allower = true;
	private boolean allower2 = true;
	private boolean enabler2 = true;
	private boolean shielded = false;
	private boolean shielded2 = false;

	public Dodgeball() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		
		setTitle("Dodgeball");
		setLayout(null);
		p1 = new Shooter(100, getHeight()/2,true);
		p2 = new Shooter(getWidth() - 100, getHeight()/2,false);
		rectangle = this.getBounds();
		
		ualive1 = false;
		
		ualive2 = false;
		
	

		
		
		this.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent e) 
			
			{
				
			}
		
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_SPACE) 
				{
				int result = JOptionPane.showConfirmDialog(null, "Game paused press ok to continue or cancel to exit", "paused", JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.CANCEL_OPTION)
				{
					System.exit(0);
				}
				
				}
				
				if(e.getKeyCode() == e.VK_F && allower) 
				{
					enabler = false;
					shielded = true;
					allower = false;
				}	
				
				if (enabler) 
				{
					if(e.getKeyCode() == e.VK_W) 
					{
						p1.setDy(-7);
						allower = true;
					}
					if(e.getKeyCode() == e.VK_S) 
					{
						p1.setDy(7);
						allower = true;
					}
					if(e.getKeyCode() == e.VK_A) 
					{
						p1.setDx(-7);
						allower = true;
					}
					if(e.getKeyCode() == e.VK_D) 
					{
						p1.setDx(7);
						allower = true;
					}
					
					if(e.getKeyCode() == e.VK_E) 
					{
						if (p1Balls.size() < 3) 
						{
							p1Balls.add(new Balls(p1.getX(), p1.getY(), true));
						
							p1Balls.get(p1Balls.size()-1).setDx(15);

						}
					}
				}
					
					if(enabler2)
					{
						if(e.getKeyCode() == e.VK_ALT && allower2) 
						{
							enabler2 = false;
							shielded2 = true;
							allower2 = false;
						}
						
					if(e.getKeyCode() == e.VK_UP) 
					{
						p2.setDy(-7);
						allower2 = true;
					}
					if(e.getKeyCode() == e.VK_DOWN) 
						{
						p2.setDy(7);
						allower2 = true;
						}
					if(e.getKeyCode() == e.VK_LEFT) 
						{
						p2.setDx(-7);
						allower2 = true;
						}
					if(e.getKeyCode() == e.VK_RIGHT) 
					{
						p2.setDx(7);
						allower2 = true;
					}
					
					if(e.getKeyCode() == e.VK_CONTROL) 
					{
						
						if (p2Balls.size() < 3) 
						{
							p2Balls.add(new Balls(p2.getX(),p2.getY(), false));
						
							p2Balls.get(p2Balls.size()-1).setDx(-15);

						}
					}
				}
			
			}
			
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode()== e.VK_F)
				{
					enabler = true;
					shielded = false;
				}
				
				if(e.getKeyCode()== e.VK_ALT)
				{
					enabler2 = true;
					shielded2 = false;
				}
				
				if(e.getKeyCode() == e.VK_W) 
					p1.setDy(0);
				if(e.getKeyCode() == e.VK_S) 
					p1.setDy(0);
				if(e.getKeyCode() == e.VK_A) 
					p1.setDx(0);
				if(e.getKeyCode() == e.VK_D) 
					p1.setDx(0);
				
				if(e.getKeyCode() == e.VK_UP) 
					p2.setDy(0);
				if(e.getKeyCode() == e.VK_DOWN) 
					p2.setDy(0);
				if(e.getKeyCode() == e.VK_LEFT) 
					p2.setDx(0);
				if(e.getKeyCode() == e.VK_RIGHT) 
					p2.setDx(0);
			}
		});
		
		add(p1);
		add(p2);
		insets = this.getInsets();
		frame = new Frame(rectangle,insets);
		

		add(frame);
		setVisible(true);
		Timer move = new Timer(15,this);
		move.start();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	
	public static void main(String[] args) {
		new Dodgeball();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
			if ((p1.getX() + p1.getWidth() > ((this.getWidth() - insets.right - insets.left - p1.getWidth()))) || p1.getX() < 0) 
			{
				p1.setDx(0);
				int corrector;
				if (p1.getX() < 0) 
				{
					corrector = 3; 
				}
				
				else
				{
					corrector = -3;
				}
				p1.setLocation(p1.getX() + corrector, p1.getY());
			}
			
			if ((p1.getY() + p1.getHeight() > this.getHeight() - insets.top - insets.bottom) || p1.getY() < 0)
			{
				p1.setDy(0);
				int corrector;
				if (p1.getY() < 0) 
				{
					corrector = 3; 
				}
				
				else
				{
					corrector = -3;
				}
				p1.setLocation(p1.getX(), p1.getY() + corrector);
			}
			
		
			
			if ((p2.getX() + p2.getWidth() > ((this.getWidth() - insets.right - insets.left - p2.getWidth()))) || p2.getX() < 0) 
			{
				p2.setDx(0);
				int corrector;
				if (p2.getX() < 0) 
				{
					corrector = 3; 
				}
				
				else
				{
					corrector = -3;
				}
				p2.setLocation(p2.getX() + corrector, p2.getY());
			}
			
			if ((p2.getY() + p2.getHeight() > this.getHeight() - insets.top - insets.bottom) || p2.getY() < 0)
			{
				p2.setDy(0);
				int corrector;
				if (p2.getY() < 0) 
				{
					corrector = 3; 
				}
				
				else
				{
					corrector = -3;
				}
				p2.setLocation(p2.getX(), p2.getY() + corrector);
			}
		
		p1.update();
		p2.update();

		
		if (p1Balls.size() > 0) 
		for (int i = 0; i < p1Balls.size(); i++) {
			this.add(p1Balls.get(i));
			remove(frame);
			add(frame);

			
			p1Balls.get(i).update();
			
			if (p1Balls.size() > 0 && p1Balls.get(i).getbounds().intersects(p2.bounds)) 
			{
				if(shielded2)
				{
					ualive1 = false;
					shielded2 = false;
					this.remove(p1Balls.get(i));
					p1Balls.remove(i);
					
				}
				
				else
					
				{
					
				ualive1 = true;

				this.remove(p1Balls.get(i));
				p1Balls.remove(i);
				
				}
			}

			if (p1Balls.size() > 0 && !rectangle.intersects(p1Balls.get(i).getbounds())) 
			{
				this.remove(p1Balls.get(i));
				p1Balls.remove(i);
				i--;
			}
		}
		
		if (p2Balls.size() > 0)
		for (int i = 0; i < p2Balls.size(); i++) 
		{
			this.add(p2Balls.get(i));
			remove(frame);
			add(frame);
		
			p2Balls.get(i).update();
			
			if (p2Balls.size() > 0 && p2Balls.get(i).getbounds().intersects(p1.bounds)) 
			{
				if(shielded)
				{
					ualive2 = false;
					shielded = false;
					this.remove(p2Balls.get(i));
					p2Balls.remove(i);
				}
				else
				{
				ualive2 = true;
				this.remove(p2Balls.get(i));
				p2Balls.remove(i);
				}
			}
			
			if (p2Balls.size() > 0 && !rectangle.intersects(p2Balls.get(i).getbounds())) {
				this.remove(p2Balls.get(i));
				p2Balls.remove(i);
				i--;
			}
		}
		
		
	
			if (ualive1) 
			{
				for (int i = 0; i < p1Balls.size(); i++) 
				{
				if (p1Balls.size() > 0 && rectangle.intersects(p1Balls.get(i).getbounds())) 
				{
					this.remove(p1Balls.get(i));
					p1Balls.remove(i);
					i--;
				}
				}
				
				for (int i = 0; i < p2Balls.size(); i++) 
				{
				if (p2Balls.size() > 0 && rectangle.intersects(p2Balls.get(i).getbounds())) 
				{
					this.remove(p2Balls.get(i));
					p2Balls.remove(i);
					i--;
				}
				}
				
				int a = JOptionPane.showConfirmDialog(null, "Player 1 Wins, wanna keep playing?", ":]", JOptionPane.YES_NO_OPTION);
				
				if(a == 0)
				{
					
				ualive1 = false;
				p1Balls.clear();
				p2Balls.clear();
				for (int i = 0; i < p2Balls.size(); i++) 
				{
					this.remove(p2Balls.get(i));
					i--;
					
				}
				
				for (int i = 0; i < p1Balls.size(); i++) 
				{
					this.remove(p1Balls.get(i));
					i--;
					
				}
				enabler = true;
				 allower = true;
				 allower2 = true;
				 enabler2 = true;
				 shielded = false;
				 shielded2 = false;
				}
				
				else
				{
					System.exit(0);
				}
			}
		
	
			
			if (ualive2) 
			{
				for (int i = 0; i < p1Balls.size(); i++) 
				{
				if (p1Balls.size() > 0 && rectangle.intersects(p1Balls.get(i).getbounds())) 
				{
					this.remove(p1Balls.get(i));
					p1Balls.remove(i);
					i--;
				}
				}
				
				for (int i = 0; i < p2Balls.size(); i++) 
				{
				if (p2Balls.size() > 0 && rectangle.intersects(p2Balls.get(i).getbounds())) 
				{
					this.remove(p2Balls.get(i));
					p2Balls.remove(i);
					i--;
				}
				}
				
			    int a = JOptionPane.showConfirmDialog(null, "Player 2 Wins, wanna keep playing?", ":]", JOptionPane.YES_NO_OPTION);
			    
				if(a == 0)
				{
				ualive2 = false;
				p1Balls.clear();
				p2Balls.clear();
				
				for (int i = 0; i < p2Balls.size(); i++) 
				{
					this.remove(p2Balls.get(i));
					i--;
					
				}
				
				for (int i = 0; i < p1Balls.size(); i++) 
				{
					this.remove(p1Balls.get(i));
					i--;
					
				}
				 enabler = true;
				 allower = true;
				 allower2 = true;
				 enabler2 = true;
				 shielded = false;
				 shielded2 = false;
				 
				}
				
				else
				{
					System.exit(0);
				}
			}
			
		}
	}

