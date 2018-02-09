package com.junifer.maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MazeSolver {
	
    private char [][] maze = null;
    private BufferedReader br = null;
    private File f;
    private static int startX = 0;
    private static int startY = 0;
    private int endX = 0;
    private int endY = 0;
    private int height = 0;
    private int width = 0;

	public static void main(String[] args) {
		
		MazeSolver ms = new MazeSolver();
		String fileName = args[0];
		ms.buildMaze(fileName);
		ms.formatMaze();
		if(ms.solve(startY, startX)) {
			ms.printMaze();
		}
		else {
			System.out.println("The maze could not be solved");
		}
	}	
	
	
	/**
	 * Populates the 2d maze with the input from the given file
	 * @param file
	 */
	private void buildMaze(String file) {
	
        try {
        	f = new File(file);
    		if(!f.exists() || f.isDirectory()) {
    			throw new FileNotFoundException();
    		}
    		
    		//Read each file line to populate necessary variables and maze coordinates
            br = new BufferedReader(new FileReader(file));
            
            //Get width and height of maze
            String dimensions = br.readLine();
            width = readLineValue(dimensions, 0);
            height = readLineValue(dimensions, 1);
            maze = new char[height][width];
              
            //Get start point
            String start = br.readLine();
            startX = readLineValue(start, 0);
            startY = readLineValue(start, 1);
            
            //Get finish point
            String finish = br.readLine();
            endX = readLineValue(finish, 0);
            endY = readLineValue(finish, 1);
            
            //Populate maze
            int rowNum = -1;
            String line;
            while((line = br.readLine()) != null) {
            	int columnNum = 0;
            	rowNum++;
            	for (int i = 0; i < line.length(); i++){
            		if(line.charAt(i) != ' '){
            			maze[rowNum][columnNum] = line.charAt(i);
            			columnNum++;
            		}
            	}
            }                         
        }
        catch(FileNotFoundException fnfe) {
        	System.out.println("The file : " + f.getName() + " does not exist" );
            fnfe.printStackTrace();         
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        catch(ArrayIndexOutOfBoundsException aioob){
        	aioob.printStackTrace();
        }
    }
	

	/**
	 * Formats the maze
	 * Replaces 1s with '#' and 0s with ' '
	 * Also sets start and end values 'S' and 'E'
	 */
	private void formatMaze() {
		
		maze[startY][startX] = 'S';
		maze[endY][endX] = 'E';
		
		for (int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				
				if(maze[i][j] == '1') {
					maze[i][j] = '#';
		        }
				
				if(maze[i][j] == '0') {
					maze[i][j] = ' ';
		        }
			}  
	    }		
	}
	
	
	/**
	 * Finds the path to the exit by marking each visited point and
	 * recursively calling the method with new coordinates until the exit
	 * is reached
	 * @param i     - y coordinate
	 * @param j		- x coordinate
	 * @return		- true when maze is solved
	 */
	private boolean solve(int i, int j) { 
		
		if (maze[i][j] == '#') {
			return false;
		}
	        
	    if (maze[i][j] == 'E') {
	    	return true;
	    }
	        
	    if (maze[i][j] == 'X') {
	        return false;
	    }
	    
	    maze[i][j] = 'X';
	    	
	    //South
	    if ((solve(i + 1, j)) == true) {
	        return true;
	    }
	    //West
	    if ((solve(i, j - 1)) == true) {
	        return true;
	    }
	    //East
	    if ((solve(i , j + 1)) == true) {
	        return true;
	    }
	    //North
	    if ((solve(i - 1 , j)) == true) {
	        return true;
	    }	    
	    
	    maze[i][j] = ' ';
	    return false;
	}
	
	/**
	 * Returns the coordinate point for the input file line
	 * @param line		- Line from the input file
	 * @param index		- Index of array to return (Will always be 0 or 1)
	 * @return
	 */
	private int readLineValue(String line, int index) {
		String[] temp = line.split(" ");
		return Integer.parseInt(temp[index]);
	}
	
	
	/**
	 * Prints the solved maze path
	 */
	private void printMaze() {
		maze[startY][startX] = 'S';
		for (int i = 0; i < maze.length; i++) {
	        System.out.println(maze[i]);
	    }
	}
}
