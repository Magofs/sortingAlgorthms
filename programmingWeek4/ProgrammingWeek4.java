package programmingWeek4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ProgrammingWeek4 {
	
	private static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;

	/*
	 * Task: Implementing binary search
	 * Solution: recursive that runs in O(log n)
	 */

	public String runFirstBinarySearch(int n) {
		// TODO Auto-generated method stub
		int[] a = {1, 5, 8, 12, 13};
		int[] keyArray = {8, 1, 23, 1, 11};
		
		String s = "";
		
		for (int i = 0; i < n; i++) 
			s += binarySearch(a, 0, n, keyArray[i]) + " ";
		return s;
		
	}
	
	private int binarySearch(int[] a, int low, int high, int key) {
		// TODO Auto-generated method stub
		int mid = (low + high)/2;
		if (high <= low) return -1;
		else if (a[mid] == key) return mid;
		else if (key < a[mid]) return binarySearch(a, low, mid - 1, key);
		else return binarySearch(a, mid + 1, high, key);		
	}
	
	
	
	public int runMajorityElement(int n) {
		int[] input = {2, 3, 9, 2, 2};
		int majority = majorityElement(input);
		return majority;
	}
	
	/*
	 * Goal: Find if there is a majority element i > 2/n in O(n log n).
	 * Solution: Add into a treemap and keep count over the duplicates,
	 * if one of them already is in the map and count is n/2,
	 * it must be a duplicate element, this solution works in O(n)
	 * A O(n log n) solution could be to add it into a BST and keep
	 * track of duplicate values. A binary search for an eventual
	 * majority can then be performed in O(log n).
	 */
	
	public int runFirstMajority(int n) {
		int[] input = {2, 3, 9, 2, 2};
		int increment = 1;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i <n; i++) {
			if (map.containsKey(input[i])) {
				int value = map.get(input[i]);
				map.remove(input[i]);
				map.put(input[i], value + increment);
				
				if (map.get(input[i]) > n/2) return 1;
			}
			else {
				map.put(input[i], 1);
			}
		
		}
		
		return 0;
		
		
	}
	
	public int runSecondMajority(int n) {
		int[] input = {1, 2, 3, 4};
		int increment = 1;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i <n; i++) {
			if (map.containsKey(input[i])) {
				int value = map.get(input[i]);
				map.remove(input[i]);
				map.put(input[i], value + increment);
				
				if (map.get(input[i]) > n/2) return 1;
			}
			else {
				map.put(input[i], 1);
			}
			
		}
		
		return 0;
		
		
	}
	
	public int runThirdMajority(int n) {
		int[] input = {1, 2, 3, 1};
		int increment = 1;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i <n; i++) {
			if (map.containsKey(input[i])) {
				int value = map.get(input[i]);
				map.remove(input[i]);
				map.put(input[i], value + increment);
				
				if (map.get(input[i]) > n/2) return 1;
			}
			else {
				map.put(input[i], 1);
			}
			
		}
		
		return 0;
		
	}
	
	private int majorityElement(int[] input) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			int current = input[i];
			for (int j = 1; j < input.length; j++) {
				if (input[j] == current)
					count = count + 1;
				if (count > input.length/2)
					return 1;
			}
			
		}
		return 0;
	}
	
	public boolean runSelectionSort() {
		int[] a = {8, 4, 2 ,5, 2};
		selectionSort(a);
		return isSorted(a);
	}
	
	private void selectionSort(int[] a) {
		
		for (int i = 0; i < a.length; i++) {
			int minIndex = i;
			for (int j = i+ 1; j < a.length; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
					
				}
			}
			swap(a, i, minIndex);
		}
	}
	
	private void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	public boolean runMergeSort() {
		int [] input = {7, 2, 5, 3, 7, 13, 1, 6};
		mergeSort(input, 0, input.length - 1);
		return isSorted(input);
	}
	
	private void mergeSort(int[] input, int floor, int ceiling) {
		// TODO Auto-generated method stub
		if (input.length <= 1) return;
		if (floor < ceiling) {
			int m = (floor + ceiling) / 2;
			mergeSort(input, floor, m);
			mergeSort(input, m + 1, ceiling);
			merge(input, floor, m, ceiling);
			
		}
	}

	private void merge(int[] input, int floor, int mid, int ceiling) {
		// TODO Auto-generated method stub
		int s1 = mid - floor + 1;
		int s2 = ceiling - mid;
		int [] a = new int[s1];
		int [] b = new int[s2];
		
		for (int i = 0; i < s1; i++)
			a[i] = input[floor + i];
		for (int j = 0; j < s2; j++)
			b[j] = input[mid + 1 + j]; 
		
		int c = 0; int d = 0;
		
		int k = floor;
		while(c < s1 && d < s2) {
			if (a[c] <= b[d]) {
				input[k] = a[c];
				c++;
			}
			else {
				input[k] = b[d];
				d++;
			}
			k++;
		}
		
		while (c < s1) 
        { 
            input[k] = a[c]; 
            c++; 
            k++; 
        } 
		
		while (d < s2) 
        { 
            input[k] = b[d]; 
            d++; 
            k++; 
        } 
		     
	}
	
	public boolean runQuickSort() {
		int[] arr = {59, 46, 32, 80, 46, 55, 87, 43, 44, 81};
		partition(arr, 0, arr.length);
		return isSorted(arr);
	}
	
	private void partition(int[] arr, int floor, int ceiling) {
		int m = floor + (ceiling >> 1);
		int i = floor;
		int n = floor + ceiling - 1;
		
		int mid = median(arr, i, m, n);
		
		int pivot = arr[mid];
		
		int b = floor;
		int c = floor + ceiling -1;
		
		while (true) {
			while (b <= c && arr[b] < pivot) b++;
			while (c >= b && arr[c] > pivot) c--;
			if (b > c)  break; 
			swap(arr, b++, c--);
			if (c + 1 - floor > 1) partition(arr, floor, c + 1 - floor);
			if (floor + ceiling - b > 1) partition(arr, b, floor + ceiling -b);
		}
	}
	
	/*
	 * Goal: Improve quicksort
	 * Solution: I use insertion sort on n < 7 and partition three ways on n > 40
	 */
	
	public boolean runOptimizedQuickSort() {
		int[] arr = {2, 3, 9, 2, 2};
		quickSort(arr, 0, arr.length);
		return isSorted(arr);
	}
	
	

	private int median(int[] arr, int a, int b, int c) {
		if (arr[a] > arr[b] && arr[a] < arr[c]) return a;
		else if (arr[b] > arr[a] && arr[b] < arr[c]) return b;
		else return c;		
	}
	
	private void quickSort(int[] arr, int floor, int ceiling) {
		//run insertion sort on smaller subarray's for efficiency, relaxes the 
		//number of recursive calls
		if (ceiling < 7) {
			for (int i = floor; i < ceiling + floor; i++) {
				for (int j = i; j > floor && arr[j - 1] > arr[j]; j--) {
					swap(arr, j, j - 1);
				}
			}
			return;
		}
		
		int mid = floor + (ceiling >> 1);
		
		if (ceiling > 7) {
			int i = floor;
			int n = floor + ceiling - 1;
			//partition three way for large subArrays
			if (ceiling > 40) {
				int s = ceiling / 9;
				i = median(arr, i, i + s, i + 2 * s);
				mid = median(arr, mid - s, mid, mid + s);
				n = median(arr, n - 2 * s, n - s, n);
			}
			
			mid = median(arr, i, mid, n);
		}
		
		int pivot = arr[mid];
		
		int a = floor, b = a, c = floor + ceiling - 1, d = c;
		
		while (true) {
			
			while (b <= c && arr[b] <= pivot) {
				if (arr[b] == pivot)
					swap(arr, a++, b);
				b++;
			}
			
			while (c >= b && arr[c] >= pivot) {
				if (arr[c] == pivot)
					swap(arr, c, d--);
				c--;
			}
			
			if (b > c)
				break;
			
			swap(arr, b++, c--);
		}
			
		int s, n = floor + ceiling;
			
		s = Math.min(a - floor, b - a); vecSwap(arr, floor, b - s, s);
		s = Math.min(d - c, n - d -1); vecSwap(arr, b, n - s, s);
			
		if ((s = b - a) > 1)
			quickSort(arr, floor, s);
			
		if ((s = d - c) > 1)
			quickSort(arr, n - s, s);
		
		
		
	}
	
	private void vecSwap(int[] arr, int a, int b, int n) {
		for (int i = 0; i < n; i++, a++, b++ )
			swap(arr, a, b);
	}
	
	//helper method to check whether an array is sorted
	public boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) return false;
			
		}
		return true;
	}
	
	/*
	 * Goal: count inversion by merge sort
	 * Reference: www.geeksforgeeks.com
	 */
	
	public int runNumberOfInversions(int n) {
		int[] inversions = { 2, 3, 9, 2, 9};
		int[] temp = new int[n];
		int count = invertedMergeSort(inversions, temp,  0, n - 1);
		if (isSorted(inversions))
			return count;
		else return - 1;
		
	}

	private int invertedMergeSort(int[] inversions, int[] temp, int floor, int ceiling) {
		// TODO Auto-generated method stub
		int count = 0;
		if (inversions.length <= 1) return 0;
		if (floor < ceiling) {
			int m = (floor + ceiling) / 2;
			count = invertedMergeSort(inversions, temp, floor, m);
			
			count +=  invertedMergeSort(inversions, temp, m + 1, ceiling);
			
			count += mergeCount(inversions, temp, floor, m + 1, ceiling);
			
		}
		return count;
	}

	private int mergeCount(int[] input, int[] temp, int floor, int mid, int ceiling) {
		// TODO Auto-generated method stub
		int count = 0;
		int i = floor;
		int j = mid;
		int k = floor;
		
		while( (i <= mid - 1) && (j <= ceiling) ) {
			if (input[i] <= input[j]) {
				temp[k++] = input[i++];
			} else {
				temp[k++] = input[j++];
				//This is the clue for solving this puzzle
				//Reference www.geeksforgeeks.com
				count = count + (mid - i);
			}
			
		}
		
		while (i <= mid - 1) { 
            temp[k++] = input[i++];
        } 
		
		while (j <= ceiling) { 
            temp[k++] = input[j++]; 
        } 
		
		for (int z = floor; z <= ceiling; z++)
			input[z] = temp[z];
		     
		return count;
	}
	
	public String runNaiveCountSegment() {
		int[] start = {0, 7};
		int[] end = {5, 10};
		int[] points = {1, 6, 11};
		int[] count = naiveCountSegments(start, end, points);
		String s = "";
		
		for (int i = 0; i < count.length; i++)
			s += count[i] + " ";
		
		return s;
		
	}
	
	/*
	 * Goal: count points in segment in O(log n)
	 * I accomplished this in (n + n log n) by sorting segments and points in O(n log n),
	 * and iterate over segments while keeping score of the points. However, running time
	 * is O(n) in best case when everything is sorted beforehand.
	 */
	
	public String runFirstOptimalCountSegment() {
		ArrayList<Pairs> segments = new ArrayList<>();
		int[] starts = {0, 7};
		int[] ends = {5, 10};
		if (isSorted(starts)) {
			for (int i = 0; i < starts.length; i++)
				segments.add(new Pairs(starts[i], ends[i]));
		}
		if (!isSorted(starts)){
			enhancedMergeSort(starts, ends, 0, starts.length);
			for (int i = 0; i < starts.length; i++)
				segments.add(new Pairs(starts[i], ends[i]));
		}
		
		int[] points = {1, 6, 11};
		int[] original = {1, 6, 11};
		int[] count = new int[points.length];
		if (isSorted(points))
			count = optimalCountSegments(segments, points);
		else {
			quickSort(points, 0, points.length);
			count = optimalCountSegments(segments, points);
		}
		String s = "";
		
		if (similar(points, original)) {
			for (int i = 0; i < count.length; i++)
				s += count[i] + " ";
		}
		
		else {
			int[] cnt = nonSimilar(points, original, count);
			for (int i = 0; i < cnt.length; i++)
				s += cnt[i] + " ";
		}
		
		return s;
	}
	
	public String runSecondOptimalCountSegment() {
		ArrayList<Pairs> segments = new ArrayList<>();
		int[] starts = {-10};
		int[] ends = {10};
		
		if (isSorted(starts)) {
			for (int i = 0; i < starts.length; i++)
				segments.add(new Pairs(starts[i], ends[i]));
		}
		if (!isSorted(starts)){
			enhancedMergeSort(starts, ends, 0, starts.length);
			for (int i = 0; i < starts.length; i++)
				segments.add(new Pairs(starts[i], ends[i]));
		}
		
		
		
		int[] points = {-100, 100, 0};
		int[] original = {-100, 100, 0};
		int[] count = new int[points.length];
		if (isSorted(points))
			count = optimalCountSegments(segments, points);
		else {
			quickSort(points, 0, points.length);
			count = optimalCountSegments(segments, points);
		}
		
		String s = "";
		
		if (similar(points, original)) {
			for (int i = 0; i < count.length; i++)
				s += count[i] + " ";
		}
		
		else {
			int[] cnt = nonSimilar(points, original, count);
			for (int i = 0; i < cnt.length; i++)
				s += cnt[i] + " ";
		}
		
		return s;
	}
	
	
	
	public String runThirdOptimalCountSegment() {
		ArrayList<Pairs> segments = new ArrayList<>();
		int[] starts = {0, -3, 7};
		int[] ends = {5, 2, 10};
		
		if (isSorted(starts)) {
			for (int i = 0; i < starts.length; i++) {
				segments.add(new Pairs(starts[i], ends[i]));
			}
		}
		if (!isSorted(starts)){
			enhancedMergeSort(starts, ends, 0, starts.length);
			for (int i = 0; i < starts.length; i++)
				segments.add(new Pairs(starts[i], ends[i]));
		}
		
		
		int[] points = {1, 6};
		int[] original = {1, 6};
		int[] count = new int[points.length];
		if (isSorted(points))
			count = optimalCountSegments(segments, points);
		else {
			quickSort(points, 0, points.length);
			count = optimalCountSegments(segments, points);
		}
		
		String s = "";
		
		if (similar(points, original)) {
			for (int i = 0; i < count.length; i++)
				s += count[i] + " ";
		}
		
		else {
			int[] cnt = nonSimilar(points, original, count);
			for (int i = 0; i < cnt.length; i++)
				s += cnt[i] + " ";
		}
		
		return s;
	}
	
	private void enhancedMergeSort(int[] starts, int[] ends, int floor, int ceiling) {
		// TODO Auto-generated method stub
		if (starts.length <= 1) return;
		else if (ceiling < 7) {
			for (int i = floor; i < ceiling + floor; i++) {
				for (int j = i; j > floor && starts[j - 1] > starts[j]; j--) {
					swap(starts, j, j - 1);
					swap(ends, j, j - 1);
				}
			}
			return;
		} 
		else {
			if (floor < ceiling) {
				int m = (floor + ceiling) / 2;
				enhancedMergeSort(starts, ends, floor, m);
				enhancedMergeSort(starts, ends, m + 1, ceiling);
				merge(starts, ends, floor, m, ceiling);
			
			}
		}
	}
	
	private void merge(int[] starts, int[] ends, int floor, int mid, int ceiling) {
		// TODO Auto-generated method stub
		
		
		int s1 = mid - floor + 1;
		int s2 = ceiling - mid;
		int [] a = new int[s1]; int[] e = new int[s1];
		int [] b = new int[s2]; int[] f = new int[s2];
		
		for (int i = 0; i < s1; i++) {
			a[i] = starts[floor + i];
			e[i] = ends[floor + i];
		}
		for (int j = 0; j < s2; j++) {
			b[j] = starts[mid + 1 + j]; 
			f[j] = ends[mid + 1 + j];
		}
		
		int c = 0; int d = 0;
		
		int k = floor;
		while(c < s1 && d < s2) {
			if (a[c] <= b[d]) {
				starts[k] = a[c];
				ends[k] = e[c];
				c++;
			}
			else {
				starts[k] = b[d];
				ends[k] = f[d];
				d++;
			}
			k++;
		}
		
		while (c < s1) 
        { 
            starts[k] = a[c]; 
            ends[k] = e[c];
            c++; 
            k++; 
        } 
		
		while (d < s2) 
        { 
            starts[k] = b[d]; 
            ends[k] = f[d];
            d++; 
            k++; 
        } 
		     
	}

	private int[] nonSimilar(int[] points, int[] original, int[] count) {
		// TODO Auto-generated method stub
		int[] cnt = new int[points.length];
		for (int i = 0; i < count.length; i++) {
			if (points[i] != original[i]) {
				for (int j = 0; j < points.length; j++) {
					if (points[i] == original[j])
						cnt[j] = count[i];
				}
				
			}
			else {
				cnt[i] = count[i];
			}
		}
		return cnt;
	}

	private boolean similar(int[] points, int[] original) {
		// TODO Auto-generated method stub
		for (int i = 0; i < points.length; i++) {
			if (points[i] != original[i]) return false;
		}
		return true;
	}

	private int[] optimalCountSegments(ArrayList<Pairs> segments, int[] points) {
		// TODO Auto-generated method stub
		int[] cnt = new int[points.length];
		int i = 0;
		int j = 0;
		
		while (!segments.isEmpty() && i < points.length) {
			if (points[i] > segments.get(j).y) {
				segments.remove(j);
				
			} 
			else {
			
				if (segments.get(j).x <= points[i] && points[i] <= segments.get(j).y) {
					cnt[i]++;
					int k = i;
					int z = j + 1;
					i++;
					while (z < segments.size() && segments.get(z).x <= points[k]) {
						if (points[k] <= segments.get(z).y)
							cnt[k]++;
						z++;
					}
					
				}
				else i++;
			}
			
		}
		return cnt;
	}

	private int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }
	
	

}
