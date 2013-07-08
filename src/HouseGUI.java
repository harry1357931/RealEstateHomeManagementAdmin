import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.StringTokenizer;
import java.io.*;
/* HouseGUI- Class
 * Initiates the JFrame,ContentPane, Two JText Areas-Sorted and Unsorted, MenuBar,Menus, JMenuItems
 * JMenuBar Contains File, Edit, List.
 * JMenu-File(Open, SaveAs, Exit), Edit(Insert, Delete), List(ALL, PrivateHouses, Condominiums, PrivateHouses)
 * Event Handlers for each JMenuItems using ActionListener.
 * Also Contains FileMenuHandler Class, EditMenuHandler Class, ListMenuHandler Class to Handle Each Menu
 * Classes Mentioned above implements ActionListener.
 * Display All  HouseLists in Unsorted and Sorted Way after each event.
 * @author Gurpreet Singh
 */
public class HouseGUI extends JFrame {
	 public  UnsortedHouseList myUnsortedList = new UnsortedHouseList();
	 public  SortedHouseList mySortedList = new SortedHouseList();
	  
	 public JTextArea Unsorted, Sorted;
      
	 /*HouseGUI--Constructor 
   	  *Initializes the JTextAreas, SetSize, SetLayout, Add Scroll Panes to TextAreas
   	  *Calling functions for creating: FileMenu, EditMenu, ListMenu. 
   	  *@param title Title of JFrame
   	  *@param height Height of JFrame
   	  *@param width Width of JFrame 
	  */
      public HouseGUI(String title, int height, int width) {
		   Unsorted = new JTextArea();
	       Sorted = new JTextArea();
	       Unsorted.setPreferredSize(new Dimension(250, 350));
	       Sorted.setPreferredSize(new Dimension(250, 350));
	       Unsorted.append("Unsorted House Lists: "+"\n");
	       Sorted.append("Sorted House Lists: "+"\n");
	       
	       getContentPane().setLayout(new GridLayout(1,2));
		   getContentPane().add(new JScrollPane(Unsorted));
		   getContentPane().add(new JScrollPane(Sorted));
		   pack();
		   setVisible(true);
		   
	        setTitle(title);
		    setSize(height,width);
	        setLocation(400,200);
		    createFileMenu();
		    createEditMenu();
		    createListMenu();
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setVisible(true);
	        
	   } //HouseGUI Constructor
	 
	  
      /*CreateFileMenu---To CreateFileMenu
       *Initializes JMenuBar, JMenu, JMenuItems, FileMenuHandler
       *Adding each MenuItem Open, SaveAs, Exit to JMenu.
       *Adding actionListener to Handle Events
       *@param menuBar For Initiating a MenuBar   
  	   *@param fileMenu For Drop Down FileMenu
  	   *@param item   For JMenu Item--Open, SaveAs, Exit.
  	   *@param fmh FileMenu Handler to Handle events
  	   */
     private void createFileMenu() {
	      JMenuItem   item;
	      JMenuBar    menuBar  = new JMenuBar();
	      JMenu       fileMenu = new JMenu("File");
	      FileMenuHandler fmh  = new FileMenuHandler(this);

	      item = new JMenuItem("Open");    //Open...
	      item.addActionListener( fmh );
	      fileMenu.add( item );
          fileMenu.addSeparator();           //add a horizontal separator line
          
	      item = new JMenuItem("SaveAs");    //Open...
	      item.addActionListener( fmh );
	      fileMenu.add( item );
          fileMenu.addSeparator();           //add a horizontal separator line

	      item = new JMenuItem("Exit");      //Quit
	      item.addActionListener( fmh );
	      fileMenu.add( item );

	      setJMenuBar(menuBar);
	      menuBar.add(fileMenu);
	    
	   } //createFileMenu ends here
	 
