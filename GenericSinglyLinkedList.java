//a generic singly linked list class that can hold any objects
public class GenericSinglyLinkedList <AnyType extends IDedObject> {
	private Node<AnyType> head; //a sentinel

	public GenericSinglyLinkedList( ) //default constructor
	{
		makeEmpty( );
	}

	public void makeEmpty( )//empties the linked list 
	{
		head = new Node<>(null, null);
	}

	public boolean isEmpty( ) //method to check if the list is empty
	{
		if(head.next == null)
		{
			return true;
		}
		else
			return false;
	}

	//Get the generic type to get the particular id and returns AnyType. Returns null if the list is empty or ID not found. 
	public AnyType findID(int ID) 
	{
		Node<AnyType> current = head.next;
		while (current != null  &&  current.data.getID() != ID)
		{
			current = current.next; 
		}
		
		if(current != null) //returns AnyType if the ID is found in the list
			return  (AnyType) current.data.deepCopy();
		else
			return null; //returns null if the list is empty or ID not found. 
	}

	//insert at front of list or return false if that ID already exists 
	public boolean insertAtFront(AnyType x)
	{  
		Node<AnyType> newNode = new Node<>(null, null);
		if(findID(x.getID()) != null) //the ID was already existed
		{
			return false; //insertion fail
		}
		
		else	//insert the record at the front of list
		{
			newNode.next = head.next;
			head.next = newNode;
			newNode.data = (AnyType) x.deepCopy();
			return true;  //insertion successful
		}
	}

	//delete and return the record at the front of the list or return null if the list is empty 
	public AnyType deleteFromFront()
	{
		Node <AnyType> temp = new Node<>(null,null);
		if (isEmpty()) //check if the list is empty
		{
			return null; //deletion fail
		}
		else  //return the first item on the list and delete it
		{
			temp = head.next;
			head.next = head.next.next;
			return  (AnyType) temp.data.deepCopy();
		}
	}
	
	//find and delete the record with the given ID or returns null if it isn’t found 
	public AnyType delete(int ID) 
	{
		Node<AnyType> previous = head; 
		Node<AnyType> current = head.next;
		Node<AnyType> temp = new Node<> (null, null);
		while (current != null  &&  current.data.getID() != ID) 
		{
			previous = current;	
			current = current.next; 
		}
		
		if(current == null) //the record with the given ID is not found, deletion fail
			return  null; 
		else	//the record with the given ID is found, return and delete the record
		{
			temp = current;
			previous.next = current.next;
			return (AnyType) temp.data.deepCopy();
		}
	}
	
	//print all elements in the order they appear in the linked list. if list is empty print appropriate message.
	public void printAllRecords()
	{
		Node<AnyType> current = head.next;
		int count = 1;
		if(isEmpty()) //check if the list is empty
		{
			System.out.println("The list is empty.");
		}
		else	//the list is not empty
		{
			while (current != null) //continue to traverse the list
			{   
				System.out.println("Item " + count); 
				current.data.printID(); //print the details of the item
				current = current.next; //point to the next item
				count++; //count the number of items
			}

		}
	}	
	
	private static class Node<AnyType>
	{
		public AnyType data;  //contains the data
		public Node<AnyType>   next; //point to the next item in the list

		public Node( AnyType d, Node<AnyType> n ) //constructor that takes 2 arguments to initialize the attributes
		{
			data = d; next = n;
		}

	}
}
