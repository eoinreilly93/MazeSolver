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
		if(ms.solve(startX, startY)) {
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
            width = Integer.parseInt(dimensions.substring(0, dimensions.indexOf(' ')));
            height = Integer.parseInt((dimensions.substring(dimensions.indexOf(' ') +1 )));
            maze = new char[height][width];
              
            //Get start point
            String start = br.readLine();
            char temp;
            temp = start.charAt(0);
            startY = Character.getNumericValue(temp);
            temp = start.charAt(2);
            startX = Character.getNumericValue(temp);
            
            //Get finish point
            String finish = br.readLine();
            endY = Integer.parseInt(finish.substring(0, finish.indexOf(' ')));
            endX = Integer.parseInt((finish.substring(finish.indexOf(' ') +1 )));
            
            //Populate maze
            int heightCounter = -1;
            String line;
            while((line = br.readLine()) != null) {
            	int lineNum = 0;
            	heightCounter++;
            	for (int i = 0; i < line.length(); i++){
            		if(line.charAt(i) != ' '){
            			maze[heightCounter][lineNum] = line.charAt(i);
                		lineNum++;
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
		
		maze[startX][startY] = 'S';
		maze[endX][endY] = 'E';	
		
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
	 * @param i     - x coordinate
	 * @param j		- y coordinate
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
	 * Prints the solved maze path
	 */
	private void printMaze() {
		
		maze[startX][startY] = 'S';
		for (int i = 0; i < maze.length; i++) {
	        System.out.println(maze[i]);
	    }
	}
}
