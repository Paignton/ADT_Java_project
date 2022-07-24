package utilities;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
//import exceptions.EmptyQueueException;

public class MyQueue<E> implements QueueADT<Object>{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		MyDLL<Object> myQueue = new MyDLL<Object>();

	@Override
	/**
	 * Adds one node to the end of the Queue.
	 * 
	 * @param toAdd item to be queued onto the end of the Queue.
	 * 
	 * @throws NullPointerException when attempting to add a null element to
	 * the Queue.
	 */
	public void enqueue(Object toAdd) throws NullPointerException {
		myQueue.add(toAdd);
		}

	@Override
	/**
	 * Removes the object at the front of this Queue and returns that object as
	 * the value of this function.
	 * 
	 * @return the item dequeued from the back of the Queue.
	 * @throws EmptyQueueException
	 *             if there are not items in the Queue.
	 **/
	public Object dequeue() throws EmptyQueueException {
		return myQueue.remove(myQueue.tail);
	}

	@Override
	/**
	 * Looks at the object at the end of this Queue 
	 * without affecting it in any way,
	 * 
	 * @return the object at the end of this Queue.
	 * @throws EmptyQueueException
	 */
	public Object peek() throws EmptyQueueException {
		return myQueue.get(myQueue.size - 1);
	}

	@Override
	/**
	 * Clears all elements of the Queue
	 */
	public void dequeueAll() {
		myQueue.clear();
		
	}

	@Override
	/**
	 * Returns <code>true</code> if the Queue is empty
	 * @return <code>true</code> if the Queue contains no elements 
	 * 
	 */
	public boolean isEmpty() {
		return myQueue.isEmpty();
	}

	@Override
	/**
	 * Returns an iterator over the elements in this Queue in a proper sequence.
	 * 
	 * @return an iterator over the elements in this Queue in a proper sequence.
	 */
	
	
	public Iterator<Object> iterator() {		
		return myQueue.iterator();
	}

	
	/**
	 * Used to compare two Queue ADT's. To be equal two queues must contain
	 * the same items appearing in the same order.
	 * 
	 * @param that: the Queue ADT to be compared to this Queue.
	 * @return <code>true</code> if the Queues are equal.
	 */
	public boolean equals1( QueueADT<E> that ) {
		
		
		if(myQueue.size() != that.size()) {
			return false;
		}
		//loop through both queues and compare elements
		
		for(int i=0; i < myQueue.size(); i++) {
			
		
			if(myQueue.get(i) != that.toArray()[i]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Object[] toArray() {
		return myQueue.toArray();
	}

	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return myQueue.toArray(holder);
	}

	@Override
	// What should this method do for a DLL implementation of Queue?
	public boolean isFull() {
		return false;
	}

	@Override
	/**
	 * Returns the length of the queue as an integer value.
	 * @return the current length of the queue as a integer. 
	 */
	public int size() {
		return myQueue.size();
	}

	@Override
	public boolean equals(QueueADT<Object> that) {
		// TODO Auto-generated method stub
		return false;
	}

}
