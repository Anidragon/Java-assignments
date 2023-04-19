import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class GetAccountInfo extends JPanel {

	
	public GetAccountInfo(ArrayList<BankAccount> arr)
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
		JTextField name = new JTextField();
		name.setText("enter name");
		add(name, gbc);
		
		gbc.gridy = 1;
		JTextArea acc = new JTextArea (5, 35);
	    acc.setEditable ( false ); 
	    JScrollPane scroll = new JScrollPane (acc);
	    scroll.setViewportView(acc);
        scroll.setWheelScrollingEnabled(true);

		add(scroll, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		JButton button = new JButton("Search");
		add(button, gbc);	
		
		
		
		
		 button.addActionListener(new ActionListener() {

				
				public void actionPerformed(ActionEvent e) {
					ArrayList<BankAccount> accStorage = new ArrayList<BankAccount>();
					boolean bool = false;
					String add = "";
					acc.selectAll();
					acc.replaceSelection("");
					try
					{
						
						accStorage = BankAccountMain.findAccByName(name.getText(), arr);
						if(accStorage.equals(null) || accStorage.size() == 0)
						{
							Exception e3 = new Exception();
							throw e3;
						}
						bool = true;
						
					}
					
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "name was not found");
						name.setText("enter name");
						bool = false;
					}
					
					if(bool)
					{
						acc.setVisible(true);
						for(BankAccount x : accStorage)
						{
						
							if(x instanceof CheckingAccount)
							{
						   add += ("account " + accStorage.indexOf(x) + ": account type: Checking Account, balance: " + x.getBalance() + ", account number: " + x.getAccountNumber()+"\n");
							}
							 
							else
							{
								 add += ("account " + accStorage.indexOf(x) + ": account type: Savings Account, balance: " + x.getBalance() + ", account number: " + x.getAccountNumber() + "\n");
								
							}
						
						}
						acc.setText(add);
						accStorage.clear();
					}
					
				}
				
				
		       
		     });
		
		
	}
}
