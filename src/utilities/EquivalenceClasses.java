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
	protected ArrayList<LinkedEquivalenceClass<T>> _rest;
	
	
	public EquivalenceClasses(Comparator<T> comp){
		_comparator = comp;
		_rest = new ArrayList<LinkedEquivalenceClass<T>>();
	}
	
	/**
	 * add element to list
	 * @param element
	 * @return
	 */
	public boolean add(T element) {
		//call list for _rest
		for (LinkedEquivalenceClass<T> item : _rest) {
			if (item.add(element)) {
				return true;
			}
		}
		_rest.add(new LinkedEquivalenceClass<T>(_comparator));
		this.add(element);
		return true;
		
		
	}
	
	/**
	 * Checks if target is contained in the list
	 * @param target
	 * @return
	 */
	public boolean contains(T target) {
		//call contains on _rest
		return _rest.contains(target);
	}
	
	/**
	 * returns size of entire ArrayList
	 * @return
	 */
	public int size() {
		//create counter value
		int counter = 0;
		//for loop sum all sizes
		for (LinkedEquivalenceClass<T> item : _rest) {
			counter = item.size() + counter;
		}
		//return the sum
		return counter;
		
	}
	
	/**
	 * returns the size of a specific LinkedList
	 * @return
	 */
	public int numClasses() {
		//calls size ArrayList method 
		return _rest.size();
	}
	
	/**
	 * Returns the index of class in our list
	 * @param element
	 * @return
	 */
	protected int indexOfClass(T element) {
		//call index of for element?
		//may need to fix
		return _rest.indexOf(element);
	}
	
	/**
	 * Returns string
	 */
	public String toString() {
		//create string
		return _rest.toString();
	}
	
	
	
}
