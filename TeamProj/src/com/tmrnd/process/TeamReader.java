package com.tmrnd.process;

import com.tmrnd.model.Team;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirthy Saradhi Devarapalli
 * @version 1.0
 * Class to read Team CSV file
 */
public class TeamReader extends Thread {
	
	/*public static void main(String... args)
	{ 
		List<Team> team = readTeamFromCSV("C:\\Users\\saradhid\\Desktop\\TMR&D\\csv_files\\team.csv");
		{
            team.remove(0);
            for(Team teamObj:team){
			    System.out.println(teamObj.getTeam_id());
            }
	    }
	}*/

    public void run(){
        List<Team> team = readTeamFromCSV("C:\\Users\\saradhid\\Desktop\\TMR&D\\csv_files\\team.csv");
        {
            if(team.size()>0){
            team.remove(0);
            System.out.println("TeamReader Thread: "+Thread.currentThread().getName());
            for(Team teamObj:team){
                System.out.println(teamObj.getTeam_id());
            }
            } else{
                System.out.println("No Records Found To Process");
            }
        }
    }
	
	private static List<Team> readTeamFromCSV(String fileName) {
		List<Team> team = new ArrayList<Team>();
		Path pathToFile = Paths.get(fileName); 
		// create an instance of BufferedReader 
		// using try with resource, Java 7 feature to close resources
        if(new File(pathToFile.toString()).exists()){
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
		{ 
			// read the first line from the text file 
			String line = br.readLine(); 
			// loop until all lines are read 
			while (line != null) 
			{ 
				// use string.split to load a string array with the values from 
				// each line of 
				// the file, using a comma as the delimiter 
				String[] attributes = line.split(",");
                Team book = createBook(attributes);
				// adding book into ArrayList 
				team.add(book);
				// read next line before looping 
				// if end of file reached, line would be null 
				line = br.readLine(); 
				} 
			} 
		catch (IOException ioe) { 
			ioe.printStackTrace(); 
			}
        }
		return team;
		} 
	private static Team createBook(String[] metadata)
	{ 
		String teamId = metadata[0];
		// create and return book of this metadata 
		return new Team(teamId);
		} 
	}