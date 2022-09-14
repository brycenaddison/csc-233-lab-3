import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author brycenaddison
 * @version Wed Sep 14 2022
 */
class LinkedListTest {

    LinkedList<String> build() {
        LinkedList<String> list = new LinkedList<>();
        list.addToFront("foobar");
        list.addToFront("foo");
        list.addToFront("bar");
        list.addToFront("baz");
        list.addToFront("qux");
        return list;
    }

    @Test
    void size() {
        LinkedList<String> list = build();
        assertEquals(5, list.size());
        list = new LinkedList<>();
        assertEquals(0, list.size());
    }

    @Test
    void isEmpty() {
        LinkedList<String> list = build();
        assertFalse(list.isEmpty());
        list = new LinkedList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    void clear() {
        LinkedList<String> list = build();
        list.clear();
        assertEquals("[]", list.toString());
    }

    @Test
    void contains() {
        LinkedList<String> list = build();
        assertTrue(list.contains("foobar"));
        assertFalse(list.contains("bar foo"));
        assertFalse(list.contains("null"));
    }

    @Test
    void iterator() {
        StringBuilder sb = new StringBuilder("[");
        for (String str: build()) {
            sb.append(", ").append(str);
        }
        sb.delete(1, 3).append("]");
        assertEquals("[qux, baz, bar, foo, foobar]", sb.toString());
    }

    @Test
    void addToFront() {
        LinkedList<String> list = build();
        assertEquals("[qux, baz, bar, foo, foobar]", list.toString());
    }

    @Test
    void addToBack() {
        LinkedList<String> list = new LinkedList<>();
        list.addToBack("foobar");
        list.addToBack("foo");
        list.addToBack("bar");
        list.addToBack("baz");
        list.addToBack("qux");
        assertEquals("[foobar, foo, bar, baz, qux]", list.toString());
    }

    @Test
    void reverse() {
        LinkedList<String> list = build();
        assertEquals("[qux, baz, bar, foo, foobar]", list.toString());
        list.reverse();
        assertEquals("[foobar, foo, bar, baz, qux]", list.toString());
    }

    @Test
    void remove() {
        LinkedList<String> list = build();
        assertTrue(list.remove("bar"));
        assertEquals("[qux, baz, foo, foobar]", list.toString());
        assertFalse(list.remove("bar"));
        assertTrue(list.remove("qux"));
        assertEquals("[baz, foo, foobar]", list.toString());
        assertTrue(list.remove("foobar"));
        assertEquals("[baz, foo]", list.toString());
    }
}