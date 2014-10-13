package ca.etsmtl.log430.lab2;

import java.util.Observable;

import ca.etsmtl.log430.common.Menus;
import ca.etsmtl.log430.common.Project;
import ca.etsmtl.log430.common.Resource;

/**
 * Assigns resources to projects.
 *  
 * @author A.J. Lattanze, CMU
 * @version 1.5, 2013-Oct-06
 */

/*
 * Modification Log **********************************************************
 * v1.5, R. Champagne, 2013-Oct-06 - Various refactorings for new lab.
 * 
 * v1.4, R. Champagne, 2012-Jun-19 - Various refactorings for new lab.
 * 
 * v1.3, R. Champagne, 2012-Feb-14 - Various refactorings for new lab.
 * 
 * v1.2, R. Champagne, 2011-Feb-24 - Various refactorings, conversion of
 * comments to javadoc format.
 * 
 * v1.1, R. Champagne, 2002-Jun-19 - Adapted for use at ETS.
 * 
 * v1.0, A.J. Lattanze, 12/29/99 - Original version.
 * ***************************************************************************
 */
public class AssignResourceToProject extends Communication
{
	public AssignResourceToProject(Integer registrationNumber, String componentName) {
		super(registrationNumber, componentName);
	}

	/**
	 * The update() method is an abstract method that is called whenever the
	 * notifyObservers() method is called by the Observable class. First we
	 * check to see if the NotificationNumber is equal to this thread's
	 * RegistrationNumber. If it is, then we execute.
	 * 
	 * @see ca.etsmtl.log430.lab2.Communication#update(java.util.Observable,
	 *      java.lang.Object)
	 */
	public void update(Observable thing, Object notificationNumber) {
		Menus menu = new Menus();
		Resource myResource = new Resource();
		Project myProject = new Project();

		if (registrationNumber.compareTo((Integer)notificationNumber) == 0) {
			addToReceiverList("ListResourcesComponent");
			addToReceiverList("ListProjectsComponent");

			// Display the resources and prompt the user to pick one

			signalReceivers("ListResourcesComponent");

			myResource = menu.pickResource(CommonData.theListOfResources.getListOfResources());

			if (myResource != null) {
				/*
				 * Display the projects that are available and ask the user to
				 * pick one
				 */
				signalReceivers("ListProjectsComponent");

				myProject = menu.pickProject(CommonData.theListOfProjects.getListOfProjects());

				if (myProject != null)	{	
					/*
					 * If the selected project and resource exist, then complete
					 * the assignment process.
					 */
					myProject.assignResource(myResource);
					myResource.assignProject(myProject);
				} else {
					System.out.println("\n\n *** Project not found ***");
				} 
			} else {
				System.out.println("\n\n *** Resource not found ***");
			}
		}
	}
}