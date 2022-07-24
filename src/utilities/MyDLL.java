package utilities;


/*
 * Author: Jason Huang, Shuo Han, Paignton Wild
 * Date 2022-07-17
 */
public class MyDLL<E> implements ListADT<E>{
	MyDLLNode head, tail;
	int size;

	/*
	 * Constructor for Linked List
	 */
	public MyDLL() {
		head = null;
		tail = null;
		size = 0;
	}

	/*
	 * Return the size of the DLL
	 * @return size of DLL
	 */
	public int size() {
		return size;
	}
	
	/*
	 * Clears the DLL
	 */
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	/*
	 * Add to DLL based on index and E element
	 * @param int index of the insertion
	 * @param E toAdd element to add in the node
	 * @exception NullPointerException if the index doesn't point to anything in DLL
	 * @exception IndexOutOfBoundsException if the index is out of bounds of the DLL
	 */
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		MyDLLNode nodePointer = head;
		MyDLLNode newNode = new MyDLLNode(toAdd);

		if (index < 0) {
			throw new NullPointerException();
		} else if (index > size()) {
			throw new IndexOutOfBoundsException();

		} else if (head == null) {
			head = newNode;
			tail = newNode;
			size++;
			return true;
		}
		if (index == 0) {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
			size++;
			return true;

		} else if (index == size()) {
			tail.next = newNode;
			newNode.previous = tail;

			tail = newNode;
			size++;
			return true;

		} else {
			for (int temp = 1; temp < index; temp++) {
				nodePointer = nodePointer.next;
			}
			newNode.next = nodePointer.next;
			nodePointer.next = newNode;
			newNode.previous = nodePointer;
			newNode.next.previous = newNode;
			size++;
			return true;

		}

	}

	/*
	 * Add to DLL at the end of the list
	 * @param E toAdd element to be added as a node
	 * @exception NullPointerException if the index doesn't point to anything in DLL
	 */
	public boolean add(E toAdd) throws NullPointerException {
		MyDLLNode newNode = new MyDLLNode(toAdd);
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		newNode.previous = tail;
		tail.next = newNode;
		tail = newNode;
		size++;
		return true;
	}

	/*
	 * Add to DLL all elements of the list
	 * @param List toAdd list of element to be added
	 * @exception NullPointerException if the index doesn't point to anything in DLL
	 */
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		for (int temp = 0; temp < toAdd.size(); temp++) {
			add(toAdd.get(temp));
			size++;
		}
		return true;
	}

	/*
	 * Get index element from DLL
	 * @param int index of the list
	 * @exception IndexOutOfBoundsException if the index is out of bounds of the DLL
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		MyDLLNode nodePointer = head;
		for (int temp = 0; temp < index; temp++) {
			nodePointer = nodePointer.next;
			

		}
		return (E) nodePointer.getItem();
	}

	/*
	 * Remove to DLL based on index and E element
	 * @param int index of the insertion
	 * @exception IndexOutOfBoundsException if the index is out of bounds of the DLL
	 */
	public E remove(int index) throws IndexOutOfBoundsException {
		MyDLLNode nodePointer = head;
		MyDLLNode nodeRemoved;
		if (index > size()) {
			throw new IndexOutOfBoundsException();

		} else if (index == 0) {
			nodeRemoved = head;
			head = head.next;
			head.previous = null;
			size--;

		} else if (index == size()) {
			nodeRemoved = tail;
			tail = tail.previous;
			tail.next = null;
			size--;

		} else {
			for (int temp = 1; temp < index; temp++) {
				nodePointer = nodePointer.next;
			}
			nodeRemoved = nodePointer.next;
			nodePointer.next = nodeRemoved.next;
			nodePointer.next.previous = nodePointer;
			size--;

		}

		return (E) nodeRemoved.getItem();
	}

	/*
	 * Remove from DLL with specified element
	 * @param E toRemove element to to remove in the list
	 * @exception NullPointerException if the index doesn't point to anything in DLL
	 */
	public E remove(E toRemove) throws NullPointerException {
		MyDLLNode nodeRemoved;
		MyDLLNode nodePointer = head;
		if (head == null) {
			throw new NullPointerException();
		}

		for (int temp = 0; temp < size; temp++) {		
			if (nodePointer.getItem().equals(toRemove) ) {
				remove(temp);
				
			}
			nodePointer = nodePointer.next;
		}
		
		

		return toRemove;

	}

	/*
	 * Set specific node to a element
	 * @param E toChange element that is changed to
	 * @exception NullPointerException if the index doesn't point to anything in DLL
	 * @exception IndexOutOfBoundsException if the index is out of bounds of the DLL
	 * @return removed element
	 */
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
		if (tail == null) {
			throw new NullPointerException();
		}
		MyDLLNode nodePointer = head;
		for (int temp = 0; temp < index; temp++) {
			nodePointer = nodePointer.next;
		}
		nodePointer.setItem(toChange);
		return (E) nodePointer.getItem();
	}

	/*
	 * Checks if the list is empty
	 * @return true if list is empty
	 * @return false if list is not empty
	 */
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * checks if a element is contained inside the list
	 * @param E toFind element that the method is checking for
	 * @exception NullPointerException if the index doesn't point to anything in DLL
	 * @return true if contain, false if not
	 */
	public boolean contains(E toFind) throws NullPointerException {
		if (head == null) {
			throw new NullPointerException();
		}
		boolean exist = false;
		MyDLLNode nodePointer = head;
		for (int temp = 1; temp < size(); temp++) {
			nodePointer = nodePointer.next;
			if (nodePointer.getItem() == toFind) {
				exist = true;
			}
		}
		return exist;
	}

	/*
	 * Returns the DLL as a array
	 * @param E toHold element array that is holding the array
	 * @exception NullPointerException if the index doesn't point to anything in DLL
	 */
	public E[] toArray(E[] toHold) throws NullPointerException {
		MyDLLNode nodePointer = head;
		for (int temp = 0; temp < size(); temp++) {
			toHold[temp] = (E) nodePointer.getItem();
			nodePointer = nodePointer.next;
		}
		return toHold;
	}

	/*
	 * Return the DLL as a array
	 * @return object[] array that hold all of the DLL
	 */
	public Object[] toArray() {
		MyDLLNode nodePointer = head;
		Object array[] = new Object[size()];
		for (int temp = 0; temp < size(); temp++) {
			array[temp] = nodePointer;
			nodePointer = nodePointer.next;
		}
		return array;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyIterator<E>((E[]) toArray());
	}


}
