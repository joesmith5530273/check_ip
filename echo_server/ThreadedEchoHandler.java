package abcdpk;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;

public class ThreadedEchoHandler implements Runnable {
  private Socket incoming; // IV

  public ThreadedEchoHandler(Socket incomingSocket) { // constructor
    incoming = incomingSocket; // Socket
  }

  // if you want to use an object you created make another constructor
  //public ThreadedEchoHandler(Socket incomingSocket, obj myObj){ 

  public void run() {
    // setup for inputStream and outputStream
    try (InputStream inStream = incoming.getInputStream();
        OutputStream outStream = incoming.getOutputStream();
        Scanner in = new Scanner(inStream);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, StandardCharsets.UTF_8),
        true /* autoflush */)) {

      // code here...
      //out.println() == System.out.println() 
      //String str = in.nexLine(); for input
      out.println("write something: ");
      String input = in.nextLine();
      out.println("you wrote: " + input);
       

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}