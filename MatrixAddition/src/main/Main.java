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
	public static void main(String[] args) 
	{
		int[][] A = null;
		int[][] B = null;
		ThreadOperation operator1;
		ThreadOperation operator2;
		ThreadOperation operator3;
		ThreadOperation operator4;
		try
		{
			File dataFile = new File("matrix1.txt");
			Scanner fileReader = new Scanner(dataFile);
			int row = Integer.parseInt(fileReader.next());
			int column = Integer.parseInt(fileReader.next());
			System.out.println(row + " " + column);
			if(row % 2 == 0 && column % 2 == 0)
			{
				A = new int[row][column];
				B = new int[row][column];
				fileReader.nextLine();
				for(int i = 0; i < row - 1; i++)
				{
					for(int j = 0; j < column - 1; j++)
					{
						A[i][j] = fileReader.nextInt();
					}
				}
				for(int i = 0; i < row - 1; i++)
				{
					for(int j = 0; j < column - 1; j++ )
					{
						B[i][j] = fileReader.nextInt();
					}
				}
			}
			else if(row % 2 != 0 && column % 2 == 0 )
			{
				A = new int[row/2][column/2];
				B = new int[(row/2) + 1][column/2];
			}
			else if(row % 2 == 0 && column % 2 != 0 )
			{
				A = new int[row/2][column/2];
				B = new int[row/2][column/2 + 1];
			}
			
			for(int i = 0; i < row - 1; i++)
			{
				for(int j = 0; j < column - 1; j++)
				{
					System.out.print(A[i][j] + " ");
				}
				System.out.println();
			}
			for(int i = 0; i < row - 1; i++)
			{
				for(int j = 0; j < column - 1; j++ )
				{
					System.out.print(B[i][j] + " ");
				}
				System.out.println();
			}
		}
		catch(IOException e)
		{
			System.out.println("FILE ERROR: NOT FOUND OR WRONG FORMAT");
		}
		
		System.out.println();
		
		
		
	}

}