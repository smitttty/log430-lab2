package ca.etsmtl.log430.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Allow callers to perform various terminal related operations.
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

public class Termio {

	/**
	 * Reads a string from the keyboard and returns it to the caller.
	 * 
	 * @return The string entered at by the user
	 */
	public String keyboardReadString() {
		BufferedReader myReader = new BufferedReader(new InputStreamReader(
				System.in));

		String stringItem = "";

		try {
			stringItem = myReader.readLine();
		} catch (IOException IOError) {
			System.out
					.println("Read Error in Termio.KeyboardReadString method");
		}
		return stringItem;
	}

	/**
	 * Reads a single character from the keyboard and returns it to the caller.
	 * 
	 * @return The character entered by the user.
	 */
	public char keyboardReadChar() {
		BufferedReader myReader = new BufferedReader(new InputStreamReader(
				System.in));

		char charItem = ' ';

		try {
			charItem = (char) myReader.read();
		} catch (IOException err) {
			System.out.println("Read Error in Termio.KeyboardReadChar method");
		}
		return charItem;
	}

	/**
	 * This method accepts a string and determines if it represents a number. If
	 * an integer is passed (for example 4), then the program will assume that
	 * it is a floating point number (for example 4.0).
	 * 
	 * @param stringItem
	 * @return true if the string represents a numeric value, false otherwise.
	 */
	public boolean isNumber(String stringItem) {

		try {
			Float.valueOf(stringItem);
		} catch (NumberFormatException err) {
			return false;
		}
		return true;
	}

	/**
	 * Accepts a string and if the string represents a number, then it is
	 * converted to a float and returned to the caller. Otherwise a
	 * NumericFormatException is raised and a message is printed for the caller.
	 * 
	 * @param stringItem
	 * @return the string converted to float if relevant, 0.0 otherwise.
	 */
	public float toFloat(String stringItem) {
		Float floatItem = new Float(0.0);
		try {
			floatItem = Float.valueOf(stringItem);
		} catch (NumberFormatException err) {
			System.out.print("Error converting " + stringItem);
			System.out.print(" to a floating point number::");
			System.out.println(" Termio.ToFloat method.");
		}
		return floatItem.floatValue();
	}

	/**
	 * Accepts a string and if the string represents a number, then it is
	 * converted to a double and returned to the caller. Otherwise a
	 * NumericFormatException is raised and a message is printed for the caller.
	 * 
	 * @param stringItem
	 * @return the string converted to double if relevant, 0.0 otherwise.
	 */
	public double toDouble(String stringItem) {
		Float floatItem = new Float(0.0);

		try {
			floatItem = Float.valueOf(stringItem);
		} catch (NumberFormatException err) {
			System.out.print("Error converting " + stringItem);
			System.out.print(" to a floating point number::");
			System.out.println(" Termio.ToDouble method.");
		}
		return floatItem.doubleValue();
	}

	/**
	 * Accepts a string and if the string represents a number, then it is
	 * converted to an integer and returned to the caller. Otherwise a
	 * NumericFormatException is raised and a message is printed for the caller.
	 * 
	 * @param stringItem
	 * @return the string converted to double if relevant, 0 otherwise.
	 */
	public int toInteger(String stringItem) {
		Integer integerItem = new Integer(0);
		try {
			integerItem = Integer.valueOf(stringItem);
		} catch (NumberFormatException err) {
			System.out.print("Error converting " + stringItem);
			System.out.print(" to an integer number::");
			System.out.println(" Termio.ToInteger method.");
		}
		return integerItem.intValue();
	}
}