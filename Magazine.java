
public class Magazine implements IDedObject{
	private int magazineID;
	private String magazineName;
	private String publisherName;
	
	public Magazine()  //default constructor that initializes the attributes
	{
		magazineID = 0;
		magazineName = "N/A";
		publisherName = "N/A";
	}

	public Magazine(int ID, String m, String p) //constructor that takes 3 arguments to initialize the attributes
	{
		magazineID = ID;
		magazineName = m;
		publisherName = p;
	}
	
	public void printID()  //method to print all the variable values in separate lines
	{
		System.out.println("Magazine ID: " + magazineID);
		System.out.println("Magazine Name: " + magazineName);
		System.out.println("Publisher Name: " + publisherName);
	}
	
	public int getID()	//method to return the magazineID
	{
		return magazineID;
	}
	
	public String getMagazineName()	//method to return the magazineName
	{
		return magazineName;
	}
	
	public String getPublisherName() //method to return the publisherName
	{
		return publisherName;
	}
	
	public Magazine deepCopy() //method that make a deep copy of the object
	{
		Magazine dCopy = new Magazine(magazineID,magazineName,publisherName);
		return dCopy;
	}
	
}
