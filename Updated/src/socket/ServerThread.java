package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerThread implements Runnable {
Server ser=null;
Socket cl=null;
BufferedReader br;
PrintStream pt=null;
Scanner s=new Scanner(System.in);
int i;
int d=0;
String str="";
BufferedReader br1=null;
static List<String> list=new ArrayList<>();

ServerThread(Socket cl, int count, Server ser) throws IOException{
	this.ser=ser;
	this.cl=cl;
	
	this.i=count;
	System.out.println("Connection Established with Client Number: "+count);
	list.add("Client"+count);
	System.out.println("List of connected users:");
	for(int i=0;i<list.size();i++)
	{
		System.out.println(ServerThread.list.get(i));
	}
	br=new BufferedReader(new InputStreamReader(cl.getInputStream()));
	pt=new PrintStream(cl.getOutputStream());
	br1= new BufferedReader(new InputStreamReader(System.in));
	
}

@Override
public void run() {
	int x=1;
	try {
		while(true)
		{
		
			str=br.readLine();
			System.out.println("Client number:"+i+"sent the message: "+str);
			System.out.println("Server Says: ");
			str=s.nextLine();
			d=0;
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
void ServerMes(String mes) throws IOException
{
if(!mes.equals("hj")) {
mes=br1.readLine();
System.out.println("Server sent message to client1: "+mes);
pt.println(mes);
d=1;
}
else
	pt.println(mes);

}

}
