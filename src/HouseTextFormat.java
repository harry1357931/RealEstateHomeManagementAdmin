import java.util.StringTokenizer;
/*HouseTextFormat--Class
 *Check the House String, check its format, check whether it's tokenizable or not
 *Throws HouseTextFormat Exception if the format is invalid
 *Throws IllegalArgument Exception if the price, ZipCode and other parameters of Object House are
 *not Valid. Initiates the House and then return it.
 *@param line  String of Line
 *@return HouseObject
 *@author Gurpreet Singh 
 */
public class HouseTextFormat {
	
	public static StringTokenizer myTokens;
	/*parseHouse--Method
	 *Check the House String, check its format, check whether it's tokenizable or not
     *Throws HouseTextFormat Exception if the format is invalid
     *Throws IllegalArgument Exception if the price, ZipCode and other parameters of Object House are
     *not Valid. Initiates the House and then return it. 
	 *@param line House in string format taken from text file.
	 *@param Htype Stores the House Type
	 *@param price Stores the Price
	 *@param rooms Store the rooms
	 *@param zcode 
	 */
	public static House parseHouse(String line){
		char Htype;
	    int price, rooms, NTokens;
	    String zcode;
		
   try{  
	    if(line.contains("|")==false){
	    	throw new HouseTextFormatException(" Invalid House Format , Untokenizable line: ");
	    }else{
	         myTokens = new StringTokenizer(line,"|");
	         NTokens= myTokens.countTokens();
		     Htype=  myTokens.nextToken().charAt(0);    
		     zcode=  myTokens.nextToken();
		     
		     
		     if(zcode == null){
					throw new HouseTextFormatException("Invalid zcode " + zcode + ": Zip code can't be null.");
				}else if(zcode.isEmpty() == true){
					throw new HouseTextFormatException("Invalid zipCode " + zcode + ": Zip code can't be empty string.");
				}else if(Integer.parseInt(zcode)==  123){
			        throw new HouseTextFormatException("Zipcode must contains all numbers"+line);	
				} else{  
		           if(Htype=='P')  
		           {  if(NTokens!= 5)
		               {
		        	     throw new HouseTextFormatException("PrivateHouse in Improper Format: ");
		               }
		             price= Integer.parseInt(myTokens.nextToken());
		             rooms= Integer.parseInt(myTokens.nextToken());
			           return new PrivateHouse(zcode, price, rooms, Integer.parseInt(myTokens.nextToken()));
		           }
		           else if(Htype=='A')
	               {   if(NTokens!=4)
	                    {
	                      throw new HouseTextFormatException("Apartment in Improper Format: ");
	                    }
	                    price= Integer.parseInt(myTokens.nextToken());
	                    rooms= Integer.parseInt(myTokens.nextToken());
			           return new Apartment(zcode, price, rooms);
		           }
		           else if(Htype=='C')    
		           {   if(NTokens!=5)
	                      {
		        	         throw new HouseTextFormatException("Condo in Improper Format: ");
	                       }
		                 price= Integer.parseInt(myTokens.nextToken());
		                 rooms= Integer.parseInt(myTokens.nextToken());		        	   
			           return new Condominium(zcode, price, rooms, Integer.parseInt(myTokens.nextToken()));
	               }
		       }// else
	       }// main else ends
	    
        }catch (HouseTextFormatException e){
       	      System.out.print(e);
        }catch (Exception e){
          	  System.out.print(e+" Bad House line: ");
        }
         
        return null;
		
	}//Method parseHouse ends here
	
}// Class HouseTextFormat ends here
