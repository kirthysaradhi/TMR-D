package com.tmrnd.process;

import com.tmrnd.db.DbConnector;
import com.tmrnd.model.Task;

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
 * Class to read Task CSV file
 */
public class TaskReader extends Thread {
	
	/*public static void main(String... args)
	{ 
		List<Task> task = readTaskFromCSV("C:\\Users\\saradhid\\Desktop\\TMR&D\\csv_files\\task.csv");
		{
            task.remove(0);
            for(Task taskObj:task){
			    System.out.println("Task Id:"+taskObj.getTaskId());
                System.out.println("Skill  :"+taskObj.getSkill());
            }
	    }
	}*/

    public void run(){
        List<Task> task = readTaskFromCSV("C:\\Users\\saradhid\\Desktop\\TMR&D\\csv_files\\task.csv");
        {
            if(task.size()>0){
            task.remove(0);
            System.out.println("TaskReader Thread: "+Thread.currentThread().getName());
            for(Task taskObj:task){
                System.out.println(taskObj.getTaskId());
                System.out.println(taskObj.getSkill());
            }
                DbConnector.connectTaskDatabase(task);
            } else{
                System.out.println("No Records Found To Process");
            }
        }
    }
	
	private static List<Task> readTaskFromCSV(String fileName) {
		List<Task> task = new ArrayList<Task>();
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
                Task book = createBook(attributes);
				// adding book into ArrayList 
				task.add(book);
				// read next line before looping 
				// if end of file reached, line would be null 
				line = br.readLine(); 
				} 
			} 
		catch (IOException ioe) { 
			ioe.printStackTrace(); 
			}
        }
		return task;

    }
	private static Task createBook(String[] metadata)
	{ 
		String taskId = metadata[0];
        String skill = metadata[1];
		// create and return book of this metadata 
		return new Task(taskId,skill);
		} 
	}