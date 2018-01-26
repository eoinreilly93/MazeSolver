package com.junifer.maze.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.junifer.maze.MazeSolver;

public class MazeSolverTest {

	@Test
	public void SolveMazeVSmallInput() {
		String fileName = "src/main/resources/input.txt";
		String[] args = {fileName};
		MazeSolver.main(args);
		System.out.println();
	}
	
	@Test
	public void SolveMazeSmallInput() {
		String fileName = "src/main/resources/small.txt";
		String[] args = {fileName};
		MazeSolver.main(args);
		System.out.println();
	}
	
	@Test
	public void SolveMazeSparseMediumInput() {
		String fileName = "src/main/resources/sparse_medium.txt";
		String[] args = {fileName};
		MazeSolver.main(args);
		System.out.println();
	}
	
	@Test
	public void SolveMazeMediumInput() {
		String fileName = "src/main/resources/medium_input.txt";
		String[] args = {fileName};
		MazeSolver.main(args);
		System.out.println();
	}
	
	@Test
	public void SolveMazeLargeInput() {
		String fileName = "src/main/resources/large_input.txt";
		String[] args = {fileName};
		MazeSolver.main(args);
		System.out.println();
	}
}
