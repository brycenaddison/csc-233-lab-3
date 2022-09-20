package utilities;
import java.util.Comparator;
import java.util.ArrayList;



/**
 * Creates an ArrayList that can store many equivalence classes
 * @author ReganRichardson
 *
 * @param <T>
 */
public class EquivalenceClasses<T> {

	protected Comparator<T> _comparator;
	
	protected ArrayList<LinkedEquivalenceClass<T>> _classes;
	
	
	public EquivalenceClasses(Comparator<T> comp){
		
		_comparator = comp;
		
		_classes = new ArrayList<LinkedEquivalenceClass<T>>();
		
	}
	
	
	/**
	 * add element to list
	 * @param element
	 * @return
	 */
	public boolean add(T element) {
		
		int index = indexOfClass(element);
		
		//If the the location of the class does not exist, create a new LinkedEquivalenceClass to add the element to
		if (index == -1) {
			
			LinkedEquivalenceClass<T> tempClass = new LinkedEquivalenceClass<T>(_comparator);
			
			tempClass.add(element);
			
			_classes.add(tempClass);
			
			return true;
			
			//return this.add(element);
		}
		
		//if the class does exist, add the element to it
		return _classes.get(index).add(element);	
		
		
	}
	
	
	/**
	 * Checks if target is contained in the list
	 * @param target
	 * @return
	 */
	public boolean contains(T target) {
		
		for (LinkedEquivalenceClass<T> item : _classes) {
			
			if (item.contains(target) == true){
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	
	/**
	 * returns size of entire ArrayList
	 * @return
	 */
	public int size() {
		
		int counter = 0;
		
		//iterate through each item in class to get size and adds them together
		for (LinkedEquivalenceClass<T> item : _classes) {
			
			counter = item.size() + counter;
			
		}
		
		return counter;
		
	}
	
	
	/**
	 * returns the size of a specific LinkedList
	 * @return
	 */
	public int numClasses() {
		
		return _classes.size();
		
	}
	
	
	/**
	 * Returns the index of class in our list
	 * @param element
	 * @return
	 */
	protected int indexOfClass(T element) {
		
		return _classes.indexOf(element);
		
	}
	
	
	/**
	 * Returns string
	 */
	public String toString() {

		String newString = "";
		
		for (LinkedEquivalenceClass<T> item : _classes) {
			
			newString = newString + "\n" + item.toString();
			
		}
		
		return newString;
		
	}
	
	
	
}
