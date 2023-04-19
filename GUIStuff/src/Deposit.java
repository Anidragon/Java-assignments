import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Deposit extends JPanel {

	public Deposit(ArrayList<BankAccount> arr)
	{
		
		
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
		JTextField amt = new JTextField();
		amt.setText("enter amount to deposit");
		add(amt, gbc);
		
		gbc.gridx = 1;
		JTextField accNum = new JTextField();
		accNum.setText("accountNumber");
		add(accNum, gbc);
		
		gbc.gridx = 2;
		JButton button = new JButton("Deposit");
		add(button, gbc);	
		
		
		 button.addActionListener(new ActionListener() {

				
				public void actionPerformed(ActionEvent e) {
					boolean bool = false;
					BankAccount acc = null;
			double amount = 0;
				try
				{
					amount = Double.parseDouble(amt.getText());
					 acc = BankAccountMain.findAccByNumber(Integer.parseInt(accNum.getText()), arr);
					if(acc == null)
					{
						Exception e2 = new Exception();
						throw e2;
					}
					acc.deposit(amount);
					dash.accountWriter(arr);
					accNum.setText("accountNumber");
					amt.setText("enter amount to deposit");
					bool = true;
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "amount or account number is not valid");
					
				}
				if(bool)
				{
					JOptionPane.showMessageDialog(null, "deposit was made, your new balance is: " + acc.getBalance());
				}
				
				}
				
				
		       
		     });
		
		
		
	}
	
}
