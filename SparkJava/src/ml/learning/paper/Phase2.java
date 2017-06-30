package ml.learning.paper;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.math3.util.Precision;

public class Phase2 {
	public static int CREATEBOOSTEDTRAINDATA=0;
	public static int numberOfZero,numberOfOne,numberOfTwo;
	public static int lineCount, formula;
	public static String[][] secondData;
	public static String[][] firstData;
	
	public static void main(String[] args) throws Exception  {

		String fName = "resources/outputOfDf.csv";
		String thisLine; 
		int count=0; 
		FileInputStream fis = new FileInputStream(fName);
		DataInputStream myInput = new DataInputStream(fis);
		int i=0; 


		String[][] data = new String[0][];//csv data line count=0 initially
		while ((thisLine = myInput.readLine()) != null) {
			++i;//increment the line count when new line found

			String[][] newdata = new String[i][2];//create new array for data

			String strar[] = thisLine.split(";");//get contents of line as an array
			newdata[i - 1] = strar;//add new line to the array

			System.arraycopy(data, 0, newdata, 0, i - 1);//copy previously read values to new array
			data = newdata;//set new array as csv data
		}

		for(int j=0;j<6;j++){ //call shiftUp windowSize/2
			shiftUp(0,data);
		}


	
		converToLibsvm(data); //convert array data to libsvm file

		if(CREATEBOOSTEDTRAINDATA==1){
			//to create boosted training data
			createBoostedLibsvm();
		}


		/*System.out.println("------------------------------"); //debug print array secondData
		for (String[] strings : secondData) {
			for (String string : strings) {
				System.out.print("\t" + string);
			}
			System.out.println();
		}*/
	}
	
	//shift up labelled data
	public static void shiftUp(int i, String[][] array) {
		int m = array.length;

		for (int k=0; k<m-1; k++){
			array[k][0] = array[k+1][0];
		}
		//array[m-1][0] = "--";
	}

	public static void converToCsv(String[][] board) {

		StringBuilder builder = new StringBuilder();
		for(int n = 0; n < board.length; n++)//for each row
		{
			for(int j = 0; j < board[0].length; j++)//for each column
			{
				builder.append(board[n][j]+"");//append to the output string
				if(j < board.length - 1)//if this is not the last row element
					builder.append(";");//then add comma (if you don't like commas you can use spaces)
			}
			builder.append("\n");//append new line at the end of the row
		}
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("resources/outputOfPostprocessing.csv"));
			writer.write(builder.toString());//save the string representation of the board
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void converToLibsvm(String[][] board) {

		StringBuilder builder = new StringBuilder();
		for(int n = 0; n < board.length; n++)//for each row
		{
			for(int j = 0; j < board[0].length; j++)//for each column
			{
				//System.out.println("n: " + n + " j:" + j );

				if(j>0)
					builder.append(j + ":");

				builder.append(board[n][j]+"");//append to the output string

				if(j < board.length - 1)//if this is not the last row element
					builder.append(" ");//then add comma (if you don't like commas you can use spaces)

			}
			builder.append("\n");//append new line at the end of the row
		}
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("resources/outputOfLibsvm.txt"));
			writer.write(builder.toString());//save the string representation of the board
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createBoostedLibsvm() throws Exception {
		String fName = "resources/outputOfLibsvm.txt";
		String thisLine; 
		int count=0; 
		FileInputStream fis = new FileInputStream(fName);
		DataInputStream myInput = new DataInputStream(fis);
		int i=0; 

		firstData = new String[0][];//csv data line count=0 initially
		while ((thisLine = myInput.readLine()) != null) {
			++i;//increment the line count when new line found

			String[][] newdata = new String[i][2];//create new array for data

			String strar[] = thisLine.split(" ");//get contents of line as an array
			newdata[i - 1] = strar;//add new line to the array

			System.arraycopy(firstData, 0, newdata, 0, i - 1);//copy previously read values to new array
			firstData = newdata;//set new array as csv data
		}

		int k=0;
		for(int j=0;j<firstData.length-1;j++){
			if(Integer.valueOf(firstData[j][0].substring(0,1))==0){
				numberOfZero++;
			}
			else if(Integer.valueOf(firstData[j][0].substring(0,1))==1){
				numberOfOne++;
			}
			else if(Integer.valueOf(firstData[j][0].substring(0,1))==2){
				numberOfTwo++;
			}
		}
		System.out.println("numberOfZero: " + numberOfZero);
		System.out.println("numberOf1: " + numberOfOne + " needed 1s: " + numberOfZero/numberOfOne);
		System.out.println("numberOf2: " + numberOfTwo+ " needed 2s: " + numberOfZero/numberOfTwo);
	
		lineCount=0;
		formula=((numberOfZero/numberOfOne)*numberOfOne)+((numberOfZero/numberOfTwo)*numberOfTwo);
		//create seconData to copy boosted values
		secondData= new String[formula][5];
		while(k<firstData.length-1){

			if(Double.valueOf(firstData[k][0].substring(0,1))==1){
				for(int m=0; m<numberOfZero/numberOfOne; m++){
					secondData[lineCount+m][0] = firstData[k][0];
					secondData[lineCount+m][1] = firstData[k][1];
					secondData[lineCount+m][2] = firstData[k][2];
					secondData[lineCount+m][3] = firstData[k][3];
					secondData[lineCount+m][4] = firstData[k][4];
					//secondData[lineCount+m][5] = firstData[k][5];
				}
				lineCount=lineCount+numberOfZero/numberOfOne;
			}
			else if(Double.valueOf(firstData[k][0].substring(0,1))==2){
				for(int m=0; m<numberOfZero/numberOfTwo; m++){
					secondData[lineCount+m][0] = firstData[k][0];
					secondData[lineCount+m][1] = firstData[k][1];
					secondData[lineCount+m][2] = firstData[k][2];
					secondData[lineCount+m][3] = firstData[k][3];
					secondData[lineCount+m][4] = firstData[k][4];
					//secondData[lineCount+m][5] = firstData[k][5];
				}
				lineCount=lineCount+numberOfZero/numberOfTwo;
			}	
			k++;
		}
		//append first and second data array
		appendArrays(firstData,secondData);
	}

	//append 2 arrays
	public static void appendArrays(String[][]a,String[][]b){

		String[][] result = new String[a.length + b.length][];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);

		StringBuilder builder = new StringBuilder();
		for(int n = 0; n < result.length; n++)//for each row
		{
			for(int j = 0; j < result[0].length; j++)//for each column
			{
				//System.out.println("n: " + n + " j:" + j );


				builder.append(result[n][j]+"");//append to the output string

				if(j < result.length - 1)//if this is not the last row element
					builder.append(" ");//then add comma (if you don't like commas you can use spaces)

			}
			builder.append("\n");//append new line at the end of the row
		}
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("resources/outputOfLibsvmBoosted.txt"));
			writer.write(builder.toString());//save the string representation of the board
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
