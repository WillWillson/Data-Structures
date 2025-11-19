/** Linked List implementation of our List abstract data type */
public class List<T> {
  // put all fields from ListAsLinkedList class here
  
  private Node<T> head;
  private Node<T> tail;
  int count;
  
  public void ListAsLinkedList(){
	  head = tail = null;
	  count = 0;
	}
  
  // put all methods from ListAsLinkedList class here
  
  public void append(T value){
	  Node<T> temp = new Node<T>(value);
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
	
	public void prepend(T value){
		Node<T> temp = new Node<T>(value);
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
			
			Node<T> current = head;
			
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
	
	public int size(){
		return count;
	}
	
	/** This method will take in a position, and 
	*   will then give the value that is located in the position.
	**/
	
	public T getValueAt(int position){
		
		if(position < 0 || position >= count){
			throw new IndexOutOfBoundsException("Invalid Position : " + position);
		}
		
		Node<T> temp = head;
		for(int i = 0; i < position; i++){
			temp = temp.next;
		}
		
		return temp.data;
		
	}
	
	/** This method calculates what the position is */

	public int positionOf(T value){
		int index = 0;
		Node<T> temp = new Node<T>(value);
		for(temp = head; temp != null; temp = temp.next){
			if(temp.data == value){
				return index;
			}
			index++;
		}
		return -1;
	}
}

/** A linked list node for our linked list */
class Node<T> {
  // put all fields from Node class here
  
  public T data;
  public Node<T> next;
  
  // put all methods from Node class here
  
  public Node(T data){
	  this.data = data;
	  next = null;
  }
  
  public T getData(){
	  return data;
  }
  
  public Node<T> getNext(){
	  return next;
  }
  
  public void setNext(Node<T> newNext){
	  this.next = newNext;
  }
  
}
