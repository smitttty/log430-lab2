package ca.etsmtl.log430.lab2;

import java.util.Observable;
import java.util.Observer;

/**
 * Provides the basis of the implicit invocation communications mechanisms.
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

public class Communication extends Observable implements Observer {

	/**
	 * Registration number for the Object
	 */
	protected Integer registrationNumber;

	/**
	 * Name of this component
	 */
	protected String componentName;

	/**
	 * Provides access to system data
	 */
	static CommonData SYSTEM_DATA = new CommonData();

	/**
	 * The constructor must receive a registration number and a component name.
	 * This is a one-to-one mapping that is designed to ease the use of the
	 * virtual bus. Rather than have to remember numbers, components can be
	 * referenced by name. Declared names of the components are used, but you
	 * don't have to (keep in mind that this is the declared name, not the class
	 * type).
	 * 
	 * @param registrationNumber
	 *            component registration number
	 * @param componentName
	 *            component registration
	 */
	public Communication(Integer registrationNumber, String componentName) {

		this.registrationNumber = new Integer(registrationNumber.intValue());
		this.componentName = componentName;
		SYSTEM_DATA.registerComponent((Communication) this);
	}

	/**
	 * Finds a component's registration ID given the component name. This method
	 * provides an interface for users so they don't directly access the common
	 * data.
	 * 
	 * @param componentName
	 * @return The component's registration ID
	 */
	public Integer getComponentID(String componentName) {
		return (SYSTEM_DATA.getComponentID(componentName));
	}

	/**
	 * Adds a Component to the list of Components that will receive signals from
	 * this class. This is done by adding the component name to the Component
	 * list that is maintained in CommonData.
	 * 
	 * @param componentName
	 */
	public void addToReceiverList(String componentName) {
		addObserver((Observer) SYSTEM_DATA.getComponent(componentName));
	}

	/**
	 * Removes a Component from the list of Components that will respond to
	 * signals. This is done by removing the component name from the Component
	 * list that is maintained in CommonData.
	 * 
	 * @param componentName
	 */
	public void removeFromReceiverList(String componentName) {
		deleteObserver((Observer) SYSTEM_DATA.getComponent(componentName));
	}

	/**
	 * This method signals all components. The only data that is passed along is
	 * an Integer representing a component's ID. This ID is the component name
	 * that you intend to signal. All components receive the signal. Components
	 * are responsible to determine if they should ignore or act upon the
	 * signal. In the original system, after a signal is received, the component
	 * checks to see if its their ID. If it is, they render the service,
	 * otherwise they ignore the signal.
	 * 
	 * @param componentName
	 */
	public void signalReceivers(String componentName) {
		setChanged();
		notifyObservers(SYSTEM_DATA.getComponentID(componentName));
	}

	/**
	 * The update() method is an abstract method that is called whenever the
	 * notifyObservers() method is called by the Observable class. This method
	 * has to be implemented here because of the fact that this class implements
	 * the Observer interface. However, the real work of update() has to be
	 * implemented in the class that inherits this class. Implementing update in
	 * the child class effectively overrides this update method which does
	 * nothing.
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable thing, Object item) {
	}

}