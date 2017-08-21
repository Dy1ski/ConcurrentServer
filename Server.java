/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	static int port_number = 9091;
        
	public static void main(String[] args) throws IOException {
                int i = 0;
               
		System.out.println("Server is listening..");
		ServerSocket listener = new ServerSocket(port_number);
               
		
                    while(true) 
                    {
			Socket socket = listener.accept();
			ClientThread t =  new ClientThread(socket);
			t.start();    
                    }
                 

		

}
}