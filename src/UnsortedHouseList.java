/*Class-- UnsortedHouseList
 *This class extends class HouseList to inherit its variables and functions.
 *For Creating a Unsorted HouseList 
 *@author Gurpreet Singh 
 * */
 public class UnsortedHouseList extends HouseList {

	 /* Method insert--To insert a new node into a UnsortedHouseList and it also initiates
	  * the new node with House object
	  * @param d  a House Object
	  */
	 public void insert(House d) {
		
		  HouseNode n = new HouseNode(d);
		  last.next = n;            
		  last = n;
		  length++;
		  
	} // Method -- insert ends here
	 
	 /* delete-- Method to delete House Object from Unsorted House List
	  * @param line House String entered by User to be deleted
	  */
	 public void delete(String line) {
		   HouseNode p= first.next;
		   HouseNode x;
		   // if line= first element
		   if(line.equals(first.next.data.toString())){
	    		 first.next=p.next;
	    		 p=p.next;
	    	}
		   if(last.data.toString().equals(line)){
	         	 last=p;
	        	 p.next=null;
	           
	         }// If House Object is Last
		   
		   while(p!=null){
		     
			if(p.next!=null)
			   if(p.next.data.toString().equals(line)){
		          x=p.next;
		         p.next=p.next.next;
		         x.next=null;
		         continue;
			   }	 
		         
		      p=p.next;
		  
		  }// while ends here
		   
		} // Method delete ends here
	
	 /*Constructor- UnsortedHouseList()
	 *This Constructor constructs a new UnsortedHouseList by calling super constructor inherited from
	 *HouseList Class.
	 */
	public UnsortedHouseList() {
		super();
	}// Unsorted Class constructor

}// Class Unsorted ends here
