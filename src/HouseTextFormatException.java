    /* HouseTextFormatException-- Class extends IllegalArgument Exception
	 * @author Gurpreet Singh
	 */

public class HouseTextFormatException extends IllegalArgumentException{
    
	/*HouseTextFormatException-- Constructor
	 *@param message a String argument send to Super constructor
	 *calls super constructor 
	 */
	private static final long serialVersionUID = 1L;

	public HouseTextFormatException(String message) {
	      super (message);
	   }
}
