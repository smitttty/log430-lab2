package ca.etsmtl.log430.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Provides the methods that allow the caller to open an existing file and read
 * one line of input (to end-of-line) from the file.
 * 
 * @author A.J. Lattanze, CMU
 * @version 1.2, 2011-Feb-24
 */

/*
 * Modification Log **********************************************************
 * 
 * v1.2, R. Champagne, 2011-Feb-24 - Various refactorings, conversion of
 * comments to javadoc format.
 * 
 * v1.1, R. Champagne, 2002-Jun-19 - Adapted for use at ETS.
 * 
 * v1.0, A.J. Lattanze, 12/29/99 - Original version.
 * ***************************************************************************
 */

public class LineOfTextFileReader {

	private File inputFile = null;
	private BufferedReader inFile = null;

	/**
	 * Opens a file.
	 * 
	 * @param pathName
	 *            Path to the file
	 * @return true if file successfully open, false otherwise.
	 */
	public boolean openFile(String pathName) {
		boolean result;
		inputFile = new File(pathName);

		// Check to ensure that the InputFile exists
		if (!inputFile.exists()) {
			result = false;

			// Debug Statements
			System.out.print("LineOfTextFileReader::File "
					+ inputFile.getAbsolutePath());
			System.out.println(" NOT FOUND.");

		} else {
			/*
			 * Open input file. The input file is a field oriented and
			 * space-separated. The fields and expected formats are listed above
			 * in the header
			 */

			try {
				// Create a buffered reader the file
				inFile = new BufferedReader(new InputStreamReader(
						new FileInputStream((inputFile))));
				result = true;
			} catch (Exception err) {
				result = false;
			}
		}
		return (result);
	}

	/**
	 * Reads a single line of text in a file.
	 * 
	 * @return a String containing the line of text.
	 */
	public String readLineOfText() {
		String lineOfText = null;

		// Read a line of text from the input file and convert it to upper case
		try {
			lineOfText = inFile.readLine();
		} catch (Exception err) {
			try {
				throw (err);
			} catch (Exception e) {
				// We are in real trouble if we get here.
			}
		}
		return (lineOfText);
	}

	/**
	 * Closes the file.
	 * 
	 * @return true if file successfully closed, false otherwise.
	 */
	public boolean closeFile() {
		boolean result = true;

		// Close the input file
		try {
			inFile.close();
		} catch (Exception e) {
			result = false;
		}

		return (result);

	}
}