package codewars.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * The number 89 is the first integer with more than one digit that fulfills the
 * property partially introduced in the title of this kata. What's the use of
 * saying "Eureka"? Because this sum gives the same number.
 * 
 * In effect: 89 = 8^1 + 9^2
 * 
 * The next number in having this property is 135.
 * 
 * See this property again: 135 = 1^1 + 3^2 + 5^3
 * 
 * We need a function to collect these numbers, that may receive two integers a,
 * b that defines the range [a, b] (inclusive) and outputs a list of the sorted
 * numbers in the range that fulfills the property described above.
 * 
 * Let's see some cases:
 * 
 * sum_dig_pow(1, 10) == [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * 
 * sum_dig_pow(1, 100) == [1, 2, 3, 4, 5, 6, 7, 8, 9, 89] If there are no
 * numbers of this kind in the range [a, b] the function should output an empty
 * list.
 * 
 * sum_dig_pow(90, 100) == []
 * 
 * @author liubin10
 * @date 2017年9月21日 下午5:22:18
 */
public class SumDigPower {
	
	// public static List<Long> sumDigPow(long a, long b) {
	// return LongStream.rangeClosed(a, b)
	// .filter(i -> isValid(i))
	// .boxed()
	// .collect(Collectors.toList());
	// }
	//
	// private static boolean isValid(long x){
	// String value = Long.toString(x);
	// return IntStream.range(0, value.length())
	// .mapToDouble(i -> Math.pow(Character.getNumericValue(value.charAt(i)), i
	// + 1))
	// .sum() == x;
	// }

	public static List<Long> sumDigPow(long a, long b) {
		List<Long> result = new ArrayList<>();
		for (long i = a; i <= b; i++)
			if (isEureka(i))
				result.add(i);
		return result;
	}

	private static boolean isEureka(long n) {
		long tmp = n;
		long sum = 0;
		int power = length(n);
		while (tmp > 0) {
			sum += (long) Math.pow(tmp % 10, power);
			tmp /= 10;
			power--;
		}
		return sum == n;
	}

	private static int length(long n) {
		int length = 0;
		while (n > 0) {
			n /= 10;
			length++;
		}
		return length;
	}


	// public static List<Long> sumDigPow(long a, long b) {
	// // your code
	// List<Long> list = new ArrayList<Long>();
	// for (long i = a; i <= b; i++) {
	// if (getResult(i) == Double.valueOf(i))
	// list.add(i);
	// }
	// return list;
	// }
	//
	// static double getResult(long param) {
	//
	// String string = String.valueOf(param);
	//
	// char[] array = string.toCharArray();
	//
	// double result = 0;
	//
	// for (int i = 0; i < array.length; i++) {
	// double dou = Double.valueOf(String.valueOf(array[i]));
	// result = result + Math.pow(dou, i + 1);
	// }
	//
	// return result;
	// }

}