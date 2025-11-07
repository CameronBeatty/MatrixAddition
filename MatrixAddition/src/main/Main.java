package main;
/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following question:

Q1: One of the goals of multi-threading
is to minimize the resource usage, such
as memory and processor cycles. In three
sentences, explain how multi-threaded
code accomplishes this goal. Consider
writing about blocking on I/O, multicore 
machines, how sluggish humans are,
threads compared to processes, etcetera,
and connect these issues to 
multi-threading.

*/
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		int[][] A = null;
		int[][] B = null;
		int row = 0;
		int column = 0;
		ThreadOperation operator1;
		ThreadOperation operator2;
		ThreadOperation operator3;
		ThreadOperation operator4;
		//Read In Data
		try
		{
			//Create a new file
			File dataFile = new File("matrix2.txt");
			//Scan the file
			Scanner fileReader = new Scanner(dataFile);
			//The first two integers in the file
			//are stored as the row and column and then
			//we move to the next line
			row = Integer.parseInt(fileReader.next());
			column = Integer.parseInt(fileReader.next());
			fileReader.nextLine();
			//Create two new arrays to store
			//the two separate arrays
			A = new int[row][column];
			B = new int[row][column];
			//Read in array A, the first two integers of the
			//file give us the size of the two arrays which
			//are always the same so we use these values
			//to determine when all of A and B has been read
			for(int i = 0; i < row ; i++)
			{
				for(int j = 0; j < column; j++)
				{
					A[i][j] = fileReader.nextInt();
				}
			}
			//Read in array B
			for(int i = 0; i < row ; i++)
			{
				for(int j = 0; j < column; j++ )
				{
					B[i][j] = fileReader.nextInt();
				}
			}
			//Done scanning
			fileReader.close();
		}
		//FILE ERROR
		catch(IOException e)
		{
			System.out.println("FILE ERROR: NOT FOUND OR WRONG FORMAT");
		}
		//Array to store sum of A and B
		int[][] summedMatrix = new int[row][column];
		//Print out A and B using print2DArray method
		System.out.println("Original Arrays:");
		print2DArray(A, row, column);
		System.out.println();
		print2DArray(B, row, column);
		//Create 4 threads to sum A and B.
		//summedMatrix is passed to all 4 threads,
		//this is because summedMatrix is a 2D
		//array which is an Object, and since it is
		//an object it is passed by reference versus
		//passed by value meaning we can manipulate the
		//same array in all 4 threads through passing it in
		//the constructor.
		operator1 = new ThreadOperation(A, B, summedMatrix, ThreadOperation.Quadrant.Q1, row, column);
		operator2 = new ThreadOperation(A, B, summedMatrix, ThreadOperation.Quadrant.Q2, row, column);
		operator3 = new ThreadOperation(A, B, summedMatrix, ThreadOperation.Quadrant.Q3, row, column);
		operator4 = new ThreadOperation(A, B, summedMatrix, ThreadOperation.Quadrant.Q4, row, column);
		System.out.println();
		
		//start threads
		operator1.start();
		operator2.start();
		operator3.start();
		operator4.start();
		//Print out the summed array
		System.out.println("Summed Array:");
		print2DArray(summedMatrix, row, column);
	}//END of Main
	
	//takes a 2D array and the row and column amount
	//as input. The entire 2D array is then output
	//in a formated form
	public static void print2DArray(int[][]array, int row, int column)
	{
		//loop through entire 2D array
		//printing each element
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				System.out.printf("%-6d", array[i][j]);
			}
			System.out.println();
		}
	}

}