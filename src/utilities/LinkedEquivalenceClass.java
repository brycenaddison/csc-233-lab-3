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
		
	}
	
	
	public boolean isEmpty()
	{
		return _rest.size() == 0; 
	}
	
	public void clear()
	{
		
	}
	
}
