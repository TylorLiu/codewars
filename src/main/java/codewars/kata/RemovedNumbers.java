package codewars.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * A friend of mine takes a sequence of numbers from 1 to n (where n > 0).
 * Within that sequence, he chooses two numbers, a and b. He says that the
 * product of a and b should be equal to the sum of all numbers in the sequence,
 * excluding a and b. Given a number n, could you tell me the numbers he
 * excluded from the sequence? The function takes the parameter: n (don't worry,
 * n is always strictly greater than 0 and small enough so we shouldn't have
 * overflow) and returns an array of the form:
 * 
 * [(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or or [{a, b}, ...] with all
 * (a, b) which are the possible removed numbers in the sequence 1 to n.
 * 
 * [(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or ...will be sorted in
 * increasing order of the "a".
 * 
 * It happens that there are several possible (a, b). The function returns an
 * empty array if no possible numbers are found which will prove that my friend
 * has not told the truth! (Go: in this case return nil).
 * 
 * (See examples for each language in "RUN EXAMPLES")
 * 
 * #Examples:
 * 
 * removNb(26) should return [(15, 21), (21, 15)] or
 * 
 * removNb(26) should return { {15, 21}, {21, 15} } or
 * 
 * removeNb(26) should return [[15, 21], [21, 15]] or
 * 
 * removNb(26) should return [ {15, 21}, {21, 15} ] or
 * 
 * in C: removNb(26) should return **an array of pairs {{15, 21}{21, 15}}**
 * tested by way of strings.
 * 
 * @author liubin10
 * @date 2017年9月27日 下午5:09:12
 */
public class RemovedNumbers {

	public static List<long[]> removNb(long n) {
		
		
		List<long[]> result = new ArrayList<>();
		long sum = (n + 1) * n / 2;
		
		for (long i = 1; i <= n; i++) {

			for (long j = i + 1; j < n; j++) {
				if (i * j == (sum - i - j)) {
					result.add(new long[]{i,j});
					result.add(new long[]{j,i});
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(removNb(26));
	}
}
