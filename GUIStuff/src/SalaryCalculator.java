import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryCalculator {

	public static void main(String[] args) {
	    
		JFrame myFrame = new JFrame("Salary Calculator");
		myFrame.setBounds(300, 300, 300, 300);
		//creates a JFrame object with 300/300 dimensions
		//allows you to work directly in pixel coordinates
		JLabel HoursRate = new JLabel("Hourly Rate");
		HoursRate.setBounds(25, 25, 150, 50);
		JLabel HoursRateperWeek = new JLabel("Hours/Week");
		HoursRateperWeek.setBounds(25, 0, 150, 50);
		JLabel FullTime = new JLabel("Full Time");
	    FullTime.setBounds(48, 54, 150, 50);
		JButton Calculate = new JButton("Calculate");
		Calculate.setBounds(25, 100, 100, 25);
		JTextField Input1 = new JTextField();
		Input1.setBounds(100, 15, 150, 20);
		JTextField Input2 = new JTextField();
		Input2.setBounds(100, 40, 150, 20);
		JCheckBox Check = new JCheckBox();
		Check.setBounds(25, 70, 20, 20);
		JLabel result = new JLabel("Salary/year:");
		
		result.setBounds(150, 60, 500, 100);
		
		
		Check.addActionListener(new MyListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(Check.isSelected())
				{
				Input1.setText("40");
				Input1.setEnabled(false);
				}
				else
				{
					Input1.setText("");
					Input1.setEnabled(true);
				}
				
			}
		});
		
		Calculate.addActionListener(new MyListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				double HW = Double.parseDouble(Input1.getText());
				double HM = Double.parseDouble(Input2.getText()); 
				double z = HW*HM;
				double Final = z * 52;
				
				result.setText("Salary/year: $" + Final);
			}
		});
		myFrame.add(result);
		myFrame.add(Calculate);
		myFrame.add(Input1);
		myFrame.add(Input2);
		myFrame.add(Check);
		myFrame.add(FullTime);
		myFrame.add(HoursRateperWeek);
		myFrame.add(HoursRate);
		myFrame.setLayout(null);//allows movement
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
