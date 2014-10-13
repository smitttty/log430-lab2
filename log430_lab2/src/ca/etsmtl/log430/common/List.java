package ca.etsmtl.log430.common;

import java.util.Vector;

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

public class List {
	/** The actual list */
	private Vector<Object> itemList;

	/** Used to index elements in the list */
	private int vectorIndex;

	public List() {
		itemList = new Vector<Object>(25, 5);
		vectorIndex = 0;
	}

	/**
	 * Uses the Vector.add method to append the Object to the end of the list.
	 * Casting from Object to specific class is handled in the classes that
	 * extend this class.
	 * 
	 * @param item
	 */
	public void appendItemToList(Object item) {
		itemList.add(item);
	}

	/**
	 * Gets the Object from the list that is currently being pointed to by
	 * VectorIndex. Casting from Object to specific class is handled in the
	 * classes that extend this class.
	 * 
	 * @return The Object currently pointed to in the list
	 */
	public Object getItemFromList() {
		Object listItem;

		/*
		 * Each time we get an item we increment the VectorIndex If we go out of
		 * the Vector bounds, then we will catch in the the catch clause below
		 * and return a null object
		 */
		try {
			listItem = itemList.get(vectorIndex);
			vectorIndex++;
			return (listItem);
		} catch (ArrayIndexOutOfBoundsException error) {
			return ((Object) null);
		}
	}

	/**
	 * Sets VectorIndex back to zero, thereby pointing at the front of the list.
	 */
	protected void goToFrontOfList() {
		vectorIndex = 0;
	}
}
