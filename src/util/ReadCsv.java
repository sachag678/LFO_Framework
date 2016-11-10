package util;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadCsv {

	//creating output array
	String [][] output; 
	String [] header;
	//creating file to read
	String FileToRead;
	
//reads data after header	
public String[][] readCsv(String filename, String splitBy) {
	//create arrayList to hold data
	ArrayList<String> placeholder = new ArrayList<>();
	FileToRead = filename;
	//initialize default values for output array
	int colNum =0;
	int rowNum =0;
	int counter =0;

	BufferedReader br = null;
	String line = "";

	try {
		int count =0;
		br = new BufferedReader(new FileReader(FileToRead));

		while ((line = br.readLine()) != null) {

			//parse the line by the comma
			String[] input = line.split(splitBy);
			colNum = input.length;
			if(count>=0){//assumes no header
				for (int i=0; i<input.length; i++){
					//add input value into arraylist
					placeholder.add(input[i]); 
				}
			}
			count = count+1;
		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//calculate numofRows
	rowNum = placeholder.size()/colNum;  

	//create output array
	output = new String[rowNum][colNum];

	for (int row =0;row<rowNum;row++){
		for (int i =0; i<colNum;i++){
			output[row][i] = placeholder.get(counter);
			counter =counter+1;
		}
	}
	return output;
}

public ArrayList <String> readCsvString(String filename) {
	//creating output array of type String
	ArrayList<String> placeholder = new ArrayList<String>();
	FileToRead = filename;

	BufferedReader br = null;
	String line = "";

	try { 
		br = new BufferedReader(new FileReader(FileToRead));
		while ((line = br.readLine()) != null) {
				placeholder.add(line);			
		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	return placeholder;
}

//test//
//public static void main(String[] args){
//	String file = "csvFiles/actionProb.csv";
//	ReadCsv read = new ReadCsv();
//	double[][] cuba = read.readCsv(file);
//	String[] name = read.readCsvHeader(file);
//	System.out.print(name);
//	System.out.print(cuba);
// }
}

