package com.java.DSA.doublylinkedlist;

public class DoublyLinkedListImpl {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		// OUTPUT - true, null, null, 0
		System.out.println("Is Empty at first: " + list.isEmpty() + "\nFirst: " + list.first() + "\nLast: " + list.last() + "\nSize: " + list.size());

		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addFirst(5);
		
		// OUTPUT - false, 5, 1, 5 
		System.out.println("Is Empty at first: " + list.isEmpty() + "\nFirst: " + list.first() + "\nLast: " + list.last() + "\nSize: " + list.size());

		list.addLast(11);
		list.addLast(12);
		list.addLast(13);
		list.addLast(14);
		list.addLast(15);
		
		// OUTPUT - false, 5, 15, 10
		System.out.println("Is Empty at first: " + list.isEmpty() + "\nFirst: " + list.first() + "\nLast: " + list.last() + "\nSize: " + list.size());

		list.removeLast();
		list.removeFirst();

		// OUTPUT - false, 4, 14, 8
		System.out.println("Is Empty at first: " + list.isEmpty() + "\nFirst: " + list.first() + "\nLast: " + list.last() + "\nSize: " + list.size());
		
	}
}
