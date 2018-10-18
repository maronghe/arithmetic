package com.ibm.collections;

/**
 * Tester 
 */
public class LinkedListTest {
	public static void main(String[] args) {
		LoganLinkedList<Integer> list = new LoganLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
		}
	}
}
