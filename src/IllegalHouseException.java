    /*IllegalHouseException -- Class extends IllegalArgumentException
     *Initiates exception if argument in House Object is invalid 
	 *@author Gurpreet Singh 
	 */
   public class IllegalHouseException extends IllegalArgumentException {

   	    /*IllegalHouseException-- Constructor
		 *@param message String Message to be Displayed 
		 */
	   public IllegalHouseException(String message) {
	      super (message);
	   }

}
