package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

class EquivalenceClassTest {

	@Test
	void addWhenClassDoesNotExist () {
		//FIXME
		//Create comparator
		Comparator<Integer> comp = new Comparator<Integer>();
		//create equiv class
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		//add to equiv, creating class
		assertTrue(equiv.add(3));
		
	}
	
	@Test
	void addWhenClassDoesExist () {
		//FIXME
		//create comparator
		Comparator<Integer> comp = new Comparator<Integer>();
		//create equiv class
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		//add 5 to class, creating class
		equiv.add(5);
		//add 3 to class, that should now exist
		assertTrue(equiv.add(3));
	}
	
	@Test
	void doesContain() {
		//create comparator
		//create equiv class
		//add 5 to class, should be true
		
	}
	
	@Test
	void doesNotContain() {
		//create comparator
		//create equiv class
		//check that 5 is not in any class
	}
	
	@Test
	void sizeIsEmpty() {
		//create comparator
		//create equiv class
		//call size, should be empty
	}
	
	@Test
	void sizeWithOneClass() {
		//create comparator
		//create equiv class
		//add class to equiv
		//call size, should the same as class as single 
		
	}
	
	@Test
	void sizeWithManyClasses() {
		//create comparator
		//create equiv class
		//add several classes to equiv
		//call size
		
	}
	
	@Test
	void numClassesIsEmpty() {
		//create comparator
		//create equiv class
		//check check size with empty class
	}
	
	@Test
	void numClassesNotEmpty() {
		//create comparator
		//create equiv class
		//add to class
		//check size
	}
	
	@Test
	void indexOfFirstElement() {
		//create comparator
		//create equiv class
		//add to equiv
		//check first element
	}
	
	@Test
	void indexOfLastElement() {
		//create comparator
		//create equiv class
		//add to equiv
		//check last element
	}
	
	@Test
	void indexOfMidElement() {
		//create comparator
		//create equiv class
		//add to equiv
		//check middle element
		
	}
	

}
