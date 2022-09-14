package utilities;

import java.util.Comparator;

public class LinkedEquivalenceClass <T> {

	protected T _canonical; 
	protected Comparator<T> _comparator;
	protected LinkedList<T> _rest; 

	LinkedEquivalenceClass(Comparator<T> comp)
	{
		_comparator = comp; 
		_rest = new LinkedList<T>(); 

	}

	public T canonical()
	{
		return _canonical;
	}


	public boolean isEmpty()
	{
		return _rest.size() == 0; 
	}

	public void clear()
	{
		_rest.clear();
	}

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
		if(!belongs(element)) return false;

		if(_canonical == null) 
		{
			_canonical = element;
			return true;
		}

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
