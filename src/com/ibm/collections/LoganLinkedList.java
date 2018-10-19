package com.ibm.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 单向链表
 */
public class LoganLinkedList<E> implements Iterable {
	private transient int size = 0;// transient 不参与序列化反序列化
	private transient LoganNode<E> first;
	private transient LoganNode<E> last;


	/**
	 *  添加个节点
	 * @param value
	 */
	public  boolean add(E value){
		final LoganNode<E> l = last;
		final LoganNode<E> newNode = new LoganNode(value,null);
		last = newNode;
		if(first == null){
			first = newNode;
		}else{
			l.setNext(newNode); // the second time, l is the first item
		}
		size ++;
		return true;
	}

	/**
	 * 获取当前node
	 * @return
	 */
	public  E get(int i){
		checkIndexArray(i);
		LoganNode<E> temp = first;
		for (int j = 0; j < i; j++) {
			temp = temp.getNext();
		}
		return temp.getValue();
	}

	/**
	 * 移除第一个
	 * @return
	 */
	public  E removeFirst(){
		if(first == null){
			throw new NoSuchElementException();
		}

		final LoganNode<E> f = first;
		if(first.getNext() == null){
			first = null;
		}else {
			first = first.getNext();
		}
		E e = f.getValue();
		f.setValue(null);
		f.setNext(null); // help GC
		size --;
		if(size == 0){
			first = null;
			last = null;
		}
		return e;
	}

	private E removeFirst2(){
		final E element = first.getValue();
		final LoganNode<E> next = first.getNext();
		first.setValue(null);
		first.setNext(null);  // help GC
		first = next;
		if (next == null)
			last = null;
		else
			next.setNext(null);
		size--;
		return element;
	}


	/**
	 * 删除最后一个
	 * @return
	 */
	public E removeLast(){
		if(last == null){
			throw new NoSuchElementException();
		}
		E e = last.getValue();
		last.setValue(null);

		LoganNode<E> l = first;
		for (int i = 0; i < size - 2; i++) {
			l = l.getNext();
		}
		last = l;
		last.setNext(null);
		size --;

		if(size == 0){
			first = null;
			last = null;
		}
		return e;
	}

	//public Iterator<E> iterator(){
		//return
	//}


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
	 * 数组是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size > 0 ? true : false;
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
		if(first == null){
			throw new NoSuchElementException();
		}else {
			return (E) first.getValue();
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

	@Override
	public Iterator iterator() {
		return null;
	}
}

/**
 * 自定义节点
 */
class LoganNode<E> {

	public LoganNode(E value,LoganNode<E> next){
		this.value = value;
		this.next = next;
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