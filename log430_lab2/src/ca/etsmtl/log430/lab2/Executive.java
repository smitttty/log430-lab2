package ca.etsmtl.log430.lab2;

import ca.etsmtl.log430.common.Menus;

/**
 * Acts as the system executive. It provides the primary user interface.
 * 
 * Pseudo Code:
 * 
 * <pre>
 * 	add components that I want to receive my signals to the receiver list.
 * 	while !done
 * 		Present Menu
 * 	    if user choice = 1, signal "ListResourcesComponent"
 *    	if user choice = 2, signal "ListProjectsComponent" 
 * 	    if user choice = 3, signal "ListProjectsAssignedToResourceComponent"
 * 	    if user choice = 4, signal "ListResourcesAssignedToProjectComponent"
 * 	    if user choice = 5, signal "AssignResourceToProject" 
 * 	    if user choice = x, you are done
 * 	end while
 * </pre>
 * 
 * @author A.J. Lattanze, CMU
 * @version 1.4, 2013-Oct-06
 */

/*
 * Modification Log **********************************************************
 * v1.4, R. Champagne, 2013-Oct-06 - Various refactorings for new lab.
 * 
 * v1.3, R. Champagne, 2012-Jun-19 - Various refactorings for new lab.
 * 
 * v1.2, R. Champagne, 2011-Feb-24 - Various refactorings, conversion of
 * comments to javadoc format.
 * 
 * v1.1, R. Champagne, 2002-Jun-19 - Adapted for use at ETS.
 * 
 * v1.0, A.J. Lattanze, 12/29/99 - Original version.
 * ***************************************************************************
 */

public class Executive extends Communication {

	public Executive(Integer registrationNumber, String componentName) {
		super(registrationNumber, componentName);
	}

	/**
	 * The main execution loop.
	 */
	public void execute() {
		char userChoice;
		boolean done = false;
		Menus menu = new Menus();

		addToReceiverList("ListResourcesComponent");
		addToReceiverList("ListProjectsComponent");
		addToReceiverList("ListProjectsAssignedToResourceComponent");
		addToReceiverList("ListResourcesAssignedToProjectComponent");
		addToReceiverList("AssignResourceToProject");
		addToReceiverList("ListPreviousProjectsAssignedToPreviousResourceComponent"); //mod 1 (case 6) (option 6)
		addToReceiverList("ListPreviousAndCurrentResourcesAssignedToProjectComponent"); //mod 2 (case 7) (ption 7)

		while (!done) {
			userChoice = menu.mainMenu();

			switch (userChoice) {
			case '1':
				signalReceivers("ListResourcesComponent");
				break;

			case '2':
				signalReceivers("ListProjectsComponent");
				break;

			case '3':
				signalReceivers("ListProjectsAssignedToResourceComponent");
				break;

			case '4':
				signalReceivers("ListResourcesAssignedToProjectComponent");
				break;

			case '5':
				signalReceivers("AssignResourceToProject");
				break;
				
			case '6':
				signalReceivers("ListPreviousProjectsAssignedToPreviousResourceComponent");
			break;
			
			case '7':
				signalReceivers("ListPreviousAndCurrentResourcesAssignedToProjectComponent");
			break;

			case 'X':
			case 'x':
				done = true;
				break;

			}
		}
	}
}