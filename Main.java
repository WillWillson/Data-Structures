import java.util.Timer;

public class Main{
	public static void main(String[] args){
		int min = 0;
		int max = 150;
		int n = 20;
		int array[] = new int[n];
		
		for(int i = 0; i < n; i++){
			int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
			array[i] = randomInt;
		}
		
		// first copy of the array
		int array1[] = new int[n];
		array1 = array;
		for(int i = 0; i < n; i++){
			array1[i] = array[i];
		}
		
		// second copy of the array
		int array2[] = new int[n];
		array2 = array;
		for(int i = 0; i < n; i++){
			array2[i] = array[i];
		}
		
		// third copy of the array
		int array3[] = new int[n];
		array3 = array;
		for(int i = 0; i < n; i++){
			array3[i] = array[i];
		}
		
		// prints out the original array
		System.out.println("TESTING with n = " + n);
		System.out.print("  Original List: ");
		for(int i = 0; i < n; i++){
			System.out.print(array[i] + " " );
		}
		System.out.println("");
		
		// sorts the third copy of the array using cocktail sort
		Cocktail cocktailSort = new Cocktail();
		cocktailSort.cocktailSort(array1);
		cocktailSort.printCocktailArray(array1, n);
		
		// sorts the third copy of the array using quick sort
		Quick quickSort = new Quick();
		quickSort.quickSort(array2, 0, n - 1);
		quickSort.printQuickArray(array2, n);
		
		// sorts the third copy of the array using counting sort
		Counting countingSort = new Counting();
		countingSort.countingSort(array3);
		countingSort.printCountArray(array3, n);
		
		System.out.println("");
		
		// creates the new length
		n = 20000;
		int array4[] = new int[n];
		System.out.println("TESTING with n = " + n);
		
		// creates the random array with the new length
		for(int i = 0; i < n; i++){
			int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
			array4[i] = randomInt;
		}
		
		// first copy of the array for calculating the time
		int array5[] = new int[n];
		array5 = array4;
		for(int i = 0; i < n; i++){
			array5[i] = array4[i];
		}
		
		// second copy of the array for calculating the time
		int array6[] = new int[n];
		array6 = array4;
		for(int i = 0; i < n; i++){
			array6[i] = array4[i];
		}
		
		// third copy of the array for calculating the time
		int array7[] = new int[n];
		array7 = array4;
		for(int i = 0; i < n; i++){
			array7[i] = array4[i];
		}
		
		// the time for the cocktail sort
		Cocktail cocktailSort2 = new Cocktail();
		long start1 = System.nanoTime();
		cocktailSort.cocktailSort(array5);
		long stop1 = System.nanoTime();
		float duration1 = stop1 - start1;
		System.out.println("  Cocktail took " + (duration1/1000000) + " ms");
		
		// the time for the quick sort
		Quick quickSort2 = new Quick();
		long start2 = System.nanoTime();
		quickSort2.quickSort(array6, 0, n - 1);
		long stop2 = System.nanoTime();
		float duration2 = stop2 - start2;
		System.out.println("  Quick    took " + (duration2/1000000) + " ms");
		
		//the time for the counting sort
		Counting countingSort2 = new Counting();
		long start3 = System.nanoTime();
		countingSort2.countingSort(array7);
		long stop3 = System.nanoTime();
		float duration3 = stop3 - start3;
		System.out.println("  Counting took " + (duration3/1000000) + " ms");
	}
}