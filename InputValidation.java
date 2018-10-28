//a class that is used to test the input validation from the user
public class InputValidation {
	/**A method to test if the string contains only 0 - 9
	 * @param x A parameter that represents a string
     * @return false if the string contains at least one element other than 0 - 9 or the string is empty
     * @return true if the string is not empty and the string contains only 0 - 9
     */
	public static boolean isPositiveNumber(String x) {
	    if (x == null || x.isEmpty()) { 
	        return false;
	    }

	    for (int index = 0; index < x.length(); index++) {	//loop through each element in the string to see if it is digit
	        if (!Character.isDigit(x.charAt(index))) {
	            return false;
	        }
	    }
	    return true;
	}
}
