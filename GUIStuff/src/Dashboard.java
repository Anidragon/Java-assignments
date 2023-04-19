import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Dashboard extends JPanel  {
	
	private String password;
	private File file = new File("accounts.txt");
	private JLabel Savings;
	private JLabel Checking;
	private JLabel deposit;
	private JLabel total;
	
	
	public Dashboard()
	
	{
		
	}
	public Dashboard(ArrayList<BankAccount> arr) throws IOException
	{
		FileNotFoundException FileNotFound = new FileNotFoundException();
		
	try
	{
		 boolean exists = file.exists();
		 if(!exists)
		 {
			 throw FileNotFound ; 
		 }
	}
	
	catch(Exception FileNotFoundException)
	{
		file.createNewFile();
	}
	password = "password";
	this.setVisible(true);
	this.setBounds(20,20,500,350);
	this.setLayout(new GridBagLayout());
	this.setName("Dash Board");
	this.setVisible(true);
	
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.gridx = 0;
	gbc.gridy = 3;
	JButton MonthUpdate = new JButton("End of Month Update");
	MonthUpdate.setPreferredSize(new Dimension(200,40));
	add(MonthUpdate, gbc);
	
MonthUpdate.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) 
		{
			int g = -1;
			String input;
			while(g < 0) {
				 input = JOptionPane.showInputDialog("Enter password");
				 try
				 {
				 if(input.equals("password"))
				 {
					 for(BankAccount x : arr)
					 {
						 x.endOfMonthUpdate();
					 }
					 g++;
					 update(arr, getC(), getS(), getT(), getD());
					 JOptionPane.showMessageDialog(null, "Correct Password, all accounts updated");
				 }
			
				 else {
					 
					 JOptionPane.showMessageDialog(null, "incorrect password");
					 g++;
				}
				 } 
				 catch(Exception e1)
				 {
					 if(!(input == null))
					 {
					 JOptionPane.showMessageDialog(null, "incorrect password");
					 }
					 g++;
				 }
			}
			
			try {
				accountWriter(arr);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			update(arr, getC(), getS(), getT(), getD());
		}
		
		});
	gbc.gridy = 0;
	
	Savings = new JLabel("Savings Accounts: " +  (countAccounts() - countCheckingAccounts()));
	add(Savings, gbc);
	gbc.gridy = 0;
	gbc.gridx++;
	
	Checking = new JLabel("Checking Accounts: " +  countCheckingAccounts());
	add(Checking, gbc);
	gbc.gridx++;
	deposit = new JLabel("Total Deposits: " + depositCounter(arr) );
	add(deposit, gbc);
	
	gbc.gridy = 3;
	gbc.gridx--;
	total = new JLabel("Total Accounts: " + countAccounts());
	add(total, gbc);
	
	gbc.gridy = 3;
	gbc.gridx = 2;
	JButton WriteAccounts = new JButton("Write All Accounts");
	WriteAccounts.setPreferredSize(new Dimension(150,40));
	add(WriteAccounts, gbc);
	WriteAccounts.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) 
		{
			try {
				accountWriter(arr);
				} 
			
			catch (IOException e1) {
				e1.printStackTrace();
			}
			update(arr, getC(), getS(), getT(), getD());
		}
		
		});

	
	
}
	//writing over the file
	public void accountWriter(ArrayList<BankAccount> arr) throws IOException
	{

		    PrintWriter writer = new PrintWriter("accounts.txt"); 
	        
		    for(BankAccount x : arr)
		    {
		    	
		       int accNum = x.getAccountNumber();
		       String name = x.getName();
		       String streetad = x.getStreetAddress();
		       String city = x.getCity();
		       String state = x.getState();
		       double balance = x.getBalance();
		       String zip = x.getZipCode();
		      
	    	   
		       if(x instanceof CheckingAccount)
		       {
		    	   writer.println("C" + "/" + removeSpace(name) + "/" + removeSpace(streetad) + "/" + removeSpace(city) + "/" + removeSpace(state) + "/" + balance + "/" + removeSpace(zip) + "/" + accNum + "/" + ((CheckingAccount)x).getNumTransactions() + "/");
		    	   
		       }
		       else
		       {
		           writer.println("S" + "/" + removeSpace(name) + "/" + removeSpace(streetad) + "/" + removeSpace(city) + "/" + removeSpace(state) + "/" + balance + "/" + removeSpace(zip) + "/" + accNum + "/");
		       }
		      
		    }
	          
		    writer.close();

	        
	       }
	//for counting lines of text aka finding total number of Accounts
	public int countAccounts()
	{
		 int count = 0;
        
		    try {
		      Scanner sc = new Scanner(file);
		      while(sc.hasNextLine()) {
		        sc.nextLine();
		        count++;
		      }
		    
		      sc.close();
		    } catch (Exception e) {
		      e.getStackTrace();
		    }
			return count;
	}
	
	//turns each line of the txt file into an element in the array
	public ArrayList<String> txtToList(File fileparam) throws IOException
	{
		ArrayList<String> storage = new ArrayList<String>();
		Scanner s = new Scanner(fileparam);
		while (s.hasNextLine())
		{
			
			try
			{
				storage.add(s.next());
			}
			catch(Exception e) {}
			
		}
		s.close();
		return storage;
	}
	
	//counts Checking Accounts
	public int countCheckingAccounts() throws IOException
	{
		 int count = 0;
         ArrayList<String> storage = txtToList(file);
		   for(String x : storage)
		   {
			   if((x.charAt(0) + "").equalsIgnoreCase("C"))
			   {
				   count++;
			   }
		   }
		   
			return count;
	}
	//for getting the txt file
	public File gettxt()
	{
		return file;
	}
	
	public String getPass()
	{
		
		return password;
		
	}
	
	public static String removeSpace(String string)
	{
		String returner = string.replaceAll(" ", "_");
		
		return returner;
	}
	
	public static String depositCounter(ArrayList<BankAccount> arr)
	{
		double total = 0;
		for(BankAccount x : arr)
		{
			total += x.getBalance();
		}
		return total + "";
		
	}
	
	public void update(ArrayList<BankAccount> arr, JLabel C, JLabel S, JLabel T, JLabel D )
	{
		int numC = 0;
		int numS = 0;
		int numT = 0;
		double numD = 0;
		for(BankAccount x: arr)
		{
			if(x instanceof CheckingAccount) 
			{
				numC++;
			
			}
			else
			{
				numS++;
			}
			numD += x.getBalance();
			
		}
		numT = numC + numS;
		
		C.setText("Checking Accounts: " + numC);
		S.setText("Savings Accounts: " + numS);
		T.setText("Total Accounts: " + numT);
		D.setText("Total Deposits: " + numD);
	}
	
	public JLabel getC()
	{
		return Checking;
	}
	
	public JLabel getS()
	{
		return Savings;
	}
	public JLabel getT()
	{
		return total;
	}
	public JLabel getD()
	{
		return deposit;
	}
   }


