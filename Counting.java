public class Counting{
	public void countingSort(int array[]){
		int list[] = array;
		int n = list.length;
		
		int count[] = new int[256];
		for(int i = 0; i < 256; i++){
			count[i] = 0;
		}
		
		for(int i = 0; i < n; i++){
			count[list[i]] = count[list[i]] + 1;
		}
		
		int total = 0;
		for(int i = 0; i < count.length; i++){
			int oldCount = count[i];
			count[i] = total;
			total = total + oldCount;
		}
		
		int output[] = new int[n];
		for(int i = 0; i < n; i++){
			int value = list[i];
			output[count[value]] = value;
			count[value] = count[value] + 1;
		}
		
		for(int i = 0; i < n; i++){
			list[i] = output[i];
		}
	}
	
	public void printCountArray(int array[], int n){
		System.out.print("  Counting sorted: ");
		for(int i = 0; i < n; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}
}