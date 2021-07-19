package abcdpk;


import java.io.*;
import java.net.*;

//10.0.0.138 windows acer 

//Socket:intermediary between client and sever (needed for these 2 to connect)
//Runnable: interface that describes what the thread is supposed to do
//Thread: (a process is made out of threads) a thread is a running task
//to run program in a different pc  telnet 10.0.0.82 8200 
//to run program in same pc         telnet localhost 8200

public class ThreadedEchoServer {

  public static void main(String[] args) {

    try (ServerSocket s = new ServerSocket(8200)) // ServerSocket with port 8200
    {
      int i = 1;
      while (true) {
        Socket incoming = s.accept(); // Socket
        System.out.println("Spawning " + i); // number of connections made
        Runnable r = new ThreadedEchoHandler(incoming/* , obj myObj */); // Runnable (runs program)
        Thread t = new Thread(r); // Thread
        t.start(); // start Thread
        i++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}

