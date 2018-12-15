/*
 * _________________________________________________________________________________
 * 
 * Linked List:
 * 	- is a collection of nodes
 * 	- that forms a linear sequence
 * 	
 * Singly Linked List: 
 * 	- each node contains
 * 	- element, and
 * 	- reference to next node
 * _________________________________________________________________________________ 
 * 
 * ALGORITHMS:
 * 
 * ---------------------------------------------------------------------------------
 * INSERTING an element at head of SINGLY LINKED LIST:
 * 
 * addFirst(e) 
 * 		newest = Node(e)	 - create an new node with element e
 * 		newest.next = head	 - set next of new node to reference the old head		
 * 		head = newest		 - set head to reference the newest as new head
 * 		size++			 - increase the size of singly linked list by 1
 * 
 * ---------------------------------------------------------------------------------
 * INSERTING an element at tail of SINGLY LINKED LIST:
 * 
 * addLast(e)
 * 		newest = Node(e)	 - create an new node with element e
 * 		newest.next = null	 - set next of new node to reference the null object
 * 		tail.next = newest	 - set next of old tail to reference the newest
 * 		tail = newest		 - set tail to reference the newest as new tail 		
 * 		size++			 - increase the size of singly linked list by 1
 * 
 * ---------------------------------------------------------------------------------
 * REMOVING an element from SINGLY LINKED LIST:
 * 
 * removeFirst()
 * 		if head == null
 * 			the list is empty.
 * 		head = head.next	 - set new head to point to the next of old head
 * 		size--			 - decrease size of singly linked list by 1
 * 
 * ---------------------------------------------------------------------------------
 * IMPLEMENTATION:
 * 
 * 	size( ):		 Returns the number of elements in the list.
 *	isEmpty( ):		 Returns true if the list is empty, and false otherwise.
 *	first( ):		 Returns (but does not remove) the first element in the list.
 *	last( ):		 Returns (but does not remove) the last element in the list.
 *	addFirst(e):	 	 Adds a new element to the front of the list.
 *	addLast(e):		 Adds a new element to the end of the list.
 *	removeFirst( ):	 	 Removes and returns the first element of the list.
 */
package com.java.DSA.singlylinkedlist;

public class SinglyLinkedList<E> {
	private Node <E> head;
	private Node <E> tail;
	private int size;
	
	public SinglyLinkedList() {
		head = null;
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
		return head.getElement();
	}
	
	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement();
	}
	
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if(isEmpty()) 
			tail = head;
		size++;
	}
	
	public void addLast(E e) {
		Node<E> newest = new Node<>(e);
		if (isEmpty()) 
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}
	
	public E removeFirst() {
		if (isEmpty())
			return null;
		
		E data = first();
		head = head.getNext();
		size--;
		
		if (isEmpty()) 
			tail = null;
		
		return data;
	}

}
