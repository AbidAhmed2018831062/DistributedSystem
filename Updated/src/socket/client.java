package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
public class client {
public static void main(String[] args) throws IOException
{
	//ServerSocket s=new ServerSocket(1234);
	//Socket s1=s.accept();
	Socket s1=new Socket("localhost",1234);
	BufferedReader br=new BufferedReader(new InputStreamReader(s1.getInputStream()));
	PrintStream pt=new PrintStream(s1.getOutputStream());
	BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
	String str="",st1=null;
	Scanner sc=new Scanner(System.in);
	while(true)
	{
		
	
		str=br.readLine();

		if(!str.equals("hj")) {
		
		System.out.println("Server says: "+str);
		
	       System.out.println("Client:");
		}
		else
			 System.out.println("Client:");
		str=br1.readLine();
		 System.out.println(str);
		pt.println(str);
		

		
		if(str.equals("Exit"))
		{
			System.out.println("Connection ended");
			break;
		}
		
		
	}
	s1.close();
	br.close();
	pt.close();
	br1.close();
	
	
}
}
