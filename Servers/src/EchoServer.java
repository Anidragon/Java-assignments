import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer 
{

	public static void main(String[] args) throws IOException 
	{
		int port = 9999;
		ServerSocket server = new ServerSocket(port);
		int stage = 0;
		while(true)//for(;;)
		{
			try
			{
				System.out.println("Server listening...");
				Socket client = server.accept();
				System.out.println("server accepted client");
				
				
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream(),true);
				
				String message;
				
							
				while((message = in.readLine()) != null)
				{
					if(stage == 0)
					{
						out.println("tell me a knock knock joke");
					}
					if(message.equalsIgnoreCase("knock knock") && stage == 0)
					{
						out.println("who's there?");
						stage++;
					}
					
					else if(stage == 1)
					{
						out.println(message + " who");
						stage++;
					}
					
					else if(stage == 2)
					{
						out.println("funny joke i didnt laugh");
						stage = 0;
					}
					
					else
					{
						out.println("an error occured please tell me a knock knock joke");
					}
					
				}
				client.close();
			}
			catch(Exception e)
			{
				System.out.println("there was an issue");
			}
		}

	}

}
