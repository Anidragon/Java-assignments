import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Transfer extends JPanel {

	public Transfer(ArrayList<BankAccount> arr)
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
		JTextField accNum1 = new JTextField();
		accNum1.setText("acount number to withdraw");
		add(accNum1, gbc);
		
		gbc.gridx = 1;
		JTextField accNum2 = new JTextField();
		accNum2.setText("accountNumber to deposit");
		add(accNum2, gbc);
		
		
		gbc.gridy++;
		gbc.gridx = 1;
		JButton button = new JButton("Transfer");
		add(button, gbc);	
		
		gbc.gridx = 0;
		JTextField amt = new JTextField();
		amt.setText("amount");
		add(amt, gbc);
		
		 button.addActionListener(new ActionListener() {

				
				public void actionPerformed(ActionEvent e) 
				{
				
				
				     BankAccount account1 = null;
				     BankAccount account2 = null;
				    boolean bool = false;
				try
				{
				     account1 = BankAccountMain.findAccByNumber(Integer.parseInt(accNum1.getText()), arr);
				     account2 = BankAccountMain.findAccByNumber(Integer.parseInt(accNum2.getText()), arr);
				     double swap = Double.parseDouble(amt.getText());
				     if(swap <= 0)
				     {
				    	 Exception e3 = new Exception();
				    			 throw e3;
				     }
				     
				     if(account1.equals(null) || account2.equals(null))
				     {
				    	 Exception e3 = new Exception();
		    			 throw e3; 
				     }
				     try
				     {
				    	 account1.withdraw(swap);
				    	 account2.deposit(swap);
				    	 dash.accountWriter(arr);
				    	 bool = true;
				     }
				     
				     catch(Exception e2)
				     {
				    	 JOptionPane.showMessageDialog(null, "withdraw amount is more than the balance of withdrawing account" );
				     }
				}
				
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, "amount or account numbers are not valid");
				}
				     
				if(bool)
				{
					JOptionPane.showMessageDialog(null, "amount was transfered " + account1.getBalance() + "$ is in withdrawn account, and " + account2.getBalance() + "$ is in deposited account ");
					accNum1.setText("acount number to withdraw");
					accNum2.setText("accountNumber to deposit");
					amt.setText("amount");
					
				}
					
					
				     
				}
				
				
		       
		       
		      });
		
		
	}
	
	
	
}
