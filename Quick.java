public class Quick{
	
	public void quickSort(int array[], int left, int right){
		int list[] = array;
		if(left < right){
			int p = partition(list, left, right);
			quickSort(list, left, p - 1);
			quickSort(list, p + 1, right);
		}
	}
	
	public int partition(int list[], int left, int right){
		int pivotPos = left;
		left = left + 1;
		while(true){
			while(left < list.length && list[left] < list[pivotPos]){
				left = left + 1;
			}
			
			while(right >= 0 && list[right] > list[pivotPos]){
				right = right - 1;
			}
			
			if(left >= right){
				break;
			}
			
			else{
				int temp = list[left];
				list[left] = list[right];
				list[right] = temp;
				left = left + 1;
				right = right - 1;
			}
		}
		
		int temp = list[right];
		list[right] = list[pivotPos];
		list[pivotPos] = temp;
		return right;
	}
	
	public void printQuickArray(int array[], int n){
		System.out.print("  Quick    sorted: ");
		for(int i = 0; i < n; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
}