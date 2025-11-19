public class Main{
	public static void main(String[] args){
		Dictionary dictionary = new Dictionary();
		dictionary.insert("Bob", 50);
		dictionary.insert("Bill", 120);
		dictionary.insert("Roger", 80);
		dictionary.insert("Kevin", 350);
		dictionary.insert("Jerry", 65);
		dictionary.insert("Liam", 500);
		
		dictionary.search("Bob");
		dictionary.search("Bill");
		dictionary.search("Roger");
		dictionary.search("Kevin");
		dictionary.search("Jerry");
		dictionary.search("Liam");
		System.out.println("");
		
		dictionary.delete("Bob");
		dictionary.search("Bill");
		dictionary.delete("Roger");
		dictionary.search("Kevin");
		dictionary.delete("Jerry");
		dictionary.insert("Liam", 650);
		dictionary.search("Liam");
	}
}