package ca.etsmtl.log430.lab2;

import ca.etsmtl.log430.common.List;

/**
 * Provides a data structure (Vector) to store the system components.
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

public class ComponentList extends List {

	public ComponentList() {
		super();
	}

	/**
	 * Adds a new Component to the list. All the issues of casting are taken
	 * care of within this class.
	 * 
	 * @param component
	 */
	public void addComponent(Communication component) {
		appendItemToList((Object) component);
	}

	/**
	 * @return The component pointed at the current position pointed to by the
	 *         internal list pointer of the internal list. Subsequent calls will
	 *         return the next component object in the list. A null object is
	 *         returned if list is empty or the end of list has been reached.
	 */
	public Object getNextComponent() {
		return (Object) getItemFromList();
	}

	/**
	 * @param componentName
	 *            The name of the object (at instantiation)
	 * @return the associated component object
	 */
	public Communication getComponent(String componentName) {
		Communication currentComponent = null;
		boolean done = false;

		goToFrontOfList();

		while (!done) {
			currentComponent = (Communication) getNextComponent();

			if (currentComponent == null) {
				done = true;
			} else {
				if (componentName.compareTo(currentComponent.componentName) == 0) {
					done = true;
				}
			}
		}
		return ((Communication) currentComponent);
	}

	/**
	 * @param componentName
	 *            The name of the object (at instantiation)
	 * @return the associated component ID
	 */
	public Integer getComponentID(String componentName) {
		Communication currentComponent = null;
		boolean done = false;
		boolean result = false;

		goToFrontOfList();

		while (!done) {
			currentComponent = (Communication) getNextComponent();

			if (currentComponent == null) {
				done = true;
			} else {
				if (componentName.compareTo(currentComponent.componentName) == 0) {
					result = true;
					done = true;
				}
			}
		}

		if (result == true) {
			return ((Integer) currentComponent.registrationNumber);
		} else {
			return (null);
		}
	}
}