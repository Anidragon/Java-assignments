import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CloseAcount extends JPanel{

	public CloseAcount(ArrayList<BankAccount> arr){
	
	Dashboard dash = new Dashboard();
	
	this.setVisible(true);
	this.setBounds(20,20,500,350);
	this.setLayout(new GridBagLayout());
	this.setName("User Info");
	this.setVisible(true);
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	gbc.gridy = 0;
	gbc.gridx = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	JTextField name = new JTextField();
	name.setText("enter your name here");
	add(name, gbc);
	
	gbc.gridx = 1;
	JTextField accNum = new JTextField();
	accNum.setText("accountNumber");
	add(accNum, gbc);
	
	gbc.gridx = 2;
	JButton button = new JButton("Close This Account");
	add(button, gbc);
	
	
	 button.addActionListener(new ActionListener() {

		
		public void actionPerformed(ActionEvent e) {
			BankAccount deleted = null;
		try
		{
			deleted = BankAccountMain.findAccByNumber(Integer.parseInt(accNum.getText()), arr);
			
			if(deleted.equals(null))
			{
				Exception e2 = new NullPointerException();
				throw e2;
			}
			
			
			else if(name.getText() == null || !(name.getText().equals(deleted.getName().replaceAll("_", " "))))
			{
				Exception e2 = new NullPointerException();
				throw e2;
			}
			
			int confirm = JOptionPane.showConfirmDialog(null, "Are you Sure you want to close that account?");
			if(confirm == 0)
			{
			arr.remove(deleted);
			dash.accountWriter(arr);
			accNum.setText("accountNumber");
			name.setText("enter your name here");
			JOptionPane.showMessageDialog(null, "account closed");
			}
			else if (confirm == 1)
			{
				accNum.setText("accountNumber");
				name.setText("enter your name here");
			}
			
			
			
		}
		
		catch(Exception e1)
		{
			
		JOptionPane.showMessageDialog(null , "your account number or name is not valid try again");
		
		}
		
		
		
		}
		
		
       
       
      });
	}
	
	
	}
	
	
	
	
	

