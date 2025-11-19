/** Queue abstract data type */
public class Queue<T> {
  /** List objects to hold our queue items.
      Use List operations to implement the methods below */
  private List<T> list;
  
  /**
  *   The Constructor
  **/
  public Queue(){
    // instantiate list here
	this.list = new List<T>();                        // creates a new list
  }
  
  /**
  *   This method will add the given values to the list.
  **/
  public void enqueue(T value){
	this.list.append(value);                          // adds the values to the list
  }
  
  /**
  *   This method will take the given list and will remove the certain value
  *   at a certain index, and will delete it from the list.
  **/
  public T dequeue(){
	int	index = 0;									  // this is the value that will sets the index
	T indexValue = this.list.getValueAt(index);       // this will get the value at the specific index
	this.list.deleteAt(index);                        // this deletes the value at a certain index
	return indexValue;                                // this returns the value of the index
  }

  /** 
  *   This method will give the value at the front of the list.
  **/
  public T front(){
	return this.list.getValueAt(0);                   // This returns the value at the first position of the list
  }

  /**
  *   This method will return that the given list is Empty.
  **/ 
  public boolean isEmpty(){
	return this.list.size() == 0;                     // This returns that the size of the list is false
  }
  
  /**
  *   This method will reverse the queue by putting it in a stack,
  *   and checking if it is Empty, and it will put the queue in reverse
  **/
  public void reverse(){
	Stack<T> stack = new Stack<T>();
	
	while(!isEmpty()){                                // This checks if the isEmpty method is false
		stack.push(dequeue());                        // while it is not Empty, it will dequeue the list and add it to the stack
	}
	
	while(!stack.isEmpty()){                          // This checks if the isEmpty method is false
		this.list.append(stack.pop());                // while it is not Empty, it will pop from the stack, and add it to the list in reverse order
	}
  }
}
