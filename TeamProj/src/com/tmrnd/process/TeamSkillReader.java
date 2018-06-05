package com.tmrnd.process;

import com.tmrnd.db.DbConnector;
import com.tmrnd.model.TeamSkill;

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
public class TeamSkillReader extends Thread{

    public void run(){
        List<TeamSkill> teamSkillList = readTeamSkillFromCSV("C:\\Users\\saradhid\\Desktop\\TMR&D\\csv_files\\team_skill.csv");
        {
            if(teamSkillList.size()>0){
                teamSkillList.remove(0);
            System.out.println("TeamSkillReader Thread: "+Thread.currentThread().getName());
            for(TeamSkill teamSkill:teamSkillList){
                System.out.println(teamSkill.getTeamId());
                System.out.println(teamSkill.getSkill());
            }
                DbConnector.connectTeamSkillDatabase(teamSkillList);
            } else{
                System.out.println("No Records Found To Process");
            }
        }
    }
	
	private static List<TeamSkill> readTeamSkillFromCSV(String fileName) {
		List<TeamSkill> team = new ArrayList<TeamSkill>();
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
                TeamSkill book = createBook(attributes);
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
	private static TeamSkill createBook(String[] metadata)
	{ 
		String teamId = metadata[0];
        String skill = metadata[1];
		// create and return book of this metadata 
		return new TeamSkill(teamId,skill);
		} 
	}