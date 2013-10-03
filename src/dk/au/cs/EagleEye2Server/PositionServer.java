package dk.au.cs.EagleEye2Server;

import com.google.gson.Gson;
import de.micromata.opengis.kml.v_2_2_0.Kml;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class PositionServer {
  public static void main(String[] args) throws IOException {
    if(0 < args.length && args[0].equals("parse")){
      parse(args[1]);
      //toKML();
    }else{
      server();
    }
  }

  private static void server() throws IOException {
    String location;
    String capitalizedSentence;
    ServerSocket welcomeSocket = new ServerSocket(57005);

    while(true) {
      Socket connectionSocket = welcomeSocket.accept();
      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      location = inFromClient.readLine();

      System.out.println("Received: " + location);
      saveToFile(location, "locations");

      // For testing purposes, perhaps this configurable
      capitalizedSentence = location.toUpperCase() + '\n';
      outToClient.writeBytes(capitalizedSentence);
    }
  }

  private static void saveToFile(String location, String fileName) {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    File locationsFile = new File("data/" + fileName + ".out");

    try {
      locationsFile.createNewFile();
      fileWriter = new FileWriter(locationsFile, true);
      bufferedWriter = new BufferedWriter(fileWriter);

      bufferedWriter.write(location);
      bufferedWriter.newLine();
      bufferedWriter.flush();

      bufferedWriter.close();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
  }

  private static void parse(String fileName) throws IOException {
    System.out.println("Start parse");

    Gson gson = new Gson();

    List<Location> locations = new ArrayList<Location>();
    Location location = null;

    File locationsFile = new File("data/" + fileName + ".out");
    //System.out.println("File: "+locationsFile.getAbsolutePath());

    BufferedReader br = new BufferedReader(new FileReader(locationsFile));
    try {
      String line = br.readLine();

      while (line != null) {
        //System.out.println("Line: "+line);

        location = gson.fromJson(line, Location.class);
        locations.add(location);

        line = br.readLine();
      }
    } finally {
      br.close();
    }

    System.out.println("Start middle");

    for(Location location_ : locations){
      System.out.println("Location: "+location_);
    }
  }

  private static void toKML() throws IOException {
    final Kml kml = new Kml();
    kml.createAndSetPlacemark()
            .withName("London, UK").withOpen(Boolean.TRUE)
            .createAndSetPoint().addToCoordinates(-0.126236, 51.500152);
    kml.marshal(new File("HelloKml.kml"));
  }
}