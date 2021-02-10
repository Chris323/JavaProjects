package mergeAndBin;

public class BinarySearch {

	public int runBinarySearch(int[] sortedArray, int key, int low, int high) {
			    int index = Integer.MAX_VALUE;
			     
			    while (low <= high) {
			        int mid = (low + high) / 2;
			        if (sortedArray[mid] < key) {
			            low = mid + 1;
			        } else if (sortedArray[mid] > key) {
			            high = mid - 1;
			        } else if (sortedArray[mid] == key) {
			            index = mid;
			            break;
			        }
			    }
//			    if(key == index) {
			    return index;
//			    }
//			    else {
//			    	return -1;
//			    }
			}
}
