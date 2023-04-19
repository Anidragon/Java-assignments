


	import java.awt.Dimension;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.ArrayList;

	import javax.swing.JButton;
    import javax.swing.JCheckBox;
    import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextField;

	
	public class AddAccount extends JPanel {
		String Classboi = "X";
		ArrayList<BankAccount> Saver = new ArrayList<BankAccount>();
		ArrayList<Integer> indexStorage = new ArrayList<Integer>();
		public AddAccount(ArrayList<BankAccount> arr)
		{
			
			Dashboard dash = new Dashboard();
			
			this.setVisible(true);
			this.setBounds(20,20,500,350);
			this.setLayout(new GridBagLayout());
			this.setName("User Info");
			this.setVisible(true);
			GridBagConstraints gbc = new GridBagConstraints();
			
			
			
			gbc.gridx = 0;
        	gbc.fill = GridBagConstraints.HORIZONTAL;
			JTextField name = new JTextField();
			name.setText("enter your name here");
			add(name, gbc);
			
			gbc.gridx = 1;
			JTextField streetAd = new JTextField();
			streetAd.setText("Street Adress");
			
			add(streetAd, gbc);
			
			gbc.gridy = 1;
			JTextField city = new JTextField();
			city.setText("city");
			
			add(city, gbc);
			
			gbc.gridx = 0;
			JTextField state = new JTextField();
			state.setText("State");
			
			add(state, gbc);
			
			gbc.gridy++;
			JTextField zip = new JTextField();
			zip.setText("Zip Code");
			
			add(zip, gbc);
			
			
			
			gbc.gridx++;
			JButton create = new JButton("Create");
			create.setPreferredSize(new Dimension(150,20));
			add(create, gbc);
			
			gbc.gridy++;
			JCheckBox C = new JCheckBox("Checking Account");
			add(C, gbc);
			
			gbc.gridx--;
			JCheckBox S = new JCheckBox("Savings Account");
			add(S, gbc);
			
			
C.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) 
				{
					Classboi = "C";
					S.setSelected(false);
				}
				
});

S.addActionListener(new ActionListener() {
	
	
	public void actionPerformed(ActionEvent e) 
	{
		Classboi = "S";
		C.setSelected(false);
	}
	
});
			
			create.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) 
				{
					
					boolean mybool = false;
					boolean checker = true;
					for(BankAccount x: arr)
					{
						
						if(x.getName().equals(name.getText()))
						{
							Saver.add(x);
							mybool = true;
							break;
						}
						
					}
					
					
					if(mybool)
					{
						if(Saver.get(0).getStreetAddress().replaceAll("_", " ").equals(streetAd.getText()) && Saver.get(0).getCity().replaceAll("_", " ").equals(city.getText()) && Saver.get(0).getState().replaceAll("_", " ").equals(state.getText()) && Saver.get(0).getZipCode().replaceAll("_", " ").equals(zip.getText()))
						{
							if(Classboi.equals("C"))
							{
								CheckingAccount C = new CheckingAccount(name.getText(), streetAd.getText(), city.getText(), state.getText(), 0, zip.getText());
								arr.add(C);
							}
							
							else if(Classboi.equals("S"))
							{
								
						SavingsAccount S = new SavingsAccount(name.getText(), streetAd.getText(), city.getText(), state.getText(), 0, zip.getText());
								arr.add(S);
							}
							else if(Classboi.equals("X"))
							{
								JOptionPane.showMessageDialog(null, "did not select type for account");
								checker = false;
							}
					if(checker)
					{
						try {
							
							dash.accountWriter(arr);
							name.setText("enter your name here");
							zip.setText("Zip Code");
							streetAd.setText("Street Adress");
							state.setText("State");
							city.setText("city");
							JOptionPane.showMessageDialog(null, "account created");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "your account information does not match please update");
							checker = false;
						}
					}
					
					
					else
					{
						if(Classboi.equals("C"))
						{
							CheckingAccount C = new CheckingAccount(name.getText(), streetAd.getText(), city.getText(), state.getText(), 0, zip.getText());
							arr.add(C);
						}
						
						else if(Classboi.equals("S"))
						{
							SavingsAccount S = new SavingsAccount(name.getText(), streetAd.getText(), city.getText(), state.getText(), 0, zip.getText());
							arr.add(S);
						}
						else if(Classboi.equals("X"))
						{
							JOptionPane.showMessageDialog(null, "did not select type for account");
							checker = false;
						}
					}
					if(checker)
					{
					try {
						dash.accountWriter(arr);
						name.setText("enter your name here");
						zip.setText("Zip Code");
						streetAd.setText("Street Adress");
						state.setText("State");
						city.setText("city");
						JOptionPane.showMessageDialog(null, "account created");
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				
					}
				}
				});
			

	
}
	}
