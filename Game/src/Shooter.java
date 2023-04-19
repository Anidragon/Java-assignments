import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.JComponent;
import java.awt.Rectangle;
public class Shooter extends JComponent {


	private Rectangle2D.Double square = new Rectangle2D.Double(0,0,40,40);

	private boolean colorizer;
	public int dx;
	public int dy;
	Rectangle bounds;


	public Shooter(int x, int y, boolean color) 
	{
		colorizer = color;
		setSize(50,100);
		setLocation(x,y);
		setFocusable(false);
		dx = 0;
		dy = 0;
		bounds = getBounds();
	}


	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		
		g2.draw(square);
		if (colorizer) 
			{
			g2.setColor(Color.red);
			}
		else if (!colorizer) 
			{
			g2.setColor(Color.blue);
			}
	
		
		
		g2.fill(square);
		
		
	}
	
	public void setDx(int dx) {
		this.dx = dx;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public void update() {
		this.setLocation(this.getX() + dx, this.getY() + dy);
		bounds = getBounds();
	}

}