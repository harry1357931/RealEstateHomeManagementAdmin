/* PrivateHouse- extends Class House
 * Initiates the  PrivateHouse Object using Super Constructor from House Class
 * @param YearlyTaxes To Store the Yearly Taxes for Private House.
 * @author Gurpreet Singh
 */
public class PrivateHouse extends House {
	protected int YearlyTaxes;
	/* PrivateHouse-- Constructor
	 * Initiates the PrivateHouse Object using super constructor
	 * @param zcode Stores the ZipCode
	 * @param price Stores the price
	 * @param rooms Stores the rooms
	 * @param YearTaxes Stores the Year taxes
	 */
	public PrivateHouse(String zcode, int price, int rooms, int YearTaxes ) {
		
		super(zcode, price, rooms);
		YearlyTaxes = YearTaxes;
		
	}// Constructor ends here
	
	/*getYearlyTaxes--Method
	 *To Get the YearlyTaxes 
	 *@return YearlyTaxes
	 */
	public int getYearlyTaxes(){
		return YearlyTaxes;
	}

}// Class ends here
