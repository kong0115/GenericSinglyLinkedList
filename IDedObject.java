//interface is used to collect all the method signatures, and the interface is implemented in the class definition. 
public interface IDedObject {
	public abstract int getID(); //returns the ID of the object
	public abstract void printID(); //prints the details of the ID
	public abstract IDedObject deepCopy(); //make a deep copy of the object
}
