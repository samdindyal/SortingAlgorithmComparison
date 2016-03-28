/*		Title: "Assignment.java"
 *	 	Author(s): Sam Dindyal, Farzad Vafaeinezhad
 *	 	Description: The Assignment class is a static class written for an assignment on sorting algorithms for an Advanced Algorithms course, CPS616.
 *	 	Date Written: March, 2016
 */  

import java.util.Random;
import java.util.Arrays;

public class Assignment {

	final static int N = 100;						// Size of the array
	final static int MAXVALUE = 10*N;				// Maximum value in the array
	final static int AVERAGEOVER = 1000000/N;		// Number of iterations over which to average performance

	public static void main(String[] args)
	{

		if (args.length == 0)
		{
			System.out.println("No arguments provided. Fall back to N = " + N + ".");
			test(N);
		}
		else if (args[0].equalsIgnoreCase("all"))
		{
			System.out.println("Testing all hardcoded values of N.");
			testMultiple(new int[]{10, 20, 50, 
				100,     200,      500, 
				1000,    2000,     5000, 
				10000,   20000,    50000, 
				100000,   200000,   500000, 
				1000000});
		}
		else {
			for (String arg : args)
				try {
					test(Integer.parseInt(arg));
				} catch (NumberFormatException e) {
					System.err.println("\"" + arg + "\" is not a valid number.");
				}
		}
	}

	public static void testMultiple(int[] n) 
	{
		for (int i = 0; i < n.length; i++)
			test(n[i]);
	}

	public static void test(int n)
	{
		int array1[] = new int[n], array2[];
		Random random = new Random();
		int maxValue, averageOver;
		double timeFast, timeSlow, startTime;
		timeFast = timeSlow = startTime = 0;
		maxValue = 10*n;
		averageOver = 1000000/n;

		for (int i = 0; i < averageOver; i++)
		{
			for (int j = 0; j < n; j++)
				array1[j] = random.nextInt(maxValue) + 1;
			array2 = array1.clone();

			startTime = System.nanoTime();
			Sort.fastsort(array1);
			timeFast += System.nanoTime() - startTime;

			startTime = System.nanoTime();
			Sort.slowsort(array2);
			timeSlow += System.nanoTime() - startTime;
		}

		timeSlow /= averageOver;
		timeFast /= averageOver;

		System.out.println("Average slow sort time for N = " + n + " element" + (n!=1 ? "s" : "") + ":\t\t" + timeSlow + " ns.");
		System.out.println("Average fast sort time for N = " + n + " element" + (n!=1 ? "s" : "") + ":\t\t" + timeFast + " ns.");
	}
}