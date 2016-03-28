/*		Title: "Sort.java"
 *	 	Author(s): Sam Dindyal, Farzad Vafaeinezhad
 *	 	Description: The Sort class is a static class written for an assignment on sorting algorithms for an Advanced Algorithms course, CPS616.
 *	 	Date Written: March, 2016
 */  

public class Sort {
	public static void main(String[] args) {

	}

	// Bubble sort
	public static void slowsort(int array[])
	{
		boolean unfinished = true;
		while(unfinished)
		{
			unfinished = false;
			for (int i = 0; i < array.length - 1; i++)
				if (array[i] > array[i + 1])
				{
					swap(array, i, i+1);
					unfinished = true;
				}
		}
	}

	// Merge sort
	public static void fastsort(int array[])
	{
		if (array.length <= 1)
			return;

		// Split array in half
		int[] first = new int[array.length/2];
		int[] second = new int[array.length - first.length];
		System.arraycopy(array, 0, first, 0, first.length);
		System.arraycopy(array, first.length, second, 0, second.length);

		fastsort(first);
		fastsort(second);

		merge(first, second, array);

	}

	/* Helper Functions */

	public static void swap(int array[], int a, int b)
	{
		int temp 	= array[a];
		array[a] 	= array[b];
		array[b] 	= temp;
	}

	public static void merge(int[] first, int[] second, int[] result)
	{
		int indexFirst,			// Starting position of the first element of the array
			indexSecond,		// Starting position of the second array
			indexMerged;		// Index position in the merged array

		indexFirst = indexSecond = indexMerged = 0;

		while (indexFirst < first.length && indexSecond < second.length)
		{
			if (first[indexFirst] < second[indexFirst])
			{
				result[indexMerged] = first[indexFirst];
				indexFirst++;
			}
			else
			{
				result[indexMerged] = second[indexSecond];
				indexSecond++;
			}
			indexMerged++;
		}

		// Copy remaining elements
		System.arraycopy(first, indexFirst, result, indexMerged, first.length - indexFirst);
		System.arraycopy(second, indexSecond, result, indexMerged, second.length - indexSecond);
	}
}