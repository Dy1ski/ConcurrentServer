/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1clientserver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;



public class ClientThread extends Thread {
public static int pCount;
	Socket mySocket;
static String cId;
        
public ClientThread(Socket aSocket)
{
    this.mySocket = aSocket;  
}
        
public static void mPrintln(String rMessage)
{       
    pCount++;  
    if (rMessage.equals("Bye bye!"))
    {
       System.out.println("Closing Port Now... Thank you");             
    }
    else
    {
        cId = rMessage;
        System.out.println("Client " + cId + " has successfully processed");
    }        
}
public void run()
{
    try{
            BufferedReader in = new BufferedReader(
            new InputStreamReader(mySocket.getInputStream()));
            String message = in.readLine();
            mPrintln(message);
            
            if(message.equals("Bye bye!"))
            {
                System.out.println((pCount -1) + " requests from client " + cId + " were processed");
                pCount = 0;
                mySocket.close();
            }
       } 
       catch (Exception e)
       {
       
       }
            
                
}
}




	



	