/*Class HouseList
 * Initiates a linked list with first, last and length variables and a dummy node
 * @param first Stores the reference to first House in HouseList  
 * @param last  Stores the reference to last house in HouseList
 * @param length Stores the no. of House Objects in linked list or length of Linked List
 * @author Gurpreet Singh
 * */

public abstract class HouseList {
	  

	/** First node in linked list - dummy node */
	 protected HouseNode first;

	/** Last node in linked list */
	protected HouseNode last;
    
	/** Number of data items in the list. */
	protected int length;

	/**
	 * Gets the number of data values currently stored in this LinkedList.
	 * 
	 * @return the number of elements in the list.
	 */

	/* public int getLength() {
		return length;
	}
	public HouseNode getLast() {
		return last;
	}
	public HouseNode getFirst() {
		return first;
	}
	
	public void setLength(int glength)
	{ 
		length=glength;
	}
	public void setLast(HouseNode glast)
	{  
		last=glast;
	}
	public void setFirst(HouseNode gfirst)
	{
		first=gfirst;
	}
	*/
	
	/* HouseList- Constructor
	 * Constructs a dummy node
	 * @param dummy dummy Node
	 * */
	    public  HouseList(){
    	                            
    	HouseNode dummy = new HouseNode(null);
    	first = dummy;
    	last = dummy;
    	length = 0;

    }
    
	/**
	 * @return String representation of elements in linked list delimited by a
	 *         space character
	 */
	
	/**
	 * Determines whether this ShortSequenceLinkedList is equal in value to the
	 * parameter object. They are equal if the parameter is of class
	 * ShortSequenceLinkedList and the two objects contain the same short
	 * integer values at each index.
	 * 
	 * @param other
	 *            the object to be compared to this ShortSequenceLinkedList
	 * 
	 * @return <code>true</code> if the parameter object is a
	 *         ShortSequenceLinkedList containing the same numbers at each index
	 *         as this ShortSequenceLinkedList, <code>false</code> otherwise.
	 */
	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass()
				|| length != ((HouseList) other).length)
			return false;

		HouseNode nodeThis = first;
		HouseNode nodeOther = ((HouseList) other).first;
		while (nodeThis != null) {
			// Since the two linked lists are the same length,
			// they should reach null on the same iteration.

			if (nodeThis.data != nodeOther.data)
				return false;

			nodeThis = nodeThis.next;
			nodeOther = nodeOther.next;
		} // while

		return true;
	} // method equals

}
