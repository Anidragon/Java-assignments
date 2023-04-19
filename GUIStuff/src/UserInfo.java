import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserInfo extends JPanel {
	ArrayList<String> indexStorage = new ArrayList<String>();
	public UserInfo(ArrayList<BankAccount> arr)
	{
		
		Dashboard dash = new Dashboard();
		
		this.setVisible(true);
		this.setBounds(20,20,500,350);
		this.setLayout(new GridBagLayout());
		this.setName("User Info"); 
		this.setVisible(true);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JButton find = new JButton("Find");
		find.setPreferredSize(new Dimension(150,20));
		add(find, gbc);
		
		
		gbc.gridx = 0;
		JTextField name = new JTextField();
		name.setText("enter your name here");
		add(name, gbc);
		
		gbc.gridy++;
		JTextField streetAd = new JTextField();
		streetAd.setText("Street Adress");
		streetAd.setEnabled(false);
		add(streetAd, gbc);
		
		gbc.gridx = 1;
		JTextField city = new JTextField();
		city.setText("city");
		city.setEnabled(false);
		add(city, gbc);
		
		gbc.gridx = 0;
		gbc.gridy ++;
		JTextField state = new JTextField();
		state.setText("State");
		state.setEnabled(false);
		add(state, gbc);
		
		gbc.gridx = 1;
		JTextField zip = new JTextField();
		zip.setText("Zip Code");
		zip.setEnabled(false);
		add(zip, gbc);
		
		gbc.gridx = 1;
		gbc.gridy++;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JButton edit = new JButton("Edit");
		edit.setPreferredSize(new Dimension(150,20));
		add(edit, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JButton update = new JButton("Update Info");
		update.setPreferredSize(new Dimension(150,20));
		update.setVisible(false);
		update.setEnabled(false);
		add(update, gbc);
		
		gbc.gridx++;
		JButton cancel = new JButton("Cancel");
		cancel.setPreferredSize(new Dimension(150,20));
		cancel.setVisible(false);
		cancel.setEnabled(false);
		add(cancel, gbc);
		
		
find.addActionListener(new ActionListener() {
			
	      
	        
			public void actionPerformed(ActionEvent e) 
			{
				
				
				
				
				for(BankAccount x: arr)
				{
					
					if((x.getName().replaceAll("_", " ")).equals(name.getText()))
					{
						
						int ind = arr.indexOf(x);
						streetAd.setText(arr.get(ind).getStreetAddress().replaceAll("_", " "));
						city.setText(arr.get(ind).getCity().replaceAll("_", " "));
						state.setText(arr.get(ind).getState().replaceAll("_", " "));
						zip.setText(arr.get(ind).getZipCode().replaceAll("_", " "));
						indexStorage.add(arr.indexOf(x) + "");
						indexStorage.add(0, name.getText());
					}
					
				}
				if (indexStorage.size() == 0)
				{   
					name.setText("name not found");
					indexStorage.clear();
				}
				else
				{                                                   
					if(indexStorage.get(0) != name.getText())
					{
						indexStorage.clear();
						
						for(BankAccount x: arr)
						{
							
							if((x.getName().replaceAll("_", " ")).equals(name.getText()))
							{
								
								int ind = arr.indexOf(x);
								streetAd.setText(arr.get(ind).getStreetAddress().replaceAll("_", " "));
								city.setText(arr.get(ind).getCity().replaceAll("_", " "));
								state.setText(arr.get(ind).getState().replaceAll("_", " "));
								zip.setText(arr.get(ind).getZipCode().replaceAll("_", " "));
								indexStorage.add(arr.indexOf(x) + "");
							}
						}
						if (indexStorage.size() == 0)
						{   
							name.setText("name not found");
							indexStorage.clear();
						}
						else
						{
							
							indexStorage.add(0, name.getText());
						}
						
					}
					
					
				}

				}
				
				});



edit.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) 
	{
		if(BankAccountMain.findAccByName(name.getText(), arr) != null)
		{
		streetAd.setEnabled(true);
		city.setEnabled(true);
		state.setEnabled(true);
		zip.setEnabled(true);
		name.setEnabled(false);
		update.setVisible(true);
		cancel.setVisible(true);
		update.setEnabled(true);
		cancel.setEnabled(true);
        edit.setEnabled(false);
        edit.setVisible(false);
        find.setEnabled(false);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "name does not exist");
		}
		}
		
		});

cancel.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) 
	{
		
		streetAd.setEnabled(false);
		city.setEnabled(false);
		state.setEnabled(false);
		zip.setEnabled(false);
		name.setEnabled(true);
		update.setVisible(false);
		cancel.setVisible(false);
		update.setEnabled(false);
		cancel.setEnabled(false);
		edit.setEnabled(true);
		edit.setVisible(true);
		find.setEnabled(true);
		}
		
		});

update.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) 
	{
		
		for(int i = 0 ; i < indexStorage.size() - 1 ; i++)
		{
			arr.get(Integer.parseInt(indexStorage.get(i + 1))).setState(state.getText());
			arr.get(Integer.parseInt(indexStorage.get(i + 1))).setCity(city.getText());
			arr.get(Integer.parseInt(indexStorage.get(i + 1))).setStreetAddress(streetAd.getText());
			arr.get(Integer.parseInt(indexStorage.get(i + 1))).setZipCode(zip.getText());
		}
		
		

	      
		try {
			dash.accountWriter(arr);
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		streetAd.setEnabled(false);
		city.setEnabled(false);
		state.setEnabled(false);
		zip.setEnabled(false);
		name.setEnabled(true);
		update.setVisible(false);
		cancel.setVisible(false);
		update.setEnabled(false);
		cancel.setEnabled(false);
		edit.setEnabled(true);
		edit.setVisible(true);
		find.setEnabled(true);
	    indexStorage.clear();
		
	}
	

		});

}
}
	
	

