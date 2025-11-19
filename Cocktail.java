public class Cocktail{
	
	public void cocktailSort(int array[]){
		int list[] = array;
		int n = list.length;
		for(int i = 1; i < (n - 1)/2 + 1; i++){
			boolean anySwapsMade = false;
			
			for(int j = i; j < (n - i); j++){
				
				if(list[j] < list[j - 1]){
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					anySwapsMade = true;
				}
			}
				
			if(!anySwapsMade){
				break;
			}
			
			anySwapsMade = false;
			
			for(int j = n - i; j > (i - 1); j--){
				if(list[j] < list[j - 1]){
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					anySwapsMade = true;
				}
			}
			
			if(!anySwapsMade){
				break;
			}
		}
	}
	
	public void printCocktailArray(int array[], int n){
		System.out.print("  Cocktail sorted: ");
		for(int k = 0; k < n; k++){
			System.out.print(array[k] + " ");
		}
		System.out.println("");
	}
}