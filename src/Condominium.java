/*CondoMinium--extends House Class
 *To initiate the CondoMinium House Object using condoMinuim constructor
 *@param MaFees Maintenance Fees. 
 */
public class Condominium extends House {
  protected int MaFees;             // Maintenance Fees
   
  /* CondoMinium--Constructor
   * Initiates using super constructor
   * @param zcode Stores the ZipCode
   * @param price Stores the price
   * @param rooms Stores the rooms
   * @param Maintenance Stores the Maintenance Fees 
   */

  public Condominium(String zcode, int price, int rooms, int Maintenance ) {
		
		super(zcode, price, rooms);
		MaFees = Maintenance;
		
	}// Constructor ends here
	
    /*getMaFees--Method to get the Maintenance fees
	 *@return MaFees Stores the Maintenance Fees of the House Object. 
	 */

  public int getMaFees(){
		
		return MaFees;
	}

  }// Class Condominium ends here