     /*CreateEditMenu---To CreateEditMenu
      *Initializes JMenuBar, JMenu, JMenuItems, FileMenuHandler
      *Adding each MenuItem Insert, Delete to JMenu.
      *Adding actionListener to Handle Events
      *@param menuBar For Initiating a MenuBar   
      *@param editMenu For Drop Down FileMenu
 	  *@param item   For JMenu Items Insert, Delete
 	  *@param emh EditMenu Handler to Handle events
 	  */
      private void createEditMenu() {
	      JMenuItem   item2;
	      JMenuBar    menuBar  = this.getJMenuBar();
	      JMenu       editMenu = new JMenu("Edit");
	      EditMenuHandler emh  = new EditMenuHandler(this);

	      item2 = new JMenuItem("Insert");    //Open...
	      item2.addActionListener( emh );
	      editMenu.add(item2);
          editMenu.addSeparator();           //add a horizontal separator line
         
	      item2 = new JMenuItem("Delete");    //Open...
	      item2.addActionListener( emh );
	      editMenu.add(item2);
	      
	      setJMenuBar(menuBar);
	      menuBar.add(editMenu);
	    
	   } //createEditMenu
      /*CreateListMenu---To CreateListMenu
       *Initializes JMenuBar, JMenu, JMenuItems, ListMenuHandler
       *Adding each MenuItem ALL, PrivateHouses, Apartments, CondoMiniums to JMenu.
       *Adding actionListener to Handle Events
       *@param menuBar For Initiating a MenuBar   
       *@param ListMenu For Drop Down ListMenu
  	   *@param item   For JMenu Items ALL, PrivateHouses, Apartments, CondoMiniums
  	   *@param lmh ListMenu Handler to Handle events
  	   */
     private void createListMenu() {
	      JMenuItem   item3;
	      JMenuBar    menuBar  = this.getJMenuBar();
	      JMenu       listMenu = new JMenu("List");
	     ListMenuHandler lmh  = new ListMenuHandler(this);
 
	      item3 = new JMenuItem("All");    //Open...
	      item3.addActionListener( lmh );
	      listMenu.add(item3);
         listMenu.addSeparator();           //add a horizontal separator line
        
	      item3 = new JMenuItem("PrivateHouses");    //Open...
	      item3.addActionListener( lmh );
	      listMenu.add(item3);
	      listMenu.addSeparator();           //add a horizontal separator line
	      
	      item3 = new JMenuItem("Condominiums");    //Open...
	      item3.addActionListener( lmh );
	      listMenu.add(item3);
         listMenu.addSeparator();           //add a horizontal separator line
        
	      item3 = new JMenuItem("Apartments");    //Open...
	      item3.addActionListener( lmh );
	      listMenu.add(item3);
	    
	      
	      setJMenuBar(menuBar);
	      menuBar.add(listMenu);
	    
	   } //createEditMenu

     
     /*FileMenuHandler Class--To Handle Events for Open, SaveAs, Exit.
      *Implements ActionListener to Handle Events
      *Open calls- Choose file from JFile Chooser, Read File and Save them in Unsorted and SortedLists 
 	  * and then Display them
 	  *SaveAs--Saves the List on a TextFile
 	  *Exit- Exit From Program
 	  *@param jframe   
 	  */
     public class FileMenuHandler implements ActionListener {
		   JFrame jframe;
		   
		   public StringTokenizer myTokens;
		   
		   /*FileMenuHandler-Constructor
			*@param jframe  
			*/
          public FileMenuHandler (JFrame jf) {
		      jframe = jf;
		   }
		    /* Method-- ActionPerformed 
			 * Calls specific methods according to specific events
			 * Event handles through ActionEvent
			 * @param menuName To Save the name of action event
			 * @param event  the event that user chooses
			 */
           public void actionPerformed(ActionEvent event) {
		      String menuName = event.getActionCommand();

		      if (menuName.equals("Open"))
		          openFile(); 
		      else if (menuName.equals("SaveAs"))
		          SaveAs();
		      else if (menuName.equals("Exit"))
		          System.exit(0);    
		      
		   } //actionPerformed
           /*openFile()-- Method
            *Uses JFileChooser to Select the File.
            *Calls the readFile Method to save the Houses in Unsorted and Sorted House Lists 
       	    *Calls the method to append those lists to JTextAreas and Display them. 
       	    */

