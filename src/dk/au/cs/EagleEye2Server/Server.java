package dk.au.cs.EagleEye2Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
  private int port;
  private boolean answerCapitalized;
  private String filename;

  public Server(int port, boolean answerCapitalized, String filename){
    this.port = port;
    this.answerCapitalized = answerCapitalized;
    this.filename = filename;

    Start();
  }

  private void Start(){
    try{
      ConnectionHandler();
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  private void ConnectionHandler() throws IOException{
    String line;
    String capitalizedSentence;
    ServerSocket welcomeSocket = new ServerSocket(port);

    while(true) {
      Socket connectionSocket = welcomeSocket.accept();
      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      line = inFromClient.readLine();

      System.out.println("[Received] Line: " + line);
      saveToFile(line);

      if(answerCapitalized){
        try{
          capitalizedSentence = line.toUpperCase() + "\n";
          outToClient.writeBytes(capitalizedSentence);
        }catch(SocketException e){
          System.out.println("Could not return the capitalized string to the client - It might have closed the connection.");
        }
      }

      if(!connectionSocket.isClosed()){
        connectionSocket.close();
      }
    }
  }

  private void saveToFile(String line) {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    File file = new File("data/" + filename + ".txt");

    try {
      file.createNewFile();
      fileWriter = new FileWriter(file, true);
      bufferedWriter = new BufferedWriter(fileWriter);

      bufferedWriter.write(line);
      bufferedWriter.newLine();
      bufferedWriter.flush();

      bufferedWriter.close();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
