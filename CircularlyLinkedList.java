/*
 * CIRCULARLY LINKED LIST:
 * 
 * 	- a singly linked list,
 *  - whose tail points to the head,
 *  - forming a circular structure 
 * 
 * OPTIMIZATION:
 * 
 * 		We remove head from circularly linked list, 
 * 		head can be accessed from tail.getNext().
 * 		So that a bit of memory is saved as well as make the code much simpler and efficient.
 * 
 * OPERATION:
 * 	- rotate:
 * 		advance the tail reference to point to the node followed by it earlier.
 * 
 */

package com.java.DSA.circularlylinkedlist;

public class CircularlyLinkedList<E> {
	private Node<E> tail;
	private int size;
	
	public CircularlyLinkedList() {
		tail = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public E first() {
		if (isEmpty())
			return null;
		return tail.getNext().getElement();
	}
	
	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement();
	}
	
	public void rotate() {
		if(!isEmpty())
			tail = tail.getNext();
	}
	
	public void addFirst(E e) {
		Node<E> newest = new Node<>(e);
		if (isEmpty()) {
			tail = newest;
			newest.setNext(tail);
		} else {
			newest.setNext(tail.getNext());	
			tail.setNext(newest);
		}
		size++;
	}
	
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}
	
	public E removeFirst() {
		if (isEmpty())
			return null;
		E data = first();
		size--;
		if (isEmpty()) 
			tail = null;
		else
			tail.setNext(tail.getNext().getNext());
		return data;
	}
}
