
import java.util.*;
import javax.swing.*;
/**
 * Class House-
 * @param Zipcode Stores the ZipCode for different objects instantiated in class Project2
 * @param Price Stores the price for different objects instantiated in class Project2
 * @param Rooms Store the rooms for different objects instantiated in class Project2
 * There are many methods to get Price, rooms and Zipcode and other methods to check the validity
 * of the house object. There are also constructor method to instantiate the object
 * @author Gurpreet Singh
 */
public abstract class House {
	public static StringTokenizer myTokens;
	protected  int Price, Rooms;
    protected  String ZipCode;
    //public String HouseText;
    /*
     *To get the Zipcode outside this file 
     *@return ZipCode To get the zipcode
     */
    public  String getZipCode()
    { return ZipCode;
      }
    /**
     * getNumberOfRooms()-Method
     * To get the Rooms in other Java File like Project2.java
     * @return Rooms saves the Rooms in a house
     */
     public int getNumberOfRooms()
     { return Rooms;
     }
    /**
     * getPrice()- Method
     * To get the Price of a house in other Java File like Project2.java
     * It returns the private integer variable called Price
     * @return Price Value to be returned
     */
     public int getPrice()
    {
    	 return Price;	
      }
    /**
     * setPrice -Method
     * Sets price equal to that in house String and throws illegal argument exception if
     * the price is greater than 999999. In Actual Assignment there are 6 Nine's
     * However, I used 6 Nine's ...because it will throw illegal Argument Exception if price is greater 
     * than six 999999...and in three house objects price is greater than six Nine's 
     * which will stop the program.
     * @param price  Price of House Object
     */
     public void setPrice(int price)
     {   this.Price= price;
    	 try{ if( (price<1)|| (price>999999) )
                  throw new IllegalHouseException ("Price should be from 1 to 999999"); 
        }catch(IllegalHouseException e)
        { 
        	System.out.print(e+" Price is Invalid: "+price);
        }
         
     }   
   /**
    *compareTo- 
    *Compare two House Objects on the basis of Price and returns integer value.
    *Returns negative value if H1<H2(House 1 less than House2 )-on Price basis
    *Returns Positive value if H1>H2(House 1 greater than House2 )-on Price Basis  
    *Returns Zero if H1=H2(House 1 equal to House2 )-on Price Basis
    * @param other  Second House object to be compared
    * @return nback  Returns negative, positive and zero integer value.
    */
    public int compareTo(House other)
    { 
         int vhouse1=0, vhouse2=0, nback;                           
        
         vhouse1=this.Price;
		 vhouse2=other.Price;
				
	     if(vhouse1<vhouse2)
	    	 nback= -1;
	     else if(vhouse1>vhouse2)
	    	 nback=1;
	     else
	    	nback=0;
	     
	   return nback;      
    }
    /**
     * equals method-
     * To check if two objects are equal or not
     * It compares class and data fields to verify the equality
     *@param other  House Object
     */
    public boolean equals(Object other)
      {
        return ( other != null
           && getClass() == other.getClass()
           && (ZipCode.equals(((House) other).ZipCode)&&
        	(Price==(((House)other).Price))&&(Rooms==(((House)other).Rooms)))
        	);

      }// equal method ends here
   /**
    * isValidHouse()-Boolean Method-
    * This method checks the format of the House string obtained from text file 
    * and it also checks if it is tokenized into three values or not 
    * @return true if the house is valid
    * @return false if the house is not valid
    */
    public boolean isValidInput(String house)
    {  
                      
        myTokens= new StringTokenizer(house, "|");
        if(myTokens.countTokens()!=0)     
            return true;
	    else
	    { JOptionPane.showMessageDialog(null, "Invalid House...Cannot be tokenized into three values");
	    	return false;
	    }
    } // isValidInput function ends here
   
     /**
      * toString()- Method-
      * Returns the House String
      *@return HouseText returns the House String 
      */
    public String toString()
    {  if(this instanceof PrivateHouse)
    	   return "P|"+ZipCode+"|"+Price+"|"+Rooms+"|"+((PrivateHouse)this).getYearlyTaxes();
       else if(this instanceof Apartment)
    	   return "A|"+ZipCode+"|"+Price+"|"+Rooms;
       else if(this instanceof Condominium)
    	   return "C|"+ZipCode+"|"+Price+"|"+Rooms+"|"+((Condominium)this).getMaFees();
    
       return null;   
     }
    /**
     * Constructor-Three Parameters-
     * This constructor constructs the object and throws an illegal argument exception
     * if the house is not valid that is not in proper format, input values are not valid. 
     * Also, it throws illegal argument exception if the price, number of rooms and 
     * zipCode is not in between desired range else it sets the values of 
     * object equal to values mentioned in the string
     * @param zipCode zipCode of house 
     * @param price   price of house
     * @param NumberOfRooms number of rooms in the house
     * @param HouseText contains the house as a string to check further validation ...It is return`
     * by toString() method
     */
    public House(String zipCode, int price, int NumberOfRooms)     
    {  
      // HouseText=zipCode+"|"+price+"|"+NumberOfRooms; // For return by toString() method
       if( isValidInput(this.toString()) )
              {   setPrice(price);   	
    	          this.ZipCode=zipCode;
    	          this.Rooms= NumberOfRooms;
    	        try{ if( NumberOfRooms < 1){
    	        	  throw new IllegalHouseException("Rooms Should be greater than 1 :");  
    	           }
    	        }catch(IllegalHouseException e){
    	        	System.out.print(e);
    	        }
             }
       else// if input is not valid....throws argument exception
        	  throw new IllegalHouseException("The Input is not valid");  
      
    }// Constructor House ends here.

}//Class-House ends here.
