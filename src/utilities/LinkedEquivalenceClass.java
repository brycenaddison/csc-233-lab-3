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
		return _rest.size() == 0; 
	}

	//clears the classes list
	public void clear()
	{
		_rest.clear();
	}

	//clears the classes list but not the canonical element
	public void clearNonCanonical()
	{
		T canonical = _canonical; 
		_rest.clear();
		_rest.addToFront(canonical);
	}

	public int size()
	{
		if(_canonical == null) return 0;
		return _rest.size() + 1;
	}

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

	public boolean belongs(T target)
	{
		if(_canonical == null) return false;
		if(_comparator.compare(target, _canonical) == 0) return true;
		return false;
	}

	public boolean remove(T target)
	{		
		if(!belongs(target)) return false;
		
		_rest.remove(target);
		return true;
	}

	public boolean removeCanonical()
	{
		if(_canonical == null) return false;
		
		_canonical = _rest.popFront();
		return true;
	}
	
	public boolean demoteAndSetCanonical(T element)
	{
		if(_canonical == null) return false;
		
		T oldCanon = _canonical; 
		_canonical = element; 
		_rest.addToFront(oldCanon);
		return true;
	}
	
	public String toString()
	{
		String res = "[";
		for(T item: _rest)
		{
			res += item + ", ";
		}
		
		res = res.substring(0, res.length() - 2);
		
		return res + "]";
		
	}
}
