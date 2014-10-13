package ca.etsmtl.log430.common;

import ca.etsmtl.log430.common.Resource;

/**
 * This class is used by various other classes that need to keep a list of
 * resources on hand. It extends the List class which provides the basic
 * functionality for storage and retrieval of the Resource Object from the list.
 * 
 * @author A.J. Lattanze, CMU
 * @version 1.6, 2013-Oct-06
 */

/*
 * Modification Log
 * ***************************************************************************
 * v1.6, R. Champagne, 2013-Oct-06 - Various refactorings for new lab.
 * 
 * v1.5, R. Champagne, 2012-Jun-19 - Various refactorings for new lab.
 * 
 * v1.4, R. Champagne, 2012-May-31 - Various refactorings for new lab.
 * 
 * v1.3, R. Champagne, 2012-Feb-02 - Various refactorings for new lab.
 * 
 * v1.2, 2011-Feb-02, R. Champagne - Various refactorings, javadoc comments.
 * 
 * v1.1, 2002-May-21, R. Champagne - Adapted for use at ETS.
 * 
 * v1.0, 12/29/99, A.J. Lattanze - Original version.
 * **************************************************************************
 */

public class ResourceList extends List {

	/**
	 * Adds a new resource to the list. All the issues of casting are taken care
	 * of within this class.
	 * 
	 * @param resource
	 */
	public void addResource(Resource resource) {
		appendItemToList((Object) resource);
	}

	/**
	 * @return The resource at the current position pointed to by the
	 *         internal list pointer. Subsequent calls will return the next
	 *         resource object in the list. A null object is returned if list is
	 *         empty or the end of list has been reached.
	 */
	public Resource getNextResource() {
		return (Resource) getItemFromList();
	}

	/**
	 * Determines whether the Resource object is currently in the list.
	 * 
	 * @param resource
	 * @return true if the resource is in the list, false otherwise.
	 */
	public boolean findResource(Resource resource) {

		Resource currentObject;
		boolean done = false;
		boolean result = false;

		// Note that this method assumes that all instances have different
		// identification numbers.

		goToFrontOfList();

		while (!done) {

			currentObject = getNextResource();

			if (currentObject == null) {

				done = true;

			} else {

				if (resource.getID().compareTo(
						currentObject.getID()) == 0) {

					result = true;

				} // if

			} // if

		} // while

		return (result);

	} // findResource

	/**
	 * Finds a resource in a list using the resourceID as the search key.
	 * 
	 * @param resourceID
	 * @return if the current list object's resourceID matches the resourceID
	 *         passed to the method, the Resource object is returned to the
	 *         caller. Otherwise, returns null.
	 */
	public Resource findResourceByID(String resourceID) {

		Resource currentObject = null;
		boolean done = false;
		boolean found = false;

		// Note that this method assumes that all instances have different
		// identification numbers.

		goToFrontOfList();

		while (!done) {

			currentObject = getNextResource();

			if (currentObject == null) {

				done = true;

			} else {

				if (currentObject.getID().compareTo(resourceID) == 0) {

					found = true;
					done = true;

				} // if

			} // if

		} // while

		if (found) {

			return (currentObject);

		} else {

			return (null);

		} // if

	} // findResourceByID

} // ResourceList