import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import utilities.LinkedEquivalenceClass;



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
		//?????????? :(
		return _rest.add(element);
	}
	
	//god help me
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
