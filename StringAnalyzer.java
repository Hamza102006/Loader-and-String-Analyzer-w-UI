/**
 * 
 */

import javax.swing.JOptionPane;

/**
 * @author Hamza Khan
 * Date: 9/21/2023
 * Description: The role of this program is to be able to calculate and determine
 *              the number of f's in a phrase, their location and also which phrases 
 *              its from 
 * 
 * 
 * {METHOD LIST} 
 * 
 * public static String[] fLocation (String[] phrase) { > Method to check 
 *                                                      number of f's, their location 
 *                                                      and which phrase its from 
 * 
 * 	public static void main(String[] args) { > Self Testing Main Method 

 * 
 */


public class StringAnalyzer {

	/**
	 * METHOD To Count the number of f's in phrase and will also determine the location of where the f's were found
	 */

	public static String[] fLocation (String[] phrase) {

		//delcare and intialize the variables
		String [] output = new String[phrase.length];
		int count, whichPhrase = 0;
		char letters;
		String location = "";


		//for loop to run through phrases 
		for (int i = 0; i < phrase.length; i++) {

			//declare and init variables 
			count = 0;
			whichPhrase++;
			location = "";

			//for loop to check all words in phrase to help determine the f locations  
			for (int z = 0; z < phrase[i].length(); z++) {

				//puts the location of the letter at z in the phrase i
				letters = phrase[i].charAt(z);

				// switch case
				switch(letters) {

				case 'f': {
					// this will add the location of "f" to the location variable 
					location = location + phrase[i].indexOf("f", z) + " ";
					//plus 1 to the counter 
					count++;
					break;
				}

				case 'F': {
					// this will add the location of "F" to the location variable 
					location = location + phrase[i].indexOf("F", z) + " ";
					//plus 1 to the counter 
					count++;
					break;
				}

				}

			}

			// setting the output as the variable to display the output 
			output[i] = "Phrase " + whichPhrase + ": Contains " + 
					(count) + " F/f's in the locations " + location;
		}

		//returns the output phrase
		return output;

	}

	/**
	 * SELF TESTING METHOD 
	 * @param args
	 */

	public static void main(String[] args) {

		//Tester Phrase Added 
		String[] phrases = {"Finished files are the result of years of scientific study" 
				+ "combined with the experience of years.", "Fun For Life", "None"
		};

		//Calling method fLocation on all the phrases 
		String[] results = fLocation(phrases);

		//for loop to checks and displays the output (this ensures that the program is working)
		for (int i = 0; i < results.length; i++) {
			String result = results[i];
			System.out.println(result);
		}





	}
}



