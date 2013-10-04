package dk.au.cs.EagleEye2Server;

import com.google.gson.Gson;
import de.micromata.opengis.kml.v_2_2_0.Kml;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  private static boolean testMode;
  private static boolean parseKML;
  private static boolean runServer;

  // --runServer=true --parseKML=true --testMode=true
  public static void main(String[] args) throws IOException {
    // Default values
    testMode = false;
    parseKML = false;
    runServer = true;

    // Parse arguments
    for(String originalArgument : args){
      // An argument needs a valid prefix
      String prefix = originalArgument.substring(0, 2);

      if(!prefix.equals("--")){
        System.out.println("Invalid argument: Missing prefix ("+originalArgument+")");
        continue;
      }

      String argument = originalArgument.substring(2);

      // An argument need to consists of two parts
      String[] argumentParts = argument.split("=");

      if(argumentParts.length != 2){
        System.out.println("Invalid argument: Must consist of two parts ("+originalArgument+")");
        continue;
      }

      String key = argumentParts[0].toLowerCase();
      String value = argumentParts[1].toLowerCase();
      //System.out.println("[Argument] Key: "+key+", Value: "+value+".");

      // Applying settings
      if(key.equals("testmode")){
        if(value.equals("true")){
          testMode = true;
        }
      }else if(key.equals("parsekml")){
        if(value.equals("true")){
          parseKML = true;
        }
      }else if(key.equals("runserver")){
        if(value.equals("false")){
          runServer = false;
        }
      }
    }

    if(parseKML){
      System.out.println("[Parse KML]");

      ParseKML kml = new ParseKML("locations", "locations");
    }

    if(runServer){
      System.out.println("[Run Server] Port: "+57005+", Test mode: "+testMode+".");

      boolean answerCapitalized = testMode;

      Server s = new Server(57005, answerCapitalized, "locations");
    }
  }
}