package utilities;
/*
 * Author: Jason Huang, Shuo Han, Paignton Wild
 * Date 2022-07-17
 */
public class MyDLLNode<E> {
	private E item;  
    MyDLLNode previous;  
    MyDLLNode next;  

    /*
     * Constructor for Node
     * @param E item element that is to be stored in the node
     */
    public MyDLLNode(E item) {  
        this.item = item;
        previous = null;
        next = null;
    }
    /*
     * Getting item of the node
     * @return item element
     */
	public E getItem() {
		return this.item;
	}
	/*
     * Setting item of the node
     * @param item element to be set
     */
	public void setItem(E item) {
		this.item = item;
	}
	/*
     * Getting previous node
     * @return previous node
     */
	public MyDLLNode getPrevious() {
		return previous;
	}
	/*
     * Setting previous node
     * @param MyDLLNode previous node to be set
     */
	public void setPrevious(MyDLLNode previous) {
		this.previous = previous;
	}
	/*
     * Getting next node
     * @return next node
     */
	public MyDLLNode getNext() {
		return next;
	}
	/*
     * Setting previous node
     * @param MyDLLNode next node
     */
	public void setNext(MyDLLNode next) {
		this.next = next;
	}

	
    

}
