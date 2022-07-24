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

import utilities.MyStack;

public class MyStackTest {
	
	// Test objects
	private static MyStack<String> myStack;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myStack = new MyStack<String>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		myStack=null;
	}

	@BeforeEach
	public void setUp() throws Exception {
		myStack = new MyStack<String>();
		
	}

	@AfterEach
	public void tearDown() throws Exception {
		myStack.clear();
	}

	@Test
	public void test_isEmpty() {
		
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		
		assertEquals(false, myStack.isEmpty());
		
		myStack.clear();
		
		assertEquals(true, myStack.isEmpty());
	}
	@Test
	public void test_size() {
		myStack.clear();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		
		assertEquals(myStack.size(), 3);
		
	}
	@Test
	public void test_clear() {
		myStack.clear();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		
		assertEquals( myStack.size(), 3);
		
		myStack.clear();
		
		assertEquals(myStack.size(), 0);
	}
	@Test
	public void test_pop() {
		
		myStack.clear();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		
		assertEquals(myStack.size(), 3);
		assertEquals(myStack.peek(), "three");
		myStack.pop();
		assertEquals(myStack.size(), 2);
		assertEquals(myStack.peek(), "two");
		
	}
	@Test
	public void test_peek() {
		
		myStack.clear();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		
		assertEquals(myStack.peek(), "three");
		
	}
	
	@Test
	public void test_toArray_array() {
		String[] toArray = new String[3];
		myStack.clear();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		
		toArray = myStack.toArray(toArray);
		
		assertEquals(toArray[0], "one");
		assertEquals(toArray[1], "two");
		assertEquals(toArray[2], "three");
		
	}
	@Test
	public void test_toArray() {
		Object[] to = new Object[3];
		myStack.clear();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		
		to = myStack.toArray();
		
		assertEquals(to[0], "one");
		assertEquals(to[1], "two");
		assertEquals(to[2], "three");
		
	}
	
	@Test
	public void test_contains() {

		myStack.clear();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		assertEquals(myStack.contains("one"), true);
		
		assertEquals(myStack.contains("four"), false);
		
	}
	
	@Test
	public void test_iterator() {
		myStack.clear();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		
		assertEquals(myStack.iterator().hasNext(), true);
		assertEquals(myStack.iterator().next(), "one");
		
		myStack.clear();
		assertEquals(myStack.iterator().hasNext(), false);
	}
	

	
	@Test
	public void test_search() {
		
		myStack.clear();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		
		assertEquals(myStack.search("one"), 3);
		assertEquals(myStack.search("two"), 2);
		assertEquals(myStack.search("three"), 1);
		
		myStack.clear();
		myStack.push("one");
		myStack.push("one");
		myStack.push("one");
		assertEquals(myStack.search("one"), 1);
		
	}
	@Test
	public void test_equals() {
		MyStack<String> myStack1 = new MyStack<String>();
		
		myStack.clear();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		
		myStack1.push("one");
		myStack1.push("two");
		myStack1.push("three");
		
		assertEquals(myStack.equals(myStack1), true);
		
		myStack1.pop();
		assertEquals(myStack.equals(myStack1), false);
		
		myStack1.push("four");
		assertEquals(myStack.equals(myStack1), false);
		
	}
	
}

