import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class TimerDemo extends JFrame implements ActionListener 
{

	private int dx;
	private int dy;
	private boolean running;
	private Timer t;
public TimerDemo()
{
	
	dx = 3;
	dy = 3;
	running = true;
	
	this.setLayout(null);
	this.setBounds(100, 100, 600, 400);
	JButton button = new JButton(":]");
	button.setBounds(25, 25, 60, 60);
    t = new Timer(25, this);
	t.restart();
	this.add(button);
	this.setVisible(true);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	
}
	
	public static void main(String[]args)
	{
	
		TimerDemo demo = new TimerDemo();
		
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(!running)
		{
			t.start();
			running = false;
		}
		
		else
			{
			
			
			
			}
		}
		
		
		System.out.println("boom");
		
	}
	
}
