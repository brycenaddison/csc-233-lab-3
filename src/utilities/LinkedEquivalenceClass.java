package utilities;

import java.util.Comparator;

/**
 * Linked Equivalence Class
 * @author jackcrouse
 * @version Fri Sep 23 2022
 */


public class LinkedEquivalenceClass <T> {

	protected T _canonical; 
	protected Comparator<T> _comparator;
	protected LinkedList<T> _rest; 

	LinkedEquivalenceClass(Comparator<T> comp)
	{
		_comparator = comp; 
		_rest = new LinkedList<T>(); 

	}

	//returns the canonical element which represents the class
	public T canonical()
	{
		return _canonical;
	}

	//checks to see if the classes list is empty
	public boolean isEmpty()
	{
		return size() == 1; 
	}

	//clears the classes list
	public void clear()
	{
		_rest.clear();
		_canonical = null; 
	}

	//clears the classes list but not the canonical element
	public void clearNonCanonical()
	{
		T canonical = _canonical; 
		clear();
		_canonical = canonical;
	}

	//returns the size of the linked equivalence class
	public int size()
	{
		return _rest.size() + 1;
	}

	//adds an element to the linked equivalence class
	public boolean add(T element)
	{
		if(_canonical == null) 
		{
			_canonical = element;
			return true;
		}

		if(!belongs(element)) return false;

		_rest.addToFront(element);

		return true;
	}

	//checks if the linked equivalence class contains an element
	public boolean contains(T target)
	{
		if(belongs(target))
		{
			if(target.equals(_canonical)) return true;

			for(T item: _rest)
			{
				if(item.equals(target)) return true;
			}
		}

		return false;

	}

	//checks if an element conforms to the linked equivalence class
	public boolean belongs(T target)
	{
		if(_canonical == null) return false;
		if(_comparator.compare(target, _canonical) == 0) return true;
		return false;
	}

	//removes an element from the linked equivalence class
	public boolean remove(T target)
	{		
		if(!belongs(target)) return false;

		_rest.remove(target);
		return true;
	}

	//removes the canonical element
	public boolean removeCanonical()
	{
		if(_canonical == null) return false;

		_canonical = _rest.popFront();
		return true;
	}

	//demotes the canonical element and replaces it with an element
	public boolean demoteAndSetCanonical(T element)
	{
		if(_canonical == null || element == null || element.equals(_canonical)) return false;

		T oldCanon = _canonical; 
		_canonical = element; 
		_rest.addToFront(oldCanon);
		_rest.remove(element);
		return true;
	}

	//returns the class as a readable string
	public String toString()
	{
		if(size() == 1) return "[]";

		String res = "[";
		for(T item: _rest)
		{
			res += item + ", ";
		}

		res = res.substring(0, res.length() - 2);

		return res + "]";

	}
}
