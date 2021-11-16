

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSet1 = {{1,2,3,4},{4,5,6},{6,7,8}};
	private double[][] dataSet2 = {{7,2,9},{5,6},{8,7,7},{11,6,2}};
	private double[][] dataSet3 = {{7.5,1.6,9.3},{5.9,2},{8.5,1.9,4.3},{12.6,1.3,7.7,1}};
	private double[][] dataSet4 = {{-6.5,-2.3,6.5},{-4.8,8.5},{2.5,-5.5},{-8.2,7.2,-8.9,5.6}};

	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSet1 = dataSet2 = dataSet3 = dataSet4 = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(46.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
		assertEquals(70.0,TwoDimRaggedArrayUtility.getTotal(dataSet2),.001);
		assertEquals(63.6,TwoDimRaggedArrayUtility.getTotal(dataSet3),.001);
		assertEquals(-5.9,TwoDimRaggedArrayUtility.getTotal(dataSet4),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(4.6,TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);
		assertEquals(6.3636363636363,TwoDimRaggedArrayUtility.getAverage(dataSet2),.001);
		assertEquals(5.3,TwoDimRaggedArrayUtility.getAverage(dataSet3),.001);
		assertEquals(-.53636363636364,TwoDimRaggedArrayUtility.getAverage(dataSet4),.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(15.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
		assertEquals(11.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,1),.001);
		assertEquals(18.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,0),.001);
		assertEquals(22.6,TwoDimRaggedArrayUtility.getRowTotal(dataSet3,3),.001);
		assertEquals(7.9,TwoDimRaggedArrayUtility.getRowTotal(dataSet3,1),.001);
		assertEquals(3.7,TwoDimRaggedArrayUtility.getRowTotal(dataSet4,1),.001);
		assertEquals(-4.29999999,TwoDimRaggedArrayUtility.getRowTotal(dataSet4,3),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(11.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,0),.001);
		assertEquals(18.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet2,2),.001);
		assertEquals(6.8,TwoDimRaggedArrayUtility.getColumnTotal(dataSet3,1),.001);
		assertEquals(-17.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet4,0),.001);
		assertEquals(7.9,TwoDimRaggedArrayUtility.getColumnTotal(dataSet4,1),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(8.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),.001);
		assertEquals(11.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet2),.001);
		assertEquals(12.6,TwoDimRaggedArrayUtility.getHighestInArray(dataSet3),.001);
		assertEquals(8.5,TwoDimRaggedArrayUtility.getHighestInArray(dataSet4),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSet4, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(-6.5, array[0][0],.001);
		assertEquals(-2.3, array[0][1],.001);
		assertEquals(6.5, array[0][2],.001);
		assertEquals(-4.8, array[1][0],.001);
		assertEquals(8.5, array[1][1],.001);
		assertEquals(2.5, array[2][0],.001);
		assertEquals(-5.5, array[2][1],.001);
		assertEquals(-8.2, array[3][0],.001);
		assertEquals(7.2, array[3][1],.001);
		assertEquals(-8.9, array[3][2],.001);
		assertEquals(5.6, array[3][3],.001);	
			
	}

}