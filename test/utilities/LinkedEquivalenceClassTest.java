/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * Linked Equivalence Test Class
 * @author jackcrouse
 * @version Fri Sep 23 2022
 */

class LinkedEquivalenceClassTest {

	private LinkedEquivalenceClass<Integer> Build(int high)
	{

		Comparator<Integer> comp = new Comparator<Integer>()
		{

			public int compare(Integer x, Integer y)
			{ 	
				return x % 4 == y % 4 ? 0 : 1; }
		};

		LinkedEquivalenceClass<Integer> list = new LinkedEquivalenceClass<Integer>(comp);

		for(int i = 1; i <= high; i++)
		{
			list.add(i);
		}

		return list;
	}



	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#canonical()}.
	 */
	@Test
	void testCanonical() {
		LinkedEquivalenceClass<Integer> list = Build(5);

		assertEquals(list.canonical(), 1);
		list.clear();

		list.add(8);
		assertEquals(list.canonical(), 8);

		list.removeCanonical();
		list.add(0);
		assertEquals(list.canonical(), 0);

		list.add(1);
		assertEquals(list.canonical(), 0);

	}

	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {


		Comparator<Integer> comp = new Comparator<Integer>()
		{

			public int compare(Integer x, Integer y)
			{ 	
				return x % 4 == y % 4 ? 0 : 1; }
		};

		LinkedEquivalenceClass<Integer> list = new LinkedEquivalenceClass(comp);

		assertTrue(list.isEmpty());
		list.add(null);
		assertTrue(list.isEmpty());

		list.add(1);
		assertTrue(list.isEmpty());

	}

	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#clear()}.
	 */
	@Test
	void testClear() {
		LinkedEquivalenceClass<Integer> list = Build(5);
		list.clear();
		assertTrue(list._rest.isEmpty());

		list.add(5);
		assertTrue(list._rest.isEmpty());

		list.clear();
		assertTrue(list._rest.isEmpty());

		assertEquals(null, list.canonical()); 

	}

	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#clearNonCanonical()}.
	 */
	@Test
	void testClearNonCanonical() {
		LinkedEquivalenceClass<Integer> list = Build(5);
		list.clearNonCanonical();

		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#size()}.
	 */
	@Test
	void testSize() {
		LinkedEquivalenceClass<Integer> list = Build(25);
		assertEquals(7, list.size());
	}

	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#add(java.lang.Object)}.
	 */
	@Test
	void testAdd() {

		Comparator<Integer> comp = new Comparator<Integer>()
		{

			public int compare(Integer x, Integer y)
			{ 	
				return x % 4 == y % 4 ? 0 : 1; }
		};

		LinkedEquivalenceClass<Integer> list = new LinkedEquivalenceClass<Integer>(comp);

		list.add(1); 
		assertEquals(1, list.size());

		list.add(2);
		assertEquals(1, list.size());

		list.add(5);
		assertEquals(2, list.size());

	}

	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		LinkedEquivalenceClass<Integer> list = Build(9);

		assertTrue(list.contains(9));
		assertTrue(list.contains(5));
		assertTrue(list.contains(1));

		assertFalse(list.contains(2));
		assertFalse(list.contains(6));
		assertFalse(list.contains(8));

	}

	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#belongs(java.lang.Object)}.
	 */
	@Test
	void testBelongs() {
		LinkedEquivalenceClass<Integer> list = Build(1);
		assertTrue(list.belongs(5));
		assertFalse(list.belongs(2));
		assertTrue(list.belongs(9));


		Comparator<Integer> comp = new Comparator<Integer>()
		{

			public int compare(Integer x, Integer y)
			{ 	
				return x % 10 == y % 10 ? 0 : 1; }
		};

		LinkedEquivalenceClass<Integer> list2 = new LinkedEquivalenceClass<Integer>(comp);

		list2.add(11); 

		assertTrue(list2.belongs(21));
		assertFalse(list2.belongs(5));

	}

	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#remove(java.lang.Object)}.
	 */
	@Test
	void testRemove() {
		LinkedEquivalenceClass<Integer> list = Build(9);
		assertEquals("[9, 5]", list.toString());

		list.remove(5);
		assertEquals("[9]", list.toString());

		list.remove(9);
		assertEquals("[]", list.toString());

		assertEquals(1, list.canonical());
	}

	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#removeCanonical()}.
	 */
	@Test
	void testRemoveCanonical() {
		LinkedEquivalenceClass<Integer> list = Build(9);
		assertEquals(1, list.canonical());

		assertTrue(list.removeCanonical());
		assertEquals(9, list.canonical());

		assertTrue(list.removeCanonical());
		assertEquals(5, list.canonical());

		Comparator<Integer> comp = new Comparator<Integer>()
		{

			public int compare(Integer x, Integer y)
			{ 	
				return x % 10 == y % 10 ? 0 : 1; }
		};

		LinkedEquivalenceClass<Integer> list2 = new LinkedEquivalenceClass<Integer>(comp);

		assertFalse(list2.removeCanonical());

	}

	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#demoteAndSetCanonical(java.lang.Object)}.
	 */
	@Test
	void testDemoteAndSetCanonical() {
		LinkedEquivalenceClass<Integer> list = Build(9);

		assertEquals(1, list.canonical());
		assertEquals("[9, 5]", list.toString());

		list.demoteAndSetCanonical(5);

		assertEquals(5, list.canonical());
		assertEquals("[1, 9]", list.toString());

		assertFalse(list.demoteAndSetCanonical(5));
		assertFalse(list.demoteAndSetCanonical(null));


		Comparator<Integer> comp = new Comparator<Integer>() {
			public int compare(Integer x, Integer y)
			{ 	
				return x % 10 == y % 10 ? 0 : 1; }
		};

		LinkedEquivalenceClass<Integer> list2 = new LinkedEquivalenceClass<Integer>(comp);

		assertFalse(list.demoteAndSetCanonical(5));

	}

	/**
	 * Test method for {@link utilities.LinkedEquivalenceClass#toString()}.
	 */
	@Test
	void testToString() {

		Comparator<Integer> comp = new Comparator<Integer>() {
			public int compare(Integer x, Integer y)
			{ 	
				return x % 10 == y % 10 ? 0 : 1; }
		};

		LinkedEquivalenceClass<Integer> list2 = new LinkedEquivalenceClass<Integer>(comp);
		assertEquals("[]", list2.toString());

		LinkedEquivalenceClass<Integer> list = Build(25);
		assertEquals("[25, 21, 17, 13, 9, 5]", list.toString());

		list.remove(25);
		assertEquals("[21, 17, 13, 9, 5]", list.toString());

	}

}
