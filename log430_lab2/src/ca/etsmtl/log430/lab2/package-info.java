/**
 * Assignment 2, ETS course LOG430 - Architecture logicielle. The purpose of
 * this assignment is to introduce the implicit invocation architectural
 * style.<br><br>
 * 
 * The application is a contrived route management system. It is a menu
 * driven system that allows the following options:
 * 
 * <pre>
 *    1) List resources (humans to be allocated to projects)
 *    2) List projects
 *    3) List projects currently assigned to a resource
 *    4) List resources currently assigned to a project
 *    5) Assign a resource to a project
 *    6) List projects previously assigned to a resource
 *    X) Exit.
 * </pre>
 * 
 * Functionally, the system is identical to the previous lab.
 * 
 * Dynamically, the main program initializes the primary objects
 * and dispatches commands at the user's request. When the program is started,
 * the resource objects are initialized from a file (<tt>resources.txt</tt>).
 * The format of this file is listed in the
 * {@link ca.etsmtl.log430.common.ResourceReader ResourceReader} class header.
 * The project objects are initialized from another file (<tt>projects.txt</tt>).
 * The format of this file is listed in the
 * {@link ca.etsmtl.log430.common.ProjectReader ProjectReader} class header.<br><br>
 * 
 * <b>Running the program:</b><br><br>
 * 
 * <blockquote>
 * <tt>java SystemInitialize</tt>
 * </blockquote>
 *
 * @author A.J. Lattanze - CMU - 1999
 * @author Roger Champagne - ETS - 2002-2013
 * @version 2013-Oct-06
 */
package ca.etsmtl.log430.lab2;