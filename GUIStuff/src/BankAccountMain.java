import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BankAccountMain extends JFrame
{
	
	
	private Dashboard test;
	public BankAccountMain() throws IOException
	{
		
	
		
		
		ArrayList<BankAccount> arr = new ArrayList<BankAccount>();
		
		//construct Dashboard object 
		test = null;
		try {
			test = new Dashboard(arr);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		Dashboard dash = new Dashboard();
		ArrayList<String> txt = new ArrayList<String>();
		File accounts = new File("accounts.txt");
		txt = dash.txtToList(accounts);
		for(int i = 0; i < txt.size() ; i++)
		{
			String[] split = txt.get(i).split("/");
			
			if(split.length == 8)
			{
				SavingsAccount S = new SavingsAccount(split[1], split[2], split[3], split[4], Double.parseDouble(split[5]), split[6], Integer.parseInt(split[7]));
				arr.add(S);
			}
			
			else
			{
				CheckingAccount C = new CheckingAccount(split[1], split[2], split[3], split[4], Double.parseDouble(split[5]), split[6], Integer.parseInt(split[7]), Integer.parseInt(split[8]));
				arr.add(C);
			}
		}
		this.setBounds(10,10,600,400);
		this.setTitle("Banking Software");
		JPanel overall = new JPanel();
		CardLayout c1 = new CardLayout();
		overall.setLayout(c1);
	
		overall.add(test,"test");
		
		//construct user info 
		UserInfo Info = new UserInfo(arr);
		overall.add(Info, "UserInfo");
		//construct add account
		AddAccount accAdd = new AddAccount(arr);
		overall.add(accAdd, "AddAccount");
		//construct close account
		CloseAcount accClose = new CloseAcount(arr);
		overall.add(accClose, "CloseAccount");
		//construct Deposit
		Deposit Dep = new Deposit(arr);
		overall.add(Dep, "Deposit");
		//construct Withdraw
	    Withdraw draw = new Withdraw(arr);
		overall.add(draw, "Withdraw");
		//construct Transfer
	    Transfer trans = new Transfer(arr);
		overall.add(trans, "Transfer");
		//construct Get User Info
	    GetAccountInfo info = new GetAccountInfo(arr);
		overall.add(info, "GetUserInfo");
		//set up main menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu account = new JMenu("Account");
		JMenuItem userInfo = new JMenuItem("User Info");
		JMenuItem  addAccount = new JMenuItem("Add Account");
		JMenuItem closeAccount = new JMenuItem("Close Account");
		account.add(userInfo);
		account.add(addAccount);
		account.add(closeAccount);
		
		JMenu transactions = new JMenu("Transactions");
		JMenuItem  deposit = new JMenuItem("Deposit");
		JMenuItem withdraw = new JMenuItem("Withdraw");
		JMenuItem  transfer = new JMenuItem("Transfer");
		JMenuItem getAccountInfo = new JMenuItem("Account Info");
		transactions.add(deposit);
		transactions.add(withdraw);
		transactions.add(transfer);
		transactions.add(getAccountInfo);
		
		JMenuItem dashboard = new JMenuItem("Dashboard");
		menuBar.add(transactions);
		menuBar.add(account);
		menuBar.add(dashboard);
		Dashboard defaultPanel = new Dashboard(arr);
		
		
		
	    dashboard.addActionListener(new MyListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				test.update(arr, test.getC(), test.getS(), test.getT(), test.getD());
				c1.show(overall, "test");
				
			}
		});
	    
	    userInfo.addActionListener(new MyListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				c1.show(overall, "UserInfo");
				
			}
		});
	    
	    addAccount.addActionListener(new MyListener()
	 		{
	 			public void actionPerformed(ActionEvent e)
	 			{
	 				
	 				c1.show(overall, "AddAccount");
	 				
	 			}
	 		});
	    
	    closeAccount.addActionListener(new MyListener()
 		{
 			public void actionPerformed(ActionEvent e)
 			{
 				
 				c1.show(overall, "CloseAccount");
 				
 			}
 		});
	    
	    deposit.addActionListener(new MyListener()
	  		{
	  			public void actionPerformed(ActionEvent e)
	  			{
	  				
	  				c1.show(overall, "Deposit");
	  				
	  			}
	  		});
	    
	    withdraw.addActionListener(new MyListener()
  		{
  			public void actionPerformed(ActionEvent e)
  			{
  				
  				c1.show(overall, "Withdraw");
  				
  			}
  		});
	    
	    transfer.addActionListener(new MyListener()
  		{
  			public void actionPerformed(ActionEvent e)
  			{
  				
  				c1.show(overall, "Transfer");
  				
  			}
  		});
	    
	    getAccountInfo.addActionListener(new MyListener()
  		{
  			public void actionPerformed(ActionEvent e)
  			{
  				
  				c1.show(overall, "GetUserInfo");
  				
  			}
  		});
	    
		this.setJMenuBar(menuBar);
		
		
		
		this.add(overall);
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}
	
	
	public static BankAccount findAccByNumber(int AccNum, ArrayList<BankAccount> arr)
	{
		BankAccount returnAcc = null;
		for(BankAccount x: arr)
		{
			if(x.getAccountNumber() == AccNum)
			{
				
				returnAcc = x;
				
			}
		}
		
		return returnAcc;
		
	}
	
	public static ArrayList<BankAccount> findAccByName(String name, ArrayList<BankAccount> arr )
	{
		
	ArrayList<BankAccount> returnarr = new ArrayList<BankAccount>();
		for(BankAccount x: arr)
		{
			
			if(x.getName().replaceAll("_", " ").equals(name))
			{
				
				returnarr.add(x);
			}
		
		}
		if(returnarr.size() == 0)
		{
			return null;
		}
		return returnarr;
	}
	
	public static void main(String[] args) throws IOException 
	{
		new BankAccountMain();
		
	}

}
