

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable {
Server ser=null;
Socket cl=null;
BufferedReader br;
PrintStream pt=null;
Scanner s=new Scanner(System.in);
int i;
String str="";

ServerThread(Socket cl, int count, Server ser) throws IOException{
	this.ser=ser;
	this.cl=cl;
	this.i=count;
	System.out.println("Connection Established with Client Number: "+count);
	br=new BufferedReader(new InputStreamReader(cl.getInputStream()));
	pt=new PrintStream(cl.getOutputStream());
	
}

@Override
public void run() {
	int x=1;
	try {
		while(true)
		{
			str=br.readLine();
			System.out.println("Client number:"+i+"sent the message: "+str);
			System.out.println("Server replies: ");
			str=s.nextLine();
			if(str.equals("Exit"))
			{
				pt.println("Connection Closed");
				x=0;
				break;
			}
			pt.println(str);
			
			}
		br.close();
		pt.close();
		cl.close();
		if(x==0)
		{
			System.out.println("Server Cleaning");
			System.exit(0);
		}
	}
	catch(Exception e)
		{
			
		}
	
	
}

}
