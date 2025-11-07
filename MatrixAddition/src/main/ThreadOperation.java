package main;
//Handles the addition of two 2D arrays
//by extending thread and breaking up the 
//addition of the two arrays into four separate
//quadrants
public class ThreadOperation extends Thread
{
	//two arrays to add
	private int[][] A;
	private int[][] B;
	//the sum of the two arrays
	private int[][] sumArray;
	//quadrant
	private Quadrant quadrant;
	//row and column length from file
	private int row;
	private int column;
	//enum to determine which quadrant
	//is being added
	public static enum Quadrant
	{
		Q1,
		Q2,
		Q3,
		Q4,
	}
	//constructor
	public ThreadOperation(int[][] A, int[][] B, int[][] summedMatrix, Quadrant q, int row, int column)
	{
		//A and B arrays assigned
		this.A = A;
		this.B = B;
		//assign quadrant
		this.quadrant = q;
		//row and column from file
		this.row = row;
		this.column = column;
		//pass the sumArray
		this.sumArray = summedMatrix;
	}
	
	@Override
	//Adds up the threads assigned quadrant
	//o fthe two arrays
	public void run()
	{
		//variables for specific quadrant being added
		int quadrantRow;
		int quadrantColumn;
		//switch through the four quadrants
		switch(quadrant)
		{
		//QUADRANT 1
		case Q1:
			//limit to top left of two arrays
			quadrantRow = row/2;
			quadrantColumn = column/2;
			//loop through top left and send sums
			//to sumArray
			for(int i = 0; i < quadrantRow; i++)
			{
				for(int j = 0; j < quadrantColumn; j++)
				{
					int temp = A[i][j] + B[i][j];
					sumArray[i][j] = temp;
				}
			}
			break;
		//QUADRANT 2
		case Q2:
			//limit to top right of the two arrays
			quadrantColumn = column/2;
			quadrantRow = row/2;
			//loop through top right of the two arrays
			//and send sums to sumArray
			for(int i = 0; i < quadrantRow; i++)
			{
				for(int j = quadrantColumn; j < column; j++)
				{
					int temp = A[i][j] + B[i][j];
					sumArray[i][j] = temp;
				}
			}
			break;
		//QUADRANT 3	
		case Q3:
			//odd rows
			if(row % 2 != 0)
			{
				//if the rows are odd quadrant 3
				//will have one more row than quadrants
				//one and two
				quadrantRow = (row/2) + 1;
			}
			else
			{
				quadrantRow = row;
			}
			quadrantColumn = column/2;
			//loop through bottom left of the two arrays
			//and add the sums to sumArray
			for(int i = row/2; i < row; i++)
			{
				for(int j = 0; j < quadrantColumn; j++)
				{
					int temp = A[i][j] + B[i][j];
					sumArray[i][j] = temp;
				}
			}
			break;
		//QUADRANT 4	
		case Q4:
			//odd row
			if(row % 2 != 0)
			{
				//if the rows are odd quadrant 3
				//will have one more row than quadrants
				//one and two
				quadrantRow = (row/2) + 1;
			}
			else
			{
				quadrantRow = row;
			}
			quadrantColumn = column/2;
			//loop through bottom right of the two arrays
			//and add their sums to sumArray
			for(int i = row/2; i < row; i++)
			{
				for(int j = quadrantColumn; j < column; j++)
				{
					int temp = A[i][j] + B[i][j];
					sumArray[i][j] = temp;
				}
			}
			break;
		}//END of switch
	}//END of run
}//END of ThreadOperation
