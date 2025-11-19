public class Dictionary<K,V>{

	// declaring the table and a preset null pair
	private KeyValuePair<K,V> DELETED;
	private KeyValuePair<K,V>[] hashTable;
	
	// constructor
	public Dictionary(){
		this.DELETED = new KeyValuePair<K,V>(null, null);
		this.hashTable = (KeyValuePair<K,V>[]) new KeyValuePair[7];
		for(int i = 0; i < this.hashTable.length; i++){
			this.hashTable[i] = null;
		}
	}
	
	// function that will insert each of the given pairs
	public void insert(K key, V value){
		int m = this.hashTable.length;
		int p = prehash(key);
		int attempt = 1;
		while(attempt < m){
			int index = hash(p, attempt);
			if(this.hashTable[index] == null || this.hashTable[index] == this.DELETED){
				this.hashTable[index] = new KeyValuePair<K,V>(key, value);
				break;
			}
			
			else if(this.hashTable[index].getKey().equals(key)){
				this.hashTable[index].setValue(value);
				break;
			}
			attempt += 1;
		}
		if(attempt >= m){
			m += 1;
			insert(key, value);
		}
	}
	
	// this function will search the dictionary and will print out the correct response
	public V search(K key){
		int i = 1;
		int p = prehash(key);
		while(i < this.hashTable.length){
			KeyValuePair<K,V> keyValuePair = this.hashTable[hash(p, i)];
			if(keyValuePair == null){
				break;
			}
			
			if(keyValuePair != this.DELETED && keyValuePair.getKey().equals(key)){
				System.out.println(key + " makes $" + keyValuePair.getValue() + "k a year");
				return keyValuePair.getValue();
			}
			i++;
		}
		return null;
	}
	
	//this function will delete the given key and value, it will also print out the correct response
	public void delete(K key){
		int i = 1;
		int p = prehash(key);
		KeyValuePair<K,V> keyValuePair = null;
		while(i < this.hashTable.length){
			int h = hash(p, i);
			keyValuePair = this.hashTable[h];
			if(keyValuePair == this.DELETED){
				i++;
			}
			else{
				if(keyValuePair == null){
					break;
				}
				
				if(keyValuePair.getKey().equals(key)){
					System.out.println(key + " got fired");
					break;
				}
				i++;
			}
		}
	}
	
	// prehash function
	public int prehash(K key){
		return Math.abs(key.hashCode());
	}
	
	// linear hash function
	public int hash(int n, int n2){
		return (h1(n) + (n2 - 1)) % this.hashTable.length;
	}
	
	// division hash function
	public int h1(int n){
		return n % this.hashTable.length;
	}
}