           public void openFile(){
			   JFileChooser  chosenfile= new JFileChooser();
			   chosenfile.showOpenDialog(null);
			   File f = chosenfile.getSelectedFile();    
			   System.out.println(f.getName());
			   readFile(myUnsortedList, mySortedList, f);
			   ADD(myUnsortedList, mySortedList);
			   //"C:\\Users\\Leader\\Workspace\\Project4\\project4-data-good.txt"
		   }// openfile
		   
		   //Save As 
           /*SaveAs--Method
            *Uses JFileChooser to Select the Text File.
       	    *Write Sorted and Unsorted Lists on that Text File And Saves That text File.
       	    */

           public void SaveAs(){
			   JFileChooser  chosenfile= new JFileChooser();
			   chosenfile.showSaveDialog(null);
			   File f = chosenfile.getSelectedFile();    
			   
			  try{ PrintStream out = new PrintStream(new FileOutputStream(f.getName()));
		       HouseNode p1= myUnsortedList.first.next;
		       System.out.println(f.getName()); 
		        while (p1!= null) {
					  System.out.println(p1.data.toString()+"ganges");
			           out.println(p1.data.toString()+"\n");
			           p1 = p1.next;
				  
					}//while loop ends here
		        HouseNode p2= mySortedList.first.next;
		        out.println();
		        while (p2!= null) {
					   
		        	   out.println(p2.data.toString()+"\n");
			           p2 = p2.next;
				  
					}//while loop ends here

		      out.close();
			  }catch(FileNotFoundException e){
			      e.printStackTrace();
			    }
			   
		   }
		   
		   
           /* readFile--Method to Read Houses from TextFiles
       	    * Read Houses from text file and saves them in two Sorted and Unsorted Lists
       	    */

           public void readFile(UnsortedHouseList UnList, SortedHouseList SList, File f)  //think over xyz..change it
			{   String fileName= f.getName();
				TextFileInput tfi= new TextFileInput(fileName);
				String line = tfi.readLine();
				
		    	while(line.length() != 0)
				{   House d= HouseTextFormat.parseHouse(line);
				    System.out.println("  "+line);
				    if(d==null){
				      try{ throw new HouseTextFormatException("Invalid House Format: "+line);
				      }catch(HouseTextFormatException e){
				    	 // System.out.println(e+"Invalid House Format: "+line);
				        }
				       line = tfi.readLine();
				       continue;
				      }
				    
					UnList.insert(d);
					SList.insert(d);
					line = tfi.readLine();
					
				}// while loop ends here

			}// Read File method ends here 
		   //ADD Method--Appending Lists to TextAreas
           /*
         	 * 
         	 */

		   public void ADD(UnsortedHouseList Unlist, SortedHouseList Solist) 
			  {  // Appending Unsorted list
				  HouseNode p1 = Unlist.first.next;
				  while (p1!= null) {
			           Unsorted.append(p1.data.toString()+"\n");
			           p1 = p1.next;
				  
					}//while loop ends here
				//Appending Sorted list
				 HouseNode p2 = Solist.first.next;
				 while (p2 != null) {
		            Sorted.append(p2.data.toString()+"\n");
     				p2 = p2.next;
   				}//while loop ends here
			  }// Add method ends here	 
           
			  }//FileMenu Class ends here
	     
	 //ListMenu Class
     /*ListMenuHandler Class--To Handle Events for All, PrivateHouses, Apartments, CondoMiniums.
      *Implements ActionListener to Handle Events
      *ALL- Displays All Houses in JFrame
 	  *PrivateHouses- Displays Private Houses in Sorted and Unsorted way
 	  *CondoMinums- Displays CondoMiniums in Sorted and Unsorted way
 	  *Apartments- Displays Apartments in Sorted and Unsorted way according to their rent
 	  *@param jframe   
 	  */
	 public class ListMenuHandler implements ActionListener {
			JFrame jframe;

