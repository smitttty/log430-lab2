package ca.etsmtl.log430.common;


/** This class defines the Project object for the system.
* 
* @author A.J. Lattanze, CMU
* @version 1.7, 2013-Oct-06
*/

/*
* Modification Log **********************************************************
* v1.7, R. Champagne, 2013-Oct-06 - Various refactorings for new lab.
*
* v1.6, R. Champagne, 2012-Jun-19 - Various refactorings for new lab.
* 
* v1.5, R. Champagne, 2012-May-31 - Various refactorings for new lab.
* 
* v1.4, R. Champagne, 2012-Feb-02 - Various refactorings for new lab.
* 
* v1.3, R. Champagne, 2011-Feb-02 - Various refactorings, conversion of
* comments to javadoc format.
* 
* v1.2, R. Champagne, 2002-May-21 - Adapted for use at ETS.
* 
* v1.1, G.A.Lewis, 01/25/2001 - Bug in second constructor. Removed null
* assignment to deliveryID after being assigned a value.
* 
* v1.0, A.J. Lattanze, 12/29/99 - Original version.
* ***************************************************************************
*/

public class Project {

	/**
	 * Project ID
	 */
	private String id;

	/**
	 * Project name.
	 */
	private String name;

	/**
	 * Project start date.
	 */
	private String startDate;

	/**
	 * Project end date.
	 */
	private String endDate;

	/**
	 * Project priority
	 */
	private String priority;

	/**
	 * List of resources assigned to the project
	 */
	private ResourceList resourcesAssigned = new ResourceList();

	public Project() {
		this(null);
	}

	public Project(String id) {
		this.setID(id);
	}

	/**
	 * Assign a resource to a project.
	 * 
	 * @param resource
	 */
	public void assignResource(Resource resource) {
		resourcesAssigned.addResource(resource);
	}

	public void setID(String projectID) {
		this.id = projectID;
	}

	public String getID() {
		return id;
	}

	public void setProjectName(String time) {
		this.name = time;
	}

	public String getProjectName() {
		return name;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setResourcesAssigned(ResourceList resourcesAssigned) {
		this.resourcesAssigned = resourcesAssigned;
	}

	public ResourceList getResourcesAssigned() {
		return resourcesAssigned;
	}

} // Project class