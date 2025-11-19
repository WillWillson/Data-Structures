public class Main{
	public static void main(String[] args){
		
		// instantiate our BST object
		BST tree = new BST();
		
		// load it up with some initial values
		tree.insert(5);
		tree.insert(15);
		tree.insert(2);
		
		// are you on Windows?
		Vis.runOnWindows = true; // set to true if running on Windows
		
		// test it out
		Vis.test(tree);
	}
}