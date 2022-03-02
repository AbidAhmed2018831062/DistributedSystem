package socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
int port;
ServerSocket ser=null;
ExecutorService p=null;
Socket cl=null;
PrintStream pt=null;

int count=0;
public static void main(String []args) throws IOException
{
	Server s=new Server(1234);
	
	s.startServer();
	
}
Server(int port)
{
	this.port=port;
	p=Executors.newFixedThreadPool(5);
}
public void startServer() throws IOException
{
	ser=new ServerSocket(1234);
	System.out.println("Server Started:");
	while(true)
	{
		cl=ser.accept();
		count++;
		ServerThread ru=new ServerThread(cl,count,this);
		//System.out.println(ServerThread.list);
		Scanner er=new Scanner(System.in);
		//String y=er.nextLine();
		p.execute(ru);

		System.out.println("Enter client number to directly message to him or her!");
		int c=er.nextInt();
		if(c!=0) {
			//System.out.println(c);
	ru.ServerMes("Hello From server");
		}
		else
			ru.ServerMes("hj");
	}
	
}
}
