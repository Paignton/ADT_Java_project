import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import utilities.MyArrayList;

public class MyArrayListTest {
	
	// Test objects
	private static MyArrayList<String> myList;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myList = new MyArrayList<String>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		myList=null;
	}

	@BeforeEach
	public void setUp() throws Exception {
		myList = new MyArrayList<String>();
		
	}

	@AfterEach
	public void tearDown() throws Exception {
		myList.clear();
	}

	@Test
	public void test_isEmpty() {
		
		myList.add(0, "one");
		myList.add(1, "two");
		myList.add(2, "three");
		
		assertEquals(false, myList.isEmpty());
		
		myList.clear();
		
		assertEquals(true, myList.isEmpty());
	}
	@Test
	public void test_size() {
		myList.clear();
		myList.add(0, "one");
		myList.add(1, "two");
		myList.add(2, "three");
		
		assertEquals(myList.size(), 3);
		
	}
	@Test
	public void test_clear() {
		myList.clear();
		myList.add(0, "one");
		myList.add(1, "two");
		myList.add(2, "three");
		
		assertEquals( myList.size(), 3);
		
		myList.clear();
		
		assertEquals(myList.size(), 0);
	}
	@Test
	public void test_add_index() {
		
		myList.clear();
		myList.add(0, "one");
		myList.add(1, "two");
		myList.add(2, "three");
		
		assertEquals(myList.size(), 3);
		
		
	}
	@Test
	public void test_add() {
		
		myList.clear();
		myList.add("one");
		myList.add("two");
		myList.add("three");
		
		assertEquals(myList.size(), 3);
		
		assertEquals("one", myList.get(0));
		assertEquals("two", myList.get(1));
		assertEquals("three", myList.get(2));
		
		
	}
	
	@Test
	public void test_addAll() {
		
		MyArrayList<String> secondList = new MyArrayList<String>();
		
		secondList.add("four");
		secondList.add("five");
		secondList.add("six");
		
		myList.clear();
		assertEquals(myList.size(), 0);
		
		myList.add("one");
		myList.add("two");
		myList.add("three");
		
		assertEquals(myList.size(), 3);
		
		myList.addAll(secondList);
		
		assertEquals(myList.size(), 6);
	}
	@Test
	public void test_get() {
		

		myList.clear();
		
		myList.add("one");
		myList.add("two");
		myList.add("three");
		
		assertEquals("one", myList.get(0));
		assertEquals("two", myList.get(1));
		assertEquals("three", myList.get(2));
		
	}
	@Test
	public void test_set() {

		myList.clear();
		
		myList.add("one");
		myList.add("two");
		myList.add("three");
		
		myList.set(0, "four");
		myList.add(1, "five");
		myList.add(2, "six");
		
		assertEquals("four", myList.get(0));
		assertEquals("five", myList.get(1));
		assertEquals("six", myList.get(2));
		
	}
	
	@Test
	public void test_remove() {

		myList.clear();
		
		myList.add("one");
		myList.add("two");
		myList.add("three");
		assertEquals(myList.size(), 3);
		myList.remove(0);
		assertEquals(myList.size(), 2);
		
	}
	
	@Test
	public void test_remove_element() {

		myList.clear();
		myList.add("one");
		myList.add("two");
		myList.add("three");
		assertEquals(myList.size(), 3);
		
		myList.remove("two");
		assertEquals(myList.size(), 2);
		
	}
	@Test
	public void test_contains() {

		myList.clear();
		myList.add("one");
		myList.add("two");
		myList.add("three");
		assertEquals(myList.contains("one"), true);
		
		assertEquals(myList.contains("four"), false);
		
	}
	@Test
	public void test_toArray_array() {
		String[] toArray = new String[3];
		myList.clear();
		myList.add("one");
		myList.add("two");
		myList.add("three");
		
		toArray = myList.toArray(toArray);
		
		assertEquals(toArray[0], "one");
		assertEquals(toArray[1], "two");
		assertEquals(toArray[2], "three");
		
	}
	@Test
	public void test_toArray() {
		Object[] to = new Object[3];
		myList.clear();
		myList.add("one");
		myList.add("two");
		myList.add("three");
		
		to = myList.toArray();
		
		assertEquals(to[0], "one");
		assertEquals(to[1], "two");
		assertEquals(to[2], "three");
		
	}
	@Test
	public void test_iterator() {
		myList.clear();
		myList.add("one");
		myList.add("two");
		myList.add("three");
		
		assertEquals(myList.iterator().hasNext(), true);
		assertEquals(myList.iterator().next(), "one");
		
		myList.clear();
		assertEquals(myList.iterator().hasNext(), false);
	}
	

}
