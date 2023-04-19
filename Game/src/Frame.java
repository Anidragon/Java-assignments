import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Rectangle;
import java.awt.Toolkit;
public class Frame extends JComponent{
	private Insets insets;

	
	public Frame (Rectangle rectangle, Insets inseters) {
		setBounds(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
		setFocusable(false);
		insets = inseters;

	}
	
	

}
