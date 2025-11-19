/** Stack abstract data type */
public class Stack<T> {
  /** List objects to hold our stack items.
      Use List operations to implement the methods below */
  private List<T> list;

  /**
  *   The Constructor
  **/
  public Stack() {
    // instantiate list here
	this.list = new List<T>();                        // creates a new list
  }

  /**
  *   This method will add the given values to the list.
  **/
  public void push(T value){
	this.list.append(value);                          // adds values to the list
  }

  /**
  *   This method will take the given list and will remove the certain value
  *   at a certain index, and will delete it from the list.
  **/
  public T pop(){
	int	index = this.list.size() - 1;                 // this is the value that will sets the index
	T indexValue = this.list.getValueAt(index);       // this will get the value at the specific index
	this.list.deleteAt(index);                        // this deletes the value at a certain index
	return indexValue;                                // this returns the value of the index
  }

  /** 
  *   This method will give the value at the front of the list.
  **/
  public T peek(){
	return this.list.getValueAt(this.list.size() - 1);    // This returns the value at the first position of the list
  }

  /**
  *   This method will return that the given list is Empty.
  **/
  public boolean isEmpty(){
	return this.list.size() == 0;                     //// This returns that the size of the list is false
  }
}
