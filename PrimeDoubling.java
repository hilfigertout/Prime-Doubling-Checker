/**
 * This program checks if numbers follow the Prime Doubling Conjecture as stated
 * by u/daswagakid. (Link: https://www.reddit.com/r/math/comments/hy0ydf/prime_doubling_conjecture/ )
 * 
 * This program prints the number it is currently testing. If any number tested does not reduce
 * to a number in the one known cycle, this program will enter an infinite loop. 
 * 
 * 
 * @author hilfigertout
 * 
 * @version 20200726
 *
 */
public class PrimeDoubling {

	//Method for implementing the prime doubling algorithm.
	public static long primeDouble(long n) {
		long output = 0;
		boolean prime = true;
		long largestFactor = 0;
		long i = 2;
		//Check every number from 2 to sqrt(n) to find the largest factor
		while ((i * i) <= n) {
			if (n % i == 0) {
				prime = false;
				largestFactor = i;
				
			}
			i++;
		}
		//Determine the output based on whether n is prime
		if (prime) {
			output = 2*n + 1;
		} else {
			output = n/largestFactor;
		}
		return output;
	}
	
	//Method for testing if a number is prime. Not used in the current version. 
	public static boolean isPrime(long root) {
		boolean prime = true;
		if (root % 2 == 0) {
			prime = false;;
		} 
		long i = 3;
		while (((i * i) <= root) && (prime)) {
			if (root % i == 0) {
				prime = false;
			}
			i += 2;
		}
		return prime;
	}
	
	//Method for determining if the loop array contains a given number.
	public static boolean contains(long[] loop, long x) {
		boolean contains = false;
		for (int i = 0; i < loop.length; i++) {
			if (loop[i] == x) {
				contains = true;
				break;
			}
		}
		return contains;
	}
	public static void main(String[] args) {
		//list of numbers in the known loop.
		final long[] loop = {5,11,23,47,95,19,39,13,27,9,3,7,15};
		
		for (long i = 2; i < Long.MAX_VALUE; i++) {
			//print the current number.
			System.out.println(i);
			//Check if the current number is already in the known loop.
			long testNum = i;
			boolean inLoop = contains(loop, testNum);
			//Keep repeating the primeDouble method until the output is
			//	in the known loop.
			while (!(inLoop)) {
				testNum = primeDouble(testNum);
				inLoop = contains(loop, testNum);
			}
			
		}

	}

}
