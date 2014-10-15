package ca.etsmtl.log430.lab2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

					int overcharge = 0; //variable used to verify how busy an employee is for a set of dates
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date newProjectStart = null;
					Date newProjectEnd = null;
					Date oldProjectStart = null;
					Date oldProjectEnd = null;
					boolean alreadyAssigned = false; //boolean used to determine if the project has already been assigned to the resource

					try {
						newProjectStart = formatter.parse(myProject.getStartDate());
						newProjectEnd = formatter.parse(myProject.getEndDate());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}				

					Project projectAlreadyAssigned = myResource.getProjectsAssigned().getNextProject();

					//loop that calculates the amount of work for the resource in the given set of dates
					while (projectAlreadyAssigned != null && !alreadyAssigned) {
						alreadyAssigned = false;
						try {
							oldProjectStart = formatter.parse(projectAlreadyAssigned.getStartDate());
							oldProjectEnd = formatter.parse(projectAlreadyAssigned.getEndDate());
						} catch (ParseException e) {
							e.printStackTrace();
						}

						if(projectAlreadyAssigned.getID().equalsIgnoreCase(myProject.getID()))
						{
							alreadyAssigned = true;
						}
						else
						{
							if ((newProjectStart.after(oldProjectStart) && newProjectStart.before(oldProjectEnd)) | (newProjectEnd.after(oldProjectStart) && newProjectEnd.before(oldProjectEnd)))
							{
								if(projectAlreadyAssigned.getPriority().compareToIgnoreCase("H") == 0 )
								{
									overcharge += 100;
								} // if
								if(projectAlreadyAssigned.getPriority().compareToIgnoreCase("M") == 0 )
								{
									overcharge += 50;
								} // if
								if(projectAlreadyAssigned.getPriority().compareToIgnoreCase("L") == 0 )
								{
									overcharge += 25;
								} // if
							}
						}
						projectAlreadyAssigned = myResource.getProjectsAssigned().getNextProject();

					} // while


					//Adds the load of work for the new project to the overcharge variable

					if(myProject.getPriority().compareToIgnoreCase("H") == 0 )
					{
						overcharge += 100;
					} // if
					if(myProject.getPriority().compareToIgnoreCase("M") == 0 )
					{
						overcharge += 50;
					} // if
					if(myProject.getPriority().compareToIgnoreCase("L") == 0 )
					{
						overcharge += 25;
					} // if

					//if statement to verify that the employee is not overcharged or is not already assigned to the project
					if(overcharge > 100 | alreadyAssigned)
					{					
						System.out.println("Project could not be assigned to the resource selected because the resource is already overcharged or is already assigned to the project selected.");
					}
					else
					{					
						myProject.assignResource(myResource);
						myResource.assignProject(myProject);

						System.out.println("Project assigned to selected resource.");

					}
				} else {
					System.out.println("\n\n *** Project not found ***");
				} 
			} else {
				System.out.println("\n\n *** Resource not found ***");
			}
		}
	}
}