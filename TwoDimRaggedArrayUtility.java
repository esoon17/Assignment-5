import java.util.Scanner;
import java.io.*;

public class TwoDimRaggedArrayUtility extends java.lang.Object{
	
	//Reads from a file and returns a ragged array of doubles
	public static double[][] readFile(File file) throws java.io.FileNotFoundException{
		Scanner inputFile = new Scanner(file);
		String line=""; 
		String[][] temp=new String [10][];
		int row=0;
		
		for (int i=0; i<10; i++) {
			if(inputFile.hasNextLine()){
				row++;
				line = inputFile.nextLine();
				String[] token=line.split(" ");
				int col=token.length;
				temp[i]=new String [col];
				for(int j=0; j<col; j++) {
					temp[i][j]=token[j];
				}
			}
		}

		double [][] array = new double[row][];
		
		for(int i=0; i<row; i++) {
			array[i]=new double [temp[i].length];
			for(int j=0; j<temp[i].length; j++) {
				array[i][j]= Double.parseDouble(temp[i][j]);
			}
		}
		
		inputFile.close();
		
		return array;
	}
	
	//Writes the ragged array of doubles into the file
	public static void writeToFile(double[][] data, File outputFile) throws java.io.FileNotFoundException{
		PrintWriter writer = new PrintWriter(outputFile);
		
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				writer.print(data[i][j] + " ");
			}
			writer.println();
		}
	
		writer.close();
	}
	
	//Returns the total of all the elements of the two dimensional array
	public static double getTotal(double[][] data) {
		double total =0;
		
		for(int i=0; i<data.length; i++) {
			for (int j=0; j<data[i].length; j++) {
				total+=data[i][j];
			}
		}
		
		return total;
	}
	
	//Returns the average of the elements in the two dimensional array
	public static double getAverage(double[][] data) {
		double total =0;
		double elements=0;
		
		for(int i=0; i<data.length; i++) {
			for (int j=0; j<data[i].length; j++) {
				if(data[i][j]==0)
				{
					break;
				}
				total+=data[i][j];
				elements++;
			}
		}
		
		double average= total/elements;
		
		return average;
	}
	
	//Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
	public static double getRowTotal(double[][] data, int row) {
		double total=0;
		
		for(int i=0; i<data[row].length; i++) {
			total+=data[row][i];
		}
		
		return total;
	}
	
	//Returns the total of the selected column in the two dimensional array index 0 refers to the first column
	public static double getColumnTotal(double[][] data, int col) {
		double total=0;
		
		for(int i=0; i<data.length; i++) {
			if(col<data[i].length) {
				total+=data[i][col];
			}
		}
		
		return total;
	}
	
	//Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	public static double getHighestInRow(double[][] data, int row) {
		double large=0;
		
		for(int i=0; i<data[row].length; i++) {
			if(data[row][i]>=large) {
				large=data[row][i];
			}
		}
		
		return large;
	}
	
	//Returns the index of largest element of the selected row in the two dimensional array index 0 refers to the first row
	public static int getHighestInRowIndex(double[][] data, int row) {
		int index=0;
		double large=0;
		
		for(int i=0; i<data[row].length; i++) {
			if(data[row][i]>=large) {
				large=data[row][i];
				index=i;
			}
		}
		
		return index;
	}
	
	//Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
	public static double getLowestInRow(double[][] data, int row) {
		double small=1000;
		
		for(int i=0; i<data[row].length; i++) {
			if(data[row][i]<=small) {
				small=data[row][i];
			}
		}
		
		return small;
	}
	
	//Returns the index of the smallest element of the selected row in the two dimensional array index 0 refers to the first row
	public static int getLowestInRowIndex(double[][] data, int row) {
		int index=0;
		double small=1000;
		
		for(int i=0; i<data[row].length; i++) {
			if(data[row][i]<=small) {
				small=data[row][i];
				index=i;
			}
		}
		
		return index;
	}
	
	//Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column
	public static double getHighestInColumn(double[][] data, int col) {
		double large=0;
		
		for(int i=0; i<data.length; i++) {
			if(col<data[i].length) {
				if (data[i][col]>large) {
					large=data[i][col];
				}
			}
		}
		
		return large;
	}
	
	//Returns index of the largest element of the selected column in the two dimensional array index 0 refers to the first column
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double large=0;
		int index=0;
		
		for(int i=0; i<data.length; i++) {
			if(col<data[i].length) {
				if (data[i][col]>=large) {
					large=data[i][col];
					index=i;
				}
			}
		}
		
		return index;
	}
	
	//Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column
	public static double getLowestInColumn(double[][] data, int col) {
		double small=1000000000;
		
		for(int i=0; i<data.length; i++) {
			if (col<data[i].length)
			{
				if (data[i][col]<small) {
					small=data[i][col];
				}
			}
		}
		
		return small;
	}
	
	//Returns the index of the smallest element of the selected column in the two dimensional array index 0 refers to the first column
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double small=1000000000;
		int index=0;
		
		for(int i=0; i<data.length; i++) {
			if (col<data[i].length) {
				if (data[i][col]<small) {
					small=data[i][col];
					index=i;
				}
			}
		}
		
		return index;
	}
	
	//Returns the largest element in the two dimensional array
	public static double getHighestInArray(double[][] data) {
		double high=0;
		
		for(int i=0; i<data.length; i++)
		{
			for(int j=0; j<data[i].length; j++) {
				if (data[i][j]>high) {
					high=data[i][j];
				}
			}
		}
		
		return high;
	}
	
	//Returns the smallest element in the two dimensional array
	public static double getLowestInArray(double[][] data) {
		double low=1000;
		
		for(int i=0; i<data.length; i++)
		{
			for(int j=0; j<data[i].length; j++) {
				if (data[i][j]<low) {
					low=data[i][j];
				}
			}
		}
		
		return low;
	}
	
	
}
