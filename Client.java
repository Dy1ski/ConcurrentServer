/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Random;


public class Client {

	static String serverIP = "127.0.0.1"; // ip address assingment
	static int portNumber = 9091; // assignment of a port numner 
	
	int id;
	
	public Client(int id){ // Constructor of the client class
		this.id = id;  // Takes in the client id		
	}
	
public void requestService(String bMessage) throws IOException 
{
              
    Socket socket = new Socket(serverIP,portNumber); // passsing in the parameter of the ip address and port numbner
    PrintWriter output = new PrintWriter( socket.getOutputStream(), true); // Print writer print the text output stream
    output.println(bMessage); // prints the id of the client
    output.close(); // close the output stream of the socket
    //socket.close(); // close the connection
}
       
        
public static void main(String[] args) throws IOException 
{
    Scanner uInput = new Scanner(System.in);
    String nClients;
               
         
    System.out.println("How many clients are we working with?");
            nClients = uInput.next();
    int cResult = Integer.valueOf(nClients);
    if (nClients.matches("\\d+"))
    {
        if(cResult == 1)
        {
            System.out.println("Sending " + nClients + " client to server.");
        }
        else
        {
            System.out.println("Sending " + nClients + " clients to server.");
        }
    }
    
    

    Client clients[] = new Client[cResult]; // takes in the input of the client here and creates that many clients.
    for(int i=0; i<cResult; i++) // loop through 10 times... represetns our 10 clients
    {
        Random rand = new Random();
        int m = rand.nextInt(50) + 1;
	clients[i] = new Client(i); // i postion in the for loop and id of the client 
        for(int j = 0; j < m; j++) // random number of request here for request from clients
        {
            clients[i].requestService(String.valueOf(i));// pass in the ip / port numner .... then print the id number with a message of completion
            System.out.println("Client " + i + " submitted request number " + j + " to server");
            // prints out the requests from which client and what request.
        }
            System.out.println("Client "+ i +" submitted its task."); // states what position in the array with that the client has submitted its task
            clients[i].requestService("Bye bye!");
	try 
        {
            Thread.sleep(3000); // go to sleep forthe server to do its thing the go on repeat for the other clients // or change this to 3 seconds was 2 seconds
	} 
        catch (InterruptedException e) 
        {
                        
        }
                       
    }
                
		
}

}