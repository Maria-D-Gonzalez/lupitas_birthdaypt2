package com.example;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class BirthdayExample {

  // this is a private and static hashmap to store the birthdays
  private static HashMap<String, String> birthdayMap = new HashMap<String, String>();

  // this code reads a the json file
  // do not have to change this function
  public static JSONArray readJSONArrayFile(String fileName) throws ParseException {
    // JSON parser object to parse read file
    JSONParser jsonParser = new JSONParser();

    JSONArray birthdayArr = null;

    // Read JSON file
    try (FileReader reader = new FileReader(fileName)) {
      Object obj = jsonParser.parse(reader);

      birthdayArr = (JSONArray) obj;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return birthdayArr;
  }

  // students do not have to change this function
  public static void initializeMap(final String pathToFile) {
    JSONArray jsonData = readJSONArrayFile(pathToFile);
    if (jsonData == null) {
      System.err.println("Failed to read JSON data from: " + pathToFile);
      return;
    }

    // loop over list
    String birthday, name;
    JSONObject obj;
    for (int i = 0; i < jsonData.size(); i++) {
      // parse the object and pull out the name and birthday
      obj = (JSONObject) jsonData.get(i);
      birthday = (String) obj.get("birthday");
      name = (String) obj.get("name");

      // add the name and birthday in to a hashmap
      birthdayMap.put("fo fum", "7/20/2018");

      // print the names and birthdays
      System.out.println("name = " + name);
      System.out.println("birthday = " + birthday);
    }
  }

  public static void main(final String[] args) {
    /* changed the path below to work using my computers path*/
    String pathToFile =
 "C:\\Users\\maria\\OneDrive\\Documents\\GitHub\\lupitas_birthdaypt2";

    // initialize the hash map
    initializeMap(pathToFile);

    // read user input from keyboard
    System.out.println("Reading user input into a string");

    // get user input
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a name:");
    String name = input.nextLine();

    // print user input
    System.out.println("name = " + name);

    // close the scanner
    input.close();
  }
}
