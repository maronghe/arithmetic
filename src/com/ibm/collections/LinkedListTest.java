package com.ibm.collections;

import java.util.LinkedList;

/**
 * Tester
 */
public class LinkedListTest {
	public static void main(String[] args) {

		LoganLinkedList<Integer> list = new LoganLinkedList<>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}

		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
		}
//		LinkedList
		while(list.isEmpty()){
			System.out.println(list.getSize());
			System.out.println("Removed item : " + list.removeLast());
			//System.out.println("Removed item : " + list.removeFirst());
		}
	}
}
