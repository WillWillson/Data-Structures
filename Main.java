/**
 * Name: William Wilson
 * Date: 10/5/21
 * Description:  Programming Assignment 3
 */


/** The interface for our List (Abstract Data Type) */
interface IList {
	
	/** Adds the given value to the end of the list */
	void append(char value);
	
	/** Adds the given value to the beginning of the list */
	void prepend(char value);
	
	/** Deletes the container at the given position (a container holds a value) */
	void deleteAt(int position);
	
	/** Returns the number of values currently in our list */
	int size();
		
	/** Retrieves the value at the given position (0-based) */
	char getValueAt(int position);

	/** Searches for the FIRST occurence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	int positionOf(char value);
}


/** Array implementation of our List */
class ListAsArray implements IList {
	// initialize array to a size of 30 elements
	// this will prevent the need to resize our array
	char[] array;
	int endPosition;
	
	public ListAsArray(){
		array = new char[30];
		endPosition = 0;
	}
	
	/** This method will append the elements to the array */
	@Override
	public void append(char value){
		if(endPosition < array.length){
			array[endPosition] = value;
			endPosition++;
		}
	}
	
	/** This method will add the elements to the front of the array
	*   instead of the back of it.
	**/
	@Override
	public void prepend(char value){
		if(endPosition < array.length){
			for(int i = endPosition; i > 0;i--){
				array[i] = array[i -1];
			}
			
			array[0] = value;
			endPosition++;
		}
	}
	
	/** This method  will take in the position and 
	*   will delete the value at that position.
	**/
	@Override
	public void deleteAt(int position){
		if(position >= 0 && position < endPosition){
			for(int i = position; i < endPosition - 1; i++){
				array[i] = array[i + 1];
			}
			endPosition--;
		}
		
	}
	
	/** this method gives the endposition */
	@Override
	public int size(){
		return endPosition;
	}
	/** this method will get the value at a certain position and display it */
	@Override
	public char getValueAt(int position){
		
		if(position >= 0 && position < endPosition){
			return array[position];
		}
		
		throw new IndexOutOfBoundsException("Invalid Position: " + position);
	}
	
	/** This method will give the position of a certain value*/
	@Override
	public int positionOf(char value){
		for(int i = 0; i < endPosition; i++){
			if(array[i] == value){
				return i;
			}
		}
		return -1;
		
	}
}


/** Singly Linked List implementation of our List */
class ListAsLinkedList implements IList {
	private Node head;
	private Node tail;
	int count;
	
	public void ListAsLinkedList(){
		head = tail = null;
		count = 0;
	}
	
	/** This method appends the values to the front of the list
	*   that was created in the main.
	**/
	@Override
	public void append(char value){
		Node temp = new Node(value);
		if(head == null){
			head = temp;
			tail = temp;
		}
		
		else{
			tail.next = temp;
			tail = temp;
		}
		count++;
	}
	
	/** This method will prepend the values which means that
	*   the values are added to the front of the list that 
	*   was created.
	**/
	@Override
	public void prepend(char value){
		Node temp = new Node(value);
		if(head == null){
			head = temp;
			tail = temp;
		}
		
		else{
			temp.next = head;
			head = temp;
		}
		count++;
	}
	
	/** This method will take in the position, and 
	*   will delete the certain value at the given position.
	**/
	@Override
	public void deleteAt(int position){
		if(position >= 0 && position < count){
			
			if(position == 0){
				head = head.next;
				
				if(head == null){
					tail = null;
				}
				count--;
				return;
			}
			
			Node current = head;
			
			for(int i = 0; i < position -1; i++){
				current = current.next;
			}
			current.next = current.next.next;
			
			if(current.next == null){
				tail = current;
			}
			
			count--;
		}
	}
	
	/** This method will take in the size of the list */
	@Override
	public int size(){
		return count;
	}
	
	/** This method will take in a position, and 
	*   will then give the value that is located in the position.
	**/
	@Override
	public char getValueAt(int position){
		
		if(position < 0 || position >= count){
			throw new IndexOutOfBoundsException("Invalid Position : " + position);
		}
		
		Node temp = head;
		for(int i = 0; i < position; i++){
			temp = temp.next;
		}
		
		return temp.data;
		
	}
	
	/** This method calculates what the position is */
	@Override
	public int positionOf(char value){
		int index = 0;
		Node temp = new Node(value);
		for(temp = head; temp != null; temp = temp.next){
			if(temp.data == value){
				return index;
			}
			index++;
		}
		return -1;
	}
	
	public void printBackwards(){
		Node cur = tail;
		
		while(cur != null){
			cur = cur.prev;
		}
	}
	}


/** A singly linked list node for our singly linked list */
class Node {
	public char data;
	public Node next;
	public Node prev;
	
	public Node(char data){
		this.data = data;
		next = null;
	}
	
	public char getData(){
		return data;
	}
	
	public Node getNext(){
		return next;
	}
	
	public Node getPrev(){
		return prev;
	}
	
	public void setPrev(Node newPrev){
		this.prev = newPrev;
	}
	
	public void setNext(Node newNext){
		this.next = newNext;
	}
	}


/** contains our entry point */
public class Main {
	/** entry point - DO NOT CHANGE the pre-existing code below */
	public static void main(String[] args) {
		int[] numbers = {105,116,112,115,65,58,47,47,116,105,110,121,88,117,114,108,46,99,111,109,47};
		int[] numbers2 = {97,59,111,53,33,111,106,42,50};
		int[] numbers3 = {116,104,32,111,116,32,111,71};
		
		
		/// List as an Array
		IList array = new ListAsArray();
		
		// add values
		for(int num : numbers) {
			array.append((char)num);
		}
		for(int num : numbers3) {
			array.prepend((char)num);
		}
		
		// delete some values
		int position;
		
		position = array.positionOf((char)105);
		array.deleteAt(position);
		
		position = array.positionOf((char)65);
		array.deleteAt(position);
		
		position = array.positionOf((char)88);
		array.deleteAt(position);
	 
		// print em
		position = 0;
		while (position < array.size()) {
			System.out.print(array.getValueAt(position));
			position++;
		}
		
		
		/// List as a Linked List
		IList linkedList = new ListAsLinkedList();
		
		// add values
		for(int num : numbers2) {
			linkedList.append((char)num);
		}
		linkedList.prepend((char)55);
		linkedList.prepend((char)121);

		// delete some values
		position = linkedList.positionOf((char)59);
		linkedList.deleteAt(position);
		
		position = linkedList.positionOf((char)33);
		linkedList.deleteAt(position);
		
		position = linkedList.positionOf((char)42);
		linkedList.deleteAt(position);
		
		// print em
		position = 0;
		while (position < linkedList.size()) {
			System.out.print(linkedList.getValueAt(position));
			position++;
		}
		
		System.out.println();
		
		System.out.println((Math.floor(35.1 * 2)) % 10);
	}}
