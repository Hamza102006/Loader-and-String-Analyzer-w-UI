import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Hamza Khan
 * 9/23/2023
 * Description: This program will prompt the user to enter a file name 
 *              and it will process/analyze the file using and calling 
 *              the methods from the loader and processer class. Then the 
 *              program will also print into a output file using another 
 *              method from the PhraseLoader Class.
 * 
 * 
 * {METHOD LIST}
 * 
 * 	public static void main(String[] args) throws IOException { > Main Method 
 * 
 * 
 */
public class StringAnalysisUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{

		//declare the variables
		String fName, outputFile;
		String[] phrase , output;

		// prompt the user for the file name
		fName = JOptionPane.showInputDialog(null, "Please Enter the File Name to be Processed (Example: file.dat): ", "ManyPhrases.dat");



		try {

			//calling loadFile from the PhraseLoader to get all the phrases within the file
			phrase = PhraseLoader.loadFile(fName);


			//calling fLocation from StringAnalyzer to find locations of f/F's and total number of them 
			output = StringAnalyzer.fLocation(phrase);

			// call the output process from the StringAnalzyer  
			String display = "";
			for (int i = 0; i < output.length; i++) {
				display += output[i] + "\n";
			}

			//JTextArea to help display the output message 
			JTextArea displayArea = new JTextArea();
			displayArea.setText(display);
			displayArea.setEditable(false);

			// displays the output 
			JOptionPane.showMessageDialog(null, displayArea);

			//promts the user for a output file name
			outputFile = JOptionPane.showInputDialog(null, "Please Enter a Name for the Saved Output File (Example: output.dat)", "outputData.dat");

			//writes the final updated output file by calling the analysisAftermath from the PhraseLoader File
			PhraseLoader.analysisAftermath(outputFile, output);


		}

		//catch all the possible and potential errors within the program using catch 
		catch (FileNotFoundException error) {
			JOptionPane.showMessageDialog(null, fName + " Not Found!");
		}
		catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(null, fName + " is corrupted!");

		}
		catch (Exception error) {
			JOptionPane.showMessageDialog(null, fName + " Unknown Error!");

		}


	}

}
