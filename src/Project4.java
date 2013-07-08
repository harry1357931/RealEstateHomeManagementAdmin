    /*Project4-- Main Class
     *Initiates a HouseGUI Object 
     *Calling HouseGUI Constructor to initiates a HouseGUI object
     *Display Unsorted and Sorted lists of Houses according to event handling
     *@param display a HouseGUI Object  
	 *@author Gurpreet Singh 
	 */

public class Project4 {  

	static HouseGUI display;
	/*Main method
	 *Initiates a HouseGUI object by calling HouseGUI Constructor 
	 *@param args  Argument taken by main form user 
	 */

	public static void main(String[] args) {
		display = new HouseGUI("Project4: Event Handling--House Lists", 500, 400);       // 500, 400);   
	}

}
