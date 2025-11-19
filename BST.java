public class BST{
	
	// declareing variables
	public Node root;
	private String string;
	
	// constructor
	public BST(){
		this.root = null;
	}
	
	// method will insert the value that is inputed, and will add it accordingly to the list
	public void insert(int value){
		if(this.root == null){
			this.root = new Node(value);
			return;
		}
		
		Node childNode = this.root;
		Node parentNode = null;
		while(true){
			parentNode = childNode;
			if(childNode.getData() > value){
				childNode = childNode.getLeft();
				if(childNode == null){
					parentNode.setLeft(new Node(value));
					return;
				}
			}
			
			else{
				childNode = childNode.getRight();
				if(childNode == null){
					parentNode.setRight(new Node(value));
					return;
				}
			}
		}
	}
	
	// will see if the value given is in the tree recursively
	public boolean search(int value){
		
		if(this.root == null){
			return false;
		}
		return search(value, this.root);
		
	}

	private boolean search(int value, Node node){
		if(node != null){
			if(node.getData() == value){
				return true;
			}
			
			else if(node.getData() > value){
				return search(value, node.getLeft());
			}
			
			else if(node.getData() < value){
				return search(value, node.getRight());
			}
		}
		return false;
	}
	
	// method that deletes the given value
	public void delete(int value){
		Node newNode = this.root;
		Node newNode2 = this.root;
		boolean isLeftNode = false;
		
		while(newNode.getData() != value){
			newNode2 = newNode;
			
			if(newNode.getData() > value){
				newNode = newNode.getLeft();
				isLeftNode = true;
			}
			
			else if(newNode.getData() < value){
				newNode = newNode.getRight();
				isLeftNode = false;
			}
			
			if(newNode == null){
				return;
			}
		}
		
		// case 1
		if(newNode.getLeft() == null && newNode.getRight() == null){
			
			if(newNode == this.root){
				this.root = null;
			}
			
			if(isLeftNode){
				newNode2.setLeft(null);
			}
			
			else{
				newNode2.setRight(null);
			}
			
		}
		
		// case 2
		else if(newNode.getLeft() != null && newNode.getRight() == null){
			if(this.root == newNode){
				this.root = newNode.getLeft();
			}
			
			if(isLeftNode){
				newNode2.setLeft(newNode.getLeft());
			}
			
			else{
				newNode2.setRight(newNode.getLeft());
			}
		}
		
		else if(newNode.getRight() != null && newNode.getLeft() == null){
			if(this.root == newNode){
				this.root = newNode.getRight();
			}
			
			if(isLeftNode){
				newNode2.setLeft(newNode.getRight());
			}
			
			else{
				newNode2.setRight(newNode.getRight());
			}
		}
		
		// case 3
		else if(newNode.getLeft() != null && newNode.getRight() != null){
			Node successor = successor(newNode, newNode2, value);
			if(newNode == this.root){
				this.root = successor;
			}
			
			if(isLeftNode){
				newNode2.setLeft(successor);
			}
			
			else{
				newNode2.setRight(successor);
			}
			
			successor.setLeft(newNode.getLeft());
		}
	}
	
	// this will find the left node at which node is chosen
	private Node findMinimum(Node root){
		while(root.getLeft() != null){
			root = root.getLeft();
		}
		return root;
	}
	
	// successor method for the case of a parent having two child nodes
	private Node successor(Node root, Node cur, int value){
		if(root == null){
			return cur;
		}
		
		if(root.getData() == value){
			if(root.getRight() != null){
				return findMinimum(root.getRight());
			}
		}
		
		else if(value < root.getData()){
			cur = root;
			return successor(root.getLeft(), cur, value);
		}
		
		else{
			return successor(root.getRight(), cur, value);
		}
		return cur;
	}
	
	// will get the minimum value in the tree
	public int min(){
		
		if(this.root == null){
			return 0;
		}
		
		Node newNode = this.root;
		while(newNode.getLeft() != null){
			newNode = newNode.getLeft();
		}
		
		return newNode.getData();
	}
	
	// will get the max value in the tree
	public int max(){
		
		if(this.root == null){
			return 0;
		}
		
		Node newNode = this.root;
		while(newNode.getRight() != null){
			newNode = newNode.getRight();
		}
		
		return newNode.getData();
	}
	
	public String inorder(){
		this.string = " ";
		this.inorderRecursive(this.root);
		return this.string;
	}
	
	// recursive string method for printing out the values in inorder
	private String inorderRecursive(Node cur){
		if(cur != null){
			inorderRecursive(cur.getLeft());
			this.string += cur.getData() + " ";
			inorderRecursive(cur.getRight());
		}
		return this.string;
	}
	
	public String preorder(){
		this.string = " ";
		preorderRecursive(root);
		return this.string;
	}
	
	// recursive string method for printing out the values in preorder
	private String preorderRecursive(Node cur){
		if(cur != null){
			this.string += cur.getData() + " ";
			preorderRecursive(cur.getLeft());
			preorderRecursive(cur.getRight());
		}
		
		return this.string;
	}
	
	public String postorder(){
		this.string= " ";
		postorderRecursive(root);
		return this.string;
	}
	
	// recursive string method for printing out the values in postorder
	private String postorderRecursive(Node cur){
		if(cur != null){
			preorderRecursive(cur.getLeft());
			preorderRecursive(cur.getRight());
			this.string += cur.getData() + " ";
		}
		
		return this.string;
	}
}