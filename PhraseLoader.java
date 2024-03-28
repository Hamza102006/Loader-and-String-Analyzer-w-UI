import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 */

/**
 * @author Hamza Khan
 *Date: 9/20/2023
 *Desc: This program will be responsible for opening and reading 
 *      many phrases from a file. The read data will be able to be used in String Analyzer
 *      This program also consists of a second method which will obtain the final return 
 *      from the String Analysis Program and save it into the output file 
 *
 *{METHOD LIST}
 *  public static String [] loadFile (String fileName) throws IOException > The following method is responsible for
 *                                                                          reading the phrases from the file 
 *                                                                          
 * public static void analysisAftermath(String fileName, String[] output) throws IOException > prints output of analysis program 
 *                                                                                             into a file 
 *                                                                                             
 * public static void main(String[] args) throws IOException > Self testing method 
 *
 *
 *
 */
public class PhraseLoader {


	/*
	 * Method to open and read from the file 
	 * Given the file name 
	 */

	public static String [] loadFile (String fileName) throws IOException {
		//open the file in fileName to read 
		FileReader fr = new FileReader(fileName);
		BufferedReader input = new BufferedReader (fr);

		// read the size of my dataset
		int size = Integer.parseInt(input.readLine());

		//declare and create and array for the data set 
		String fileInfo [] = new String [size];

		//loop through the file and save the data in the array 
		for (int i = 0; i < size; i++) {
			fileInfo [i] = input.readLine();
		}

		//close the file input stream
		input.close();

		// return the data back to the classer 
		return fileInfo;


	}
	/**
	 * Method will take a file name and a array, and will print it out into a file
	 */
	public static void analysisAftermath(String fileName, String[] output) throws IOException {
		// opens file using print writer to be abel to write in file
		PrintWriter finalFile = new PrintWriter(new FileWriter(fileName));

		// prints each output to file
		for (int i = 0; i < output.length; i++) {
			finalFile.println(output[i]);
		}

		// close file
		finalFile.close();
	}



	public static void main(String[] args) throws IOException{
		// SELF TESING MAIN METHOD

		//Declare an array to read into
		String output[];

		// call the loaderfie method
		output = PhraseLoader.loadFile("ManyPhrases.dat");

		//display the contents of the output message

		for (int i = 0 ; i < output.length; i++) {
			System.out.println(output[i]);
		}


	}

}
