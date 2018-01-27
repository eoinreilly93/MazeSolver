# MazeSolver
Simple Java program to solve a maze using recursion

This program accepts one argument, a text file in the following format. 
To run it, you can:
	1) Open the project in an IDE and run the tests provided
	2) Execute the jar file provided with the following command "java -jar MazeSolver.jar src/main/resources/medium_input.txt"
		- Replace medium_input.txt with any of the given text files

Input file format
================

The input is a maze description file in plain text.  
 1 - denotes walls
 0 - traversable passage way
 
```
INPUT:
<WIDTH> <HEIGHT><CR>
<START_X> <START_Y><CR>		(x,y) location of the start. (0,0) is upper left and (width-1,height-1) is lower right
<END_X> <END_Y><CR>		(x,y) location of the end
<HEIGHT> rows where each row has <WIDTH> {0,1} integers space delimited
```
```
OUTPUT:
 The maze with a path from start to end
 Walls marked by '#', passages marked by ' ', path marked by 'X', start/end marked by 'S'/'E'
 ```
 
```
Example file:  
10 10
1 1
8 8
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 1 0 1 1 1 1 1 1
1 0 1 0 0 0 0 0 0 1
1 0 1 1 0 1 0 1 1 1
1 0 1 0 0 1 0 1 0 1
1 0 1 0 0 0 0 0 0 1
1 0 1 1 1 0 1 1 1 1
1 0 1 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1
```

```
OUTPUT:
##########
#SXX     #
# #X######
# #XX    #
# ##X# ###
# # X# # #
# # XX   #
# ###X####
# #  XXXE#
##########
```