			/*ListMenuHandler-Constructor
			*@param jframe  
			*/
             public ListMenuHandler (JFrame jf) {
			      jframe = jf;
			   }
             /* Method-- ActionPerformed 
 			 * Calls specific methods according to specific events
 			 * Event handles through ActionEvent
 			 * @param menuName To Save the name of action event
 			 * @param event  the event that user chooses
 			 */
             public void actionPerformed(ActionEvent event) {
			      String menuName = event.getActionCommand();
			      if (menuName.equals("All"))
			           DisplayALL(myUnsortedList, mySortedList);
			      else if (menuName.equals("PrivateHouses"))
			    	  DisplayPrivateHouses(myUnsortedList, mySortedList);
			      else if (menuName.equals("Condominiums"))
			    	  DisplayCondominiums(myUnsortedList, mySortedList);
			      else if (menuName.equals("Apartments"))
			    	  DisplayApartments(myUnsortedList, mySortedList);
			   } //actionPerformed
             /*DisplayAll- Method
			    *To fill Out Unsorted and Sorted Text Areas 
			    *To Display Unsorted and Sorted House Lists on JText Areas
			    *@param Unlist Unsorted House List  
				*@param Solist Sorted House List
				*/
			   public  void DisplayALL(UnsortedHouseList Unlist, SortedHouseList Solist) 
				  {  // Appending Unsorted list
				   setTitle("ALL Houses");
				    Unsorted.setText("");
				    Sorted.setText("");
					  HouseNode p1 = Unlist.first.next;
					  while (p1!= null) {
						  
				           Unsorted.append(p1.data.toString()+"\n");
				           p1 = p1.next;
					  
						}//while loop ends here
					//Appending Sorted list
					 HouseNode p2 = Solist.first.next;
					 while (p2 != null) {
			            Sorted.append(p2.data.toString()+"\n");
	     				p2 = p2.next;
	   				}//while loop ends here
					
				  }// Add method ends here	 
			   /*DisplayPrivateHouses- Method
			    *To fill Out Unsorted and Sorted Text Areas 
			    *To Display Private Houses in Unsorted and Sorted House Lists on JText Areas
			    *@param Unlist Unsorted House List  
				*@param Solist Sorted House List
				*/
			   public  void DisplayPrivateHouses(UnsortedHouseList Unlist, SortedHouseList Solist) 
				  {  // Appending Unsorted list
				   setTitle("Private Houses");
				    Unsorted.setText("");
				    Sorted.setText("");
					  HouseNode p1 = Unlist.first.next;
					  while (p1!= null) {
						  if(p1.data instanceof PrivateHouse)
				              Unsorted.append(p1.data.toString()+"\n");
				           p1 = p1.next;
					  
						}//while loop ends here
					//Appending Sorted list
					 HouseNode p2 = Solist.first.next;
					 while (p2 != null) {
						 if(p2.data instanceof PrivateHouse)	 
			                  Sorted.append(p2.data.toString()+"\n");
	     				p2 = p2.next;
	   				}//while loop ends here
					
				  }// Add method ends here	 
			   /*DisplayCondminiums- Method
			    *To fill Out Unsorted and Sorted Text Areas 
			    *To Display CondoMiniums in Unsorted and Sorted House Lists on JText Areas
			    *@param Unlist Unsorted House List  
				*@param Solist Sorted House List
				*/
			   public  void DisplayCondominiums(UnsortedHouseList Unlist, SortedHouseList Solist) 
				  {  // Appending Unsorted list
				   setTitle("Condominiums");
				    Unsorted.setText("");
				    Sorted.setText("");
					  HouseNode p1 = Unlist.first.next;
					  while (p1!= null) {
						  if(p1.data instanceof Condominium)
				              Unsorted.append(p1.data.toString()+"\n");
				           p1 = p1.next;
					  
						}//while loop ends here
					//Appending Sorted list
					 HouseNode p2 = Solist.first.next;
					 while (p2 != null) {
						 if(p2.data instanceof Condominium)
						    Sorted.append(p2.data.toString()+"\n");
	     				p2 = p2.next;
	   				}//while loop ends here
					
				  }// Add method ends here	 
			   /*DisplayApartments- Method
			    *To fill Out Unsorted and Sorted Text Areas 
			    *To Display Apartments in Unsorted and Sorted House Lists on JText Areas
			    *@param Unlist Unsorted House List  
				*@param Solist Sorted House List
				*/
               
