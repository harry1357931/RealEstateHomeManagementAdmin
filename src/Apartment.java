/* Apartment- extends Class House
 * Initiates the Apartment House Object using Super Constructor from House Class
 * Price is considered as RENT in Apartment Object
 * @author Gurpreet Singh
 */
public class Apartment extends House {
     //Price as Rent
	 //Constructor--Apartment
	
	/* Apartment Constructor
	 * @param zcode stores the Zipcode
	 * @param rent  stores the rent
	 * @param rooms stores the rooms
	 */
   public Apartment(String zcode, int rent, int rooms) {
		
		super(zcode, rent, rooms);
	
   }// Constructor ends here

}// Class- Apartment ends here
