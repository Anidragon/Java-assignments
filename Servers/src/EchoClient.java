import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient 
{

	public static void main(String[] args) 
	{
		try
		{
			Socket client = new Socket("127.0.0.1",9999);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(),true);
			
			Scanner keyboard = new Scanner(System.in);
			
			String input;
			
			while(!(input = keyboard.nextLine()).equals("quit"))
			{
				out.println(input);
				String response;
				response = in.readLine();
				
				System.out.println("computer says " + response);
			}
			client.close();
			
		}
		
		catch(Exception e)
		{
			System.out.println("There was an issue in the connection");
		}

	}

}
