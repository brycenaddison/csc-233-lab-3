package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

class EquivalenceClassTest {

	
	@Test
	void addWhenClassDoesNotExist () {
		
		Comparator<Integer> comp = new Comparator<Integer>() {		
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)	
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		assertTrue(equiv.add(2));
		
		//check that element was actually added
		assertEquals(1, equiv.size());
		
		assertEquals(1, equiv.numClasses());
		
		
	}
	
	
	@Test
	void addWhenClassDoesExist () {
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		equiv.add(2);
		
		assertTrue(equiv.add(4));
		
	}
	
	
	@Test
	void doesContain() {
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		equiv.add(2);
		
		assertTrue(equiv.contains(2));
		
	}
	
	
	@Test
	void doesNotContain() {
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		assertFalse(equiv.contains(3));
		
	}
	
	
	@Test
	void sizeIsEmpty() {
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		assertEquals(0,equiv.size());
		
	}
	
	
	@Test
	void sizeWithOneElementOneClass() {
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		equiv.add(2);
		
		assertEquals(1,equiv.size());
		
	}
	
	
	@Test
	void sizeWithManyElementsOneClass() {
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		equiv.add(2);
		equiv.add(4);
		equiv.add(6);
		
		assertEquals(3,equiv.size());
		
	}
	
	
	@Test
	void sizeWithOneElementManyClass() {
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		equiv.add(2);
		equiv.add(3);
		
		assertEquals(2,equiv.size());
		
	}
	
	@Test
	void sizeWithManyElementsManyClass() {
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		equiv.add(2);
		equiv.add(4);
		equiv.add(6);
		equiv.add(3);
		equiv.add(5);
		
		assertEquals(5,equiv.size());
		
	}
	
	
	@Test
	void numClassesIsEmpty() {
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		assertEquals(0,equiv.numClasses());
		
	}
	
	
	@Test
	void numClassesNotEmpty() {
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		equiv.add(2);
		
		assertEquals(1,equiv.numClasses());
		
	}
	
	
	@Test
	void indexOfFirstClassElement() {
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		equiv.add(0);
		equiv.add(1);
		equiv.add(2);
		equiv.add(4);
		equiv.add(3);
		
		assertEquals(0,equiv.indexOfClass(0));
		
	}
	
	
	@Test
	void indexOfLastClassElement() {
		Comparator<Integer> comp = new Comparator<Integer>() {
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			 { return x % 2 == y % 2 ? 0 : 1; }
		};
		
		EquivalenceClasses<Integer> equiv = new EquivalenceClasses<>(comp);
		
		equiv.add(0);
		equiv.add(1);
		equiv.add(2);
		equiv.add(4);
		equiv.add(3);
		
		assertEquals(1,equiv.indexOfClass(1));
	}
	

	

}
