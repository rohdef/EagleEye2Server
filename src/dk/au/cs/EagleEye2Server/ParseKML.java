package dk.au.cs.EagleEye2Server;

import com.google.gson.Gson;
import de.micromata.opengis.kml.v_2_2_0.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParseKML {
  private List<Location> locations;

  private String filenameIn;
  private String filenameOut;

  public ParseKML(String filenameIn, String filenameOut){
    this.filenameIn = filenameIn;
    this.filenameOut = filenameOut;

    Read();
    ToKML();
  }

  private void Read(){
    try{
      ReadInner();
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  private void ReadInner() throws IOException {
    Gson gson = new Gson();

    locations = new ArrayList<Location>();
    Location location = null;

    File locationsFile = new File("data/" + filenameIn + ".txt");

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
  }

  private void ToKML(){
    try{
      ToKMLInner();
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  private void ToKMLInner() throws IOException {
    final Kml kml = new Kml();

    // Document
    Document doc = kml.createAndSetDocument();
    doc.setName("Locations");

    // Style
    ToKMLInnerStyle(doc);

    // Placemark
    Placemark path = doc.createAndAddPlacemark();
    path.withName("Path");
    path.setStyleUrl("EagleEye");

    // Line String (Path)
    LineString pathLine = path.createAndSetLineString();

    // Locations
    int no = 0;
    long firstTime = 0;
    long duration = 0;


    for(Location location : locations){
      // Time - Duration
      if(firstTime == 0){
        firstTime = location.getmTime();
      }

      duration = location.getmTime() - firstTime;

      // Time formatting
      Date time = new Date(location.getmTime());
      SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy HH:mm:ss");

      Date durationTime = new Date(duration);
      SimpleDateFormat durationFormat = new SimpleDateFormat ("mm:ss");

      // Path
      pathLine.addToCoordinates(location.getmLongitude(), location.getmLatitude());

      // Point
      Placemark pmPoint = doc.createAndAddPlacemark();
      pmPoint.setStyleUrl("EagleEye");
      pmPoint.withName("L"+no+" - "+durationFormat.format(durationTime)+"");
      pmPoint.withDescription("Time: "+format.format(time));

      Point point = pmPoint.createAndSetPoint();
      point.addToCoordinates(location.getmLongitude(), location.getmLatitude());

      no++;
    }

    // Save to file
    File file = new File("data/" + filenameOut+".kml");
    kml.marshal(file);
  }

  private void ToKMLInnerStyle(Document doc){
    Style style = doc.createAndAddStyle();
    style.setId("EagleEye");

    // Line Style
    LineStyle lStyle = style.createAndSetLineStyle();
    lStyle.setColor("55ff0000");
    lStyle.setWidth(3.0);

    // Icon
    // Overview: https://sites.google.com/site/gmapsdevelopment/
    Icon icon = new Icon();
    icon.setHref("http://www.google.com/mapfiles/ms/micons/blue.png");

    // Icon Style
    IconStyle iStyle = style.createAndSetIconStyle();
    iStyle.setIcon(icon);
    iStyle.setScale(1.0);
  }
}
