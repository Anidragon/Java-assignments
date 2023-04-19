import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.awt.Rectangle;
public class Balls extends JComponent {
	
	private Ellipse2D.Double dodgeBall = new Ellipse2D.Double(0,0,30,30);
	
	private int dx; 
	private int dy;
	private Rectangle bounds;
	private boolean colorizer;

	public Balls(int x, int y, boolean color) {
		setSize(new Dimension(31,31));
		setLocation(x,y);
		setFocusable(false);
		colorizer = color;
		bounds = this.getBounds();
	}
	
	
	
	public void paintComponent(Graphics g)
	{
		if(colorizer)
		{
		Graphics2D g2 = (Graphics2D) g;
		Color color = Color.red;
		
		g2.setColor(color);
		g2.fill(dodgeBall);
		g2.draw(dodgeBall);
		}
		if(!colorizer)
		{
		Graphics2D g2 = (Graphics2D) g;
		Color color = Color.blue;
		
		g2.setColor(color);
		g2.fill(dodgeBall);
		g2.draw(dodgeBall);
		}
		
}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public void update() {
		this.setLocation(this.getX() + dx, this.getY() + dy);
		bounds = this.getBounds();
	}
	public Rectangle getbounds()
	{
		return bounds;
	}
}