package ca.etsmtl.log430.common;


/**
 * This class will read from the InputFile and instantiate the Project objects
 * in the system. It is assumed that the InputFile is in the local directory,
 * contains the various projects and each line of input is read and expected
 * in the following format.
 * <pre>
 *		P001 Projet1 2012-12-20 2013-05-18 H
 *		|    |       |          |          |
 *		|    |       |          |          Priority (H=High, M=Medium, L=Low)
 *		|    |       |          Project end date (YYYY-MM-DD)
 *		|    |       Project start date (YYYY-MM-DD)
 *		|    Project name
 *		Project ID </pre>
 *
 * The projects.txt file has been provided as an example file.
 *
 * @author A.J. Lattanze, CMU
 * @version 1.6, 2013-Oct-06
 */

/* Modification Log
 *****************************************************************************
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
 *****************************************************************************/

public class ProjectReader extends LineOfTextFileReader {

	/**
	 * List of projects.
	 */
    private ProjectList projectList = new ProjectList();

    public ProjectReader() {
        setListOfProjects(null);
    }

    public ProjectReader(String inputFile) {
        setListOfProjects(getProjectList(inputFile));
    }

	/**
	 * Reads a line of text from the input file. The line of text is then
	 * passed to the parsing method where it is parsed and a Project
	 * object is returned. The Project object is then added to the list. When a
	 * null is read from the Project file the method terminates and returns the
	 * list to the caller. A list that points to null is an empty list.
	 * 
	 * @param inputFile
	 * @return The ProjectList properly populated
	 */
    public ProjectList getProjectList(String inputFile) {

        String text;
        boolean done;
        ProjectList list = new ProjectList();

        if (openFile(inputFile)) {

            done = false;

            while (!done) {

                try {

                    text = readLineOfText();

                    if (text == null) {

                        done = true;

                    } else {

                        list.addProject(parseText(text));

                    } // if 

                } // try

                catch (Exception Error) {

                    return (null);

                } // catch

            } // while		

        } else {

            return (null);

        } // if

        closeFile();

        return (list);

    } // getProjectList

	/**
	 * Parse lines of text that are read from the text file containing project
	 * information in the above format. Note that this is a private method.
	 * 
	 * @param lineOfText
	 * @return A properly populated Project instance.
	 */
    private Project parseText(String lineOfText) {

        boolean done; // Loop terminator
        String token; // String token parsed from LineOfText
        int tokenCount; // Number of tokens parsed
        int frontIndex; // Front index of token to parse
        int backIndex; // Back index of token to parse

        Project newProject = new Project();

        tokenCount = 0;
        frontIndex = 0;
        backIndex = 0;
        done = false;

        while (!done) {

            backIndex = lineOfText.indexOf(' ', frontIndex);

            if (tokenCount < 4) {

                token = lineOfText.substring(frontIndex, backIndex);

            } else {

                token = lineOfText.substring(frontIndex);

            } // if 

            switch (tokenCount) {

                case 0 : // Project ID 
                    newProject.setID(token);
                    frontIndex = backIndex + 1;
                    tokenCount++;
                    break;

                case 1 : // Project name
                    newProject.setProjectName(token);
                    frontIndex = backIndex + 1;
                    tokenCount++;
                    break;

                case 2 : // Start date
                    newProject.setStartDate(token);
                    frontIndex = backIndex + 1;
                    tokenCount++;
                    break;

                case 3 : // End date
                    newProject.setEndDate(token);
                    frontIndex = backIndex + 1;
                    tokenCount++;
                    break;

                default : // Priority
                    newProject.setPriority(token);
                    done = true;
                    break;

            } // end switch

        } // end while

        return (newProject);

    } // ParseText

	public void setListOfProjects(ProjectList projectList) {
		this.projectList = projectList;
	}

	public ProjectList getListOfProjects() {
		return projectList;
	}

} // ProjectReader