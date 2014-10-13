package ca.etsmtl.log430.lab2;

import ca.etsmtl.log430.common.ProjectReader;
import ca.etsmtl.log430.common.ResourceReader;

/**
 * Contains data that is used (directly or indirectly) by all
 * classes.
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
 * 
 * ***************************************************************************
 */

public class CommonData {
	/** The file that contains the information for projects. */
	private String defaultProjectFile = "projects.txt";

	/** The file that contains the information for resources. */
	private String defaultResourceFile = "resources.txt";
	
	/** Variable used to determine if initialization has been realized. */
	private static boolean initialized = false;

	/** Object that reads the projects from a file. */
	static ProjectReader theListOfProjects;

	/** Object that reads the resources from a file. */
	static ResourceReader theListOfResources;

	/** A list of components */
	private static ComponentList systemComponents;

	/**
	 * Initializes the resource and project list using the default lists
	 */
	public CommonData() {
		if (!initialized) {
			theListOfProjects = new ProjectReader(defaultProjectFile);
			theListOfResources = new ResourceReader(defaultResourceFile);
			systemComponents = new ComponentList();
			initialized = true;
		} // if

		// If either list is null, you are in trouble.
		if (theListOfProjects.getListOfProjects() == null) {
			System.out.println("\n\n *** The project list is empty ***");
		}
		
		if (theListOfResources.getListOfResources() == null) {
			System.out.println("\n\n *** The resource list is empty ***");
		}
	}

	/**
	 * Updates an internal list of system components. This lets system
	 * components know the identity of other components in the system
	 * 
	 * @param component
	 */
	public void registerComponent(Communication component) {
		systemComponents.addComponent(component);
	}

	/**
	 * @param componentName
	 * @return object that corresponds to the object's instance name
	 */
	public Communication getComponent(String componentName) {
		return (systemComponents.getComponent(componentName));
	}

	/**
	 * @param componentName
	 * @return registration ID that corresponds to the object's instance name
	 */
	public Integer getComponentID(String componentName) {
		return (systemComponents.getComponentID(componentName));
	}
}