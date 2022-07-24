import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.ListADT;
import utilities.MyArrayList;
import utilities.MyDLL;
import utilities.MyDLLNode;


/*
 * Author: Jason Huang, Shuo Han, Paignton Wild
 * Date 2022-07-17
 */
public class MyDLLTest {
	
	// Test objects
	private static MyDLL<String> myList;
	private String one;
	private String two;
	private String three;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myList = new MyDLL<String>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		myList=null;
	}

	@Before
	public void setUp() throws Exception {
		myList = new MyDLL<String>();
		one = "one";
		two = "two";
		three = "three";
	}

	@After
	public void tearDown() throws Exception {
		one = null;
		two = null;
		three = null;
	}
	
	@Test
	public void test_clear() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		assertEquals(3, myList.size());
		myList.clear();
		assertEquals(0, myList.size());
		
		
	}
	@Test
	public void test_size() {
		assertEquals(0, myList.size());
		myList.add(one);
		myList.add(two);
		myList.add(three);
		assertEquals(3, myList.size());
		
	}
	
	@Test
	public void test_addIndex() {
		assertEquals(0, myList.size());
		myList.add(0, one);
		assertEquals(one, myList.get(0));
		myList.add(0, two);
		assertEquals(two, myList.get(0));
		myList.add(2, three);
		assertEquals(three, myList.get(2));
		
		
	}
	
	@Test
	public void test_add() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		assertEquals(one, myList.get(0));
		assertEquals(two, myList.get(1));
		assertEquals(three, myList.get(2));
		
	}
	
	@Test
	public void test_addAll() {
		MyArrayList<String> array = new MyArrayList<String>();
		array.add(one);
		array.add(two);
		array.add(three);
		myList.addAll(array);
		assertEquals(one, myList.get(0));
		assertEquals(two, myList.get(1));
		assertEquals(three, myList.get(2));
	}
	
	@Test
	public void test_removeIndex() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		myList.remove(1);
		assertEquals(one, myList.get(0));
		assertEquals(three, myList.get(1));
		
	}
	@Test
	public void test_remove() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		myList.remove(one);
		assertEquals(two, myList.get(0));
		assertEquals(three, myList.get(1));
		
	}
	@Test
	public void test_set() {
		myList.add(one);
		myList.add(one);
		myList.add(three);
		myList.set(1, two);
		assertEquals(two, myList.get(1));
		
		
	}

	@Test
	public void test_isEmpty() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		myList.clear();
		assertEquals(0, myList.size());
		
	}
	@Test
	public void test_contains() {
		myList.add(one);
		myList.add(one);
		myList.add(three);
		assertEquals(true, myList.contains(three));
		assertEquals(false, myList.contains(two));
		
		
	}
	@Test
	public void test_ToArrayIndex() {
	
		String[] test = {one, two, three};
		String[] testOutput = myList.toArray(test);
		assertEquals(one, testOutput[0]);
		assertEquals(two, testOutput[1]);
		assertEquals(three, testOutput[2]);
		
	}
	@Test
	public void test_toArray() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		Object[] test = myList.toArray();
		assertEquals(one, ((MyDLLNode) test[0]).getItem());
		assertEquals(two, ((MyDLLNode) test[1]).getItem());
		assertEquals(three, ((MyDLLNode) test[2]).getItem());
	}
	

}
