/*Class- House Node
 * HouseNode initiates a new node for House Linked List and each node contains a one House Object
 * and next for pointing to next address
 * @param data Object of Type 'House' to hold a 'house' record
 * @param next pointer to next 'HouseNode'
 * @author Gurpreet Singh
 * */
public class HouseNode {

	   House data;
	   HouseNode next;

	   /* Constructor--HouseNode
	    * Constructs a HouseNode and Stores the House Object in that Node
	    * @param h  Contains the House Object
	    * @param data To Store the House Object
	    * @param next For Reference to next node
	    * */
        public HouseNode(House h)
	    {
	      data = h;
	      next = null;
	    }// HouseNode Constructor ends here
	   
}// Class HouseNode ends here
