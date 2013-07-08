/*Class-- SortedHouseList
 * Description:
 *  This class extends class HouseList to inherit its variables and functions.
 *  For Creating a Sorted HouseList 
 *@author Gurpreet Singh 
 * */
public class SortedHouseList extends HouseList {
	
	/*Constructor- UnsortedHouseList()
	 *This Constructor constructs a new UnsortedHouseList by calling super constructor inherited from
	 *HouseList Class.
	 * */
	public SortedHouseList() {
		super();
	}// Sorted class constructor
	
     /* delete-- Method to delete House Object and HouseNode from Unsorted House List
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
	           
	         }// last case
		   
		   while(p!=null){
		     
			if(p.next!=null)
			   if(p.next.data.toString().equals(line)){
		          x=p.next;
				 System.out.println(p.data.toString()+"kkkkkk");
		         p.next=p.next.next;
		         x.next=null;
		         continue;
			   }	 // Also make case for "last" or else use "break" here instead of continue
		         // To remove the Exception
		        
		     p=p.next;
		  
		 }// while ends here
		   
		} // Method delete ends here
	
	/*Method insert--To insert a new node into a SortedHouseList and it also initiates
	  * the new node with House object. Also, it sorts the HouseNode in the HouseList according to 
	  * Price by in Place Sorting Technique
	  * @param d  a House Object
	  */
     public void insert(House d) {
    	int count=0;
    	length++;
		HouseNode p = first.next;
	
   	   if(length==1)
		 { HouseNode n = new HouseNode(d);
		   last.next = n;            // do something with variables
		   last = n;
		   count=1;}
		else if(length==2)
		 {  
			//System.out.println(d.getPrice());
		   // System.out.println(p.data.getPrice());
			if(d.getPrice()>p.data.getPrice())
		       {  HouseNode n = new HouseNode(d);
			      last.next = n;            // do something with variables
			      last = n;
			      count=1;
 		       }
		     else {
		          HouseNode n = new HouseNode(d);
		          n.next=first.next;
		          first.next= n;        // may be first instead of first
		        count=1; }
			   
	    }// else if(length==2) ends here 
		else
		{ 
			while (p != null)
	   	    {	 
		       if(d.getPrice()<=p.data.getPrice())
		       {  
		          HouseNode n=new HouseNode(p.data);
		          n.next=p.next;
		          p.data=d;
		          p.next=n;
		          count=1;
		          break; 
		         
	      
		       }// if d.getPrice() 	
		       p=p.next;
	      }//while ends here
        
	}//else ends here
			      
	 if(count==0){		
		HouseNode n = new HouseNode(d);
		last.next = n;            
		last = n;}

      
   } // method insert (House)
	
}// Class SortedHouseList ends here