			   public  void DisplayApartments(UnsortedHouseList Unlist, SortedHouseList Solist) 
				  {  // Appending Unsorted list
				   setTitle("Aparments");
				    Unsorted.setText("");
				    Sorted.setText("");
					  HouseNode p1 = Unlist.first.next;
					  while (p1!= null) {
						  if(p1.data instanceof Apartment)
				              Unsorted.append(p1.data.toString()+"\n");
				           p1 = p1.next;
					  
						}//while loop ends here
					//Appending Sorted list
					 HouseNode p2 = Solist.first.next;
					 while (p2 != null) {
						 if(p2.data instanceof Apartment)	 
			                  Sorted.append(p2.data.toString()+"\n");
	     				p2 = p2.next;
	   				}//while loop ends here
					
				  }// Add method ends here	 

			   
		}//Class List Menu ends here

	 /*EditMenuHandler Class--To Handle Events for Insert, Delete.
      *Implements ActionListener to Handle Events
      *Insert- Add house in Sorted and Unsorted List and Display them  
 	  *Delete- Delete House from Unsorted and Sorted List 
 	  *@param jframe   
 	  */
          public class EditMenuHandler implements ActionListener {
			JFrame jframe;
			   
			/*EditMenuHandler-Constructor
			*@param jframe  
			*/

			public EditMenuHandler (JFrame jf) {
			      jframe = jf;
			   }
			   /* Method-- ActionPerformed 
				 * Calls specific methods according to specific events
				 * Event handles through ActionEvent
				 * @param menuName To Save the name of action event
				 * @param event  the event that user chooses
				 */
			   public void actionPerformed(ActionEvent event) {
			      String menuName = event.getActionCommand();
			      if (menuName.equals("Insert"))
			           Insert(myUnsortedList, mySortedList);
			      else if (menuName.equals("Delete"))
			           Delete(myUnsortedList, mySortedList); 
			   } //actionPerformed
			    
			    /* Insert -- Method 
			     * Receives a House as a String through JOptionPane
				 * Insert that House in Sorted and Unsorted HouseLists
				 * Display them on JFrame
				 * @param UnList Unsorted House List
				 * @param SList Sorted House List
				 * @param line Stores the House in String Format using JOption Pane
				 */
			   
			   public void Insert(UnsortedHouseList UnList, SortedHouseList SList){
				   String line;
				   line=JOptionPane.showInputDialog(null, "Enter House to be Inserted :");
				   House d= HouseTextFormat.parseHouse(line);
				   UnList.insert(d);
				   SList.insert(d);
				   DisplayALL(myUnsortedList, mySortedList);
				   
			   }// Insert ends Here
			    
			    /* Delete- Method
			     * Receives a House As a String through JOptionPane
			     * Delete them From Unsorted and  Sorted HouseLists
			     * Display them on JFrame
			     * @param UnList Unsorted House List
				 * @param SList Sorted House List
				 * @param line Stores the House in String Format using JOption Pane
				 */
			   public void Delete(UnsortedHouseList UnList, SortedHouseList SList){
				   String line;
				   line=JOptionPane.showInputDialog(null, "Enter House to be Deleted :");
				   UnList.delete(line);
				   SList.delete(line);
				   DisplayALL(myUnsortedList, mySortedList);
				   
			   }// Delete ends here
			   /*DisplayAll- Method
			    *To fill Out Unsorted and Sorted Text Areas 
			    *To Display Unsorted and Sorted House Lists on JText Areas
			    *@param Unlist Unsorted House List  
				*@param Solist Sorted House List
				*/
			   
			   public void DisplayALL(UnsortedHouseList Unlist, SortedHouseList Solist) 
				  {  // Appending Unsorted list
				   setTitle("ALL Houses");
				    Unsorted.setText("");
				    Sorted.setText("");
					  HouseNode p1 = Unlist.first.next;
					  while (p1!= null) {
						   Unsorted.append(p1.data.toString()+"\n");
				           p1 = p1.next;
						}//while loop ends here
					//Appending Sorted list
					 HouseNode p2 = Solist.first.next;
					 while (p2 != null) {
			            Sorted.append(p2.data.toString()+"\n");
	     				p2 = p2.next;
	   				}//while loop ends here
					
				  }// Add method ends here	 
 
        }//Class EditMenu ends here
	 
   }// HouseGUI ends here
