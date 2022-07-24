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

import exceptions.EmptyQueueException;
import utilities.MyQueue;

public class MyQueueTests {
	// Test objects
	private static MyQueue<Object> myQueue;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myQueue = new MyQueue<Object>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		myQueue=null;
	}

	@BeforeEach
	public void setUp() throws Exception {
		myQueue = new MyQueue<Object>();
		
	}

	@AfterEach
	public void tearDown() throws Exception {
		myQueue.dequeueAll();
	}

	@Test
	public void test_enqueue() throws  utilities.EmptyQueueException {
		
		myQueue.dequeueAll();
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		
		assertEquals(myQueue.size(), 3);
		
		assertEquals("three", myQueue.peek());
	}
	
	public void test_dequeue() throws utilities.EmptyQueueException {
		
		myQueue.dequeueAll();
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		myQueue.dequeue();
		
		assertEquals(myQueue.size(), 2);
		
		assertEquals("two", myQueue.peek());
	}
	
	public void test_peek() throws utilities.EmptyQueueException {
		
		myQueue.dequeueAll();
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		Object last = myQueue.peek();
		
		assertEquals(last,"three");
		
		assertEquals(myQueue.size(), 3);

	}
	
	@Test
	public void test_dequeueAll() {
		myQueue.dequeueAll();
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		
		assertEquals( myQueue.size(), 3);
		
		myQueue.dequeueAll();
		
		assertEquals(myQueue.size(), 0);
	}
	
	@Test
	public void test_isEmpty() {
		
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		
		assertEquals(false, myQueue.isEmpty());
		
		myQueue.dequeueAll();
		
		assertEquals(true, myQueue.isEmpty());
	}
	
	@Test
	public void test_iterator() {
		myQueue.dequeueAll();
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		
		assertEquals(myQueue.iterator().hasNext(), true);
		assertEquals(myQueue.iterator().next(), "two");
		
		myQueue.dequeueAll();
		assertEquals(myQueue.iterator().hasNext(), false);
	}
	
	
	@Test
	public void test_equals() {
		myQueue.dequeueAll();
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		
		MyQueue<Object> myTestQueue = new MyQueue<Object>();
		myTestQueue.enqueue("one");
		myTestQueue.enqueue("two");
		myTestQueue.enqueue("three");
		
		assertEquals(myQueue.size(), 3);	
		assertEquals(myTestQueue.size(), 3);	
		
		
		assertEquals(true, myQueue.equals1(myTestQueue));	
	}
	
	@Test
	public void test_toArray() {
		Object[] to = new Object[3];
		myQueue.dequeueAll();
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		
		to = myQueue.toArray();
		
		assertEquals(to[0], "one");
		assertEquals(to[1], "two");
		assertEquals(to[2], "three");
	}
	@Test
	public void test_toArray_array() {
		Object[] toArray = new String[3];
		myQueue.dequeueAll();
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		
		toArray = myQueue.toArray(toArray);
		
		assertEquals(toArray[0], "one");
		assertEquals(toArray[1], "two");
		assertEquals(toArray[2], "three");
	}
	
	@Test
	public void test_size() {
		myQueue.dequeueAll();
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		
		assertEquals(myQueue.size(), 3);	
	}
}
