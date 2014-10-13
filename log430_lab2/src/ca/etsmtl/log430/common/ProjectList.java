package ca.etsmtl.log430.common;


/**
 * This class is used by various other classes that need to keep a list of
 * projects. It extends the List class which provides the basic functionality for
 * storage and retrieval of the Project object from the list.
 * 
 * @author A.J. Lattanze, CMU
 * @version 1.6, 2013-Oct-06
 */

/*
 * Modification Log
 * ****************************************************************************
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
 * ***************************************************************************
 */

public class ProjectList extends List {

	public ProjectList() {
		super();
	}

	/**
	 * @param project
	 *            New project to be added to the list. All the issues of casting
	 *            are taken care of within this class.
	 */
	public void addProject(Project project) {
		appendItemToList((Object) project);
	}

	/**
	 * @return The project pointed at the current position pointed to by the
	 *         internal list pointer of the internal list. Subsequent calls will
	 *         return the next Project object in the list. A null object is
	 *         returned if list is empty or the end of list has been reached.
	 */
	public Project getNextProject() {
		return (Project) getItemFromList();
	}

	/**
	 * This method assumes that all projects have different identification
	 * numbers.
	 * 
	 * @param project
	 * @return A Project instance if found in the list based on specified
	 *         criteria, null otherwise.
	 */
	public boolean findProject(Project project) {

		Project currentObject;
		boolean done = false;
		boolean result = false;

		goToFrontOfList();

		while (!done) {

			currentObject = getNextProject();

			if (currentObject == null) {

				done = true;

			} else {
				if (project.getID().compareToIgnoreCase(
						currentObject.getID()) == 0) {

					result = true;

				} // if

			} // if

		} // while

		return (result);

	}

	public Project findProjectByID(String id) {

		Project currentObject;
		Project returnValue = null;
		boolean done = false;

		goToFrontOfList();

		while (!done) {

			currentObject = getNextProject();

			if (currentObject == null) {

				done = true;

			} else {
				if (id.compareToIgnoreCase(currentObject.getID()) == 0) {
					returnValue = currentObject;
					done = true;

				} // if

			} // if

		} // while
		return(returnValue);
	}
	
} // ProjectList