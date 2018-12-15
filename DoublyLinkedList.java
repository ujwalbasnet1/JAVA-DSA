/*
 * DOUBLY LINKED LIST:
 * 
 * - allow many operations with time complexity O(1) - 
 * 		- including insertions and deletions at arbitrary positions within the list
 * 
 * - it consists - 
 * 			- collection of nodes
 * 			- node :
 * 				- element	: item on the list
 * 				- next		: reference to the node next to it
 * 				- previous	: reference to the node previous to it
 * 
 * OPTIMIZATIONS:
 * 	
 * 	HEADER & TRAILER Sentinels:
 * 		- the dummy nodes, which do not carry element of the primary sequence,
 * 		- at both the ends of the list are header and trailer,
 * 		- which avoids some special cases while operating near the boundary of the doubly linked list
 *  
 */

package com.java.DSA.doublylinkedlist;

public class DoublyLinkedList<E> {
	private Node<E> header;
	private Node<E> trailer;
	private int size;
	
	public DoublyLinkedList() {
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, header, null);
		header.setNext(trailer);
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
		return header.getNext().getElement();
	}
	
	public E last() {
		if (isEmpty()) 
			return null;
		return trailer.getPrev().getElement();
	}
	
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
	
	public E removeFirst() {
		if (isEmpty())
			return null;
		return remove(header.getNext());
	}
	
	public E removeLast() {
		if (isEmpty())
			return null;
		return remove(trailer.getPrev());
	}
	
//	private methods for updating
	private void addBetween(E e, Node<E> previous, Node<E> after) {
		Node<E> newest = new Node<E>(e, previous, after);
		previous.setNext(newest);
		after.setPrev(newest);
		size++;
	}
	
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}
	
	
//	Doubly Node class
	private class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(E element, Node<E> prev, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
		

		public Node(E element) {
			this.element = element;
			this.next = null;
			this.prev = null;
		}


		public E getElement() {
			return element;
		}


		public void setElement(E element) {
			this.element = element;
		}


		public Node<E> getNext() {
			return next;
		}


		public void setNext(Node<E> next) {
			this.next = next;
		}


		public Node<E> getPrev() {
			return prev;
		}


		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
		
	}

}
