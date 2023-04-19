import javax.swing.JFrame;

public class StickMain extends JFrame {

	public StickMain()
	{
		this.setBounds(100, 100, 700, 500);
		this.setTitle("StickFig");
		this.setLayout(null);
		Stick human = new Stick(50, 50);
		this.add(human);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) 
	
	{
		new StickMain();

	}

}
