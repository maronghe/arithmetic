package com.ibm.collections;

import java.util.NoSuchElementException;

/**
 * 单向链表
 */
public class LoganLinkedList<E> {
	private int size = 0;
	private LoganNode<E> head;
	private LoganNode<E> last;

	/**
	 *  添加个节点
	 * @param value
	 */
	public void add(E value){
		if(head == null){
//			LoganNode<Integer> tempNode = new LoganNode(node);
			head = new LoganNode<>(value);
			last = new LoganNode<>(value);
//			head.setValue(value);
//			last.setValue(value);
		}else{
			LoganNode temp = head;
			while (temp.getNext() != null){
				temp = temp.getNext();
			}
//			temp.setValue(value);
			temp.setNext(new LoganNode(value));
			last = new LoganNode<>(value);
		}
		size ++;
	}

	/**
	 * 获取当前node
	 * @return
	 */
	public E get(int i){
		checkIndexArray(i);
		LoganNode<E> temp = head;
		int j = 0;
		for (; j < i; j++) {
			temp = temp.getNext();
		}
		return temp.getValue();
	}

	/**
	 * 检查数组是否越界
	 * @param i
	 */
	private void checkIndexArray(int i) {
		if (i < 0 || i >= size){
			throw new LoganIndexOutOfBoundsException("index : " + i + ", size : " + size);
		}
	}

	/**
	 * 获取集合的大小
	 * @return size
	 */
	public int getSize(){
		return size;
	}

	/**
	 * 获取最后节点
	 * @return last one
	 */
	public E getLast(){
		if(last == null){
			throw new NoSuchElementException();
		}else {
			return (E) last.getValue();
		}
	}

	public E getFirst(){
		if(head == null){
			throw new NoSuchElementException();
		}else {
			return (E) head.getValue();
		}
	}

	public static void main(String[] args) {
		LoganLinkedList<Integer> myNodes = new LoganLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
//			LoganNode tempNode = new LoganNode(i);
			myNodes.add(i);
		}
		System.out.println(myNodes.getSize());
		// foreach
//		LoganNode<Object> currentNode = (LoganNode<Object>) myNodes.get(10);
//		while (currentNode != null){
//			System.out.println(currentNode.getValue());
//			currentNode = currentNode.getNext();
//		}
//		System.out.println("end");

		for (int i = 0; i < myNodes.getSize() ; i ++){
			System.out.println(myNodes.get(i));
		}

//		LinkedList list = new LinkedList();
//		System.out.println(list.get(0));
	}

}

/**
 * 自定义节点
 */
class LoganNode<E> {

	public LoganNode(E value){
		this.value = value;
	}
	private E value;
	private LoganNode next;

	public LoganNode getNext() {
		return next;
	}

	public void setNext(LoganNode next) {
		this.next = next;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}
}

/**
 * 自定义异常
 */
class LoganIndexOutOfBoundsException extends RuntimeException {
	public LoganIndexOutOfBoundsException(String message) {
	}
}