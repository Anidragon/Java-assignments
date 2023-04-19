import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Stick extends JComponent {

	
	private Ellipse2D.Double head;
	private Rectangle torso;
	private Rectangle leftArm;
	private Rectangle rightArm;
	private Rectangle leftLeg;
	private Rectangle rightLeg;
	
	public Stick(int x , int y)
	{
		
		this.setLocation(x, y);
		this.setSize(30, 60);
		head = new Ellipse2D.Double(10, 0, 10, 10);
		torso = new Rectangle(10, 10, 10, 30);
		leftArm = new Rectangle(0, 10, 10, 5);
		rightArm = new Rectangle(20, 10, 10, 5);
		rightLeg = new Rectangle(0, 35, 10, 25);
		leftLeg = new Rectangle(20, 35, 10, 25);
		
	}
	public void paintComponenet(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		g2.draw(head);
		g2.draw(leftArm);
		g2.draw(leftLeg);
		g2.draw(rightLeg);
		g2.draw(rightArm);
		g2.draw(torso);
	}
}
