package utilities;

import java.util.Arrays;


public class MyArrayList <E> implements ListADT<E>{

	private int size;
	private int current;
	private E[] array;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int DEFAULT_ERROR_CODE =-1;
	private static final Object[] EMPTY_ELEMENTDATA = {};
	private static int FACTOR = 2;


	public MyArrayList(){
		this.array = (E[]) new Object[DEFAULT_CAPACITY];

	}

	//Create empty Arraylist of specified capacity with object types E
	public MyArrayList(int capacity){
		if(capacity > 0) {
			this.array = (E[]) new Object[capacity];}
		else if (capacity == 0) {
			this.array = (E[]) EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: "+
					capacity);
		}
	}


	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {

		final Object[] es = array;
		for (int j = size, i = size = 0; i < j; i++)
			es[i] = null;
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {

		int arrayLength = array.length;

		if(index>=0 && index <= arrayLength){

			if(index < this.size){

				if(this.size == arrayLength){
					E[] tempArray = (E[])new Object[FACTOR*arrayLength];

					for(int i = 0; i < this.size; i++){
						tempArray[i] = array[i];	
					}
					array = tempArray;

					for(int i = this.size-1; i >= index; i--){
						array[i+1]=array[i];
					}

					array[index] = toAdd;

					size++;
				}

				else {
					for(int i = this.size-1; i >= index; i--){
						array[i+1]=array[i];
					}
					array[index] = toAdd;
					size++;
				}
			}

			else if(index == this.size){
				add(toAdd);

			}
			else throw new IndexOutOfBoundsException();

			return true;
		}

		return false;

	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		int numElements = this.size;
		int arrayLength = array.length;
		if(this.size == array.length){
			E[] tempArray = (E[])new Object[FACTOR*arrayLength];
			for(int i=0;i<this.size;i++){
				tempArray[i] = array[i];	
			}
			array = tempArray;

		}
		array[size] = toAdd;

		size++;
		return true;

	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {

		E[] a = (E[]) toAdd.toArray();
		int oldCapacity = size;
		int newCapacity = size + toAdd.size();
		if (newCapacity > array.length) {
			array = Arrays.copyOf(array, newCapacity);
		}
		for(int i = 0; i < a.length; i++) {
			array[oldCapacity + i] = a[i]; 
			size++;

			
		}

		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index<0 || index>=this.size) throw new IndexOutOfBoundsException();
		return array[index];

	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index<0 || index>=this.size) throw new IndexOutOfBoundsException();

		E returnElement = array[index];
		for(int i = index+1; i<this.size; i++){
			array[i-1]=array[i];
		}
		array[this.size-1]=null;
		this.size--;
		return returnElement;

	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		Object[] a = array;
		int index = -1;
		for (int i = 0; i < this.size; i++) {
			if (toRemove.equals(a[i])) {
				index = i; 
			}
		}
		try {
			remove(index);
			return toRemove;
		} catch (Exception NullPointerException) {
			System.out.println("Element doesnot exist.");
			return null;
		}

	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(index>=this.size) throw new IndexOutOfBoundsException();

		E returnElement = array[index];
		array[index] = toChange;

		return returnElement;		

	}

	@Override
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		Object[] a = array;
		boolean con = false;
		for (int i = 0; i < this.size; i++) {
			if (toFind.equals(a[i])) {
				con = true; 
			}
		}
		return con;

	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold.length < size)
			// Make a new array of toHold's runtime type, but my contents:
			return (E[]) Arrays.copyOf(array, size, toHold.getClass());
		System.arraycopy(array, 0, toHold, 0, size);
		if (toHold.length > size)
			toHold[size] = null;
		return toHold;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

	@Override
	public Iterator<E> iterator() {
		return new MyIterator<E>(array);
	}

}
