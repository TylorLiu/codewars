package codewars;

import static org.junit.Assert.*;

import org.junit.Test;

import codewars.kata.SumOfK;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfKTest {

	// ----------------
	private static int randint(Random rnd, int min, int max) {
		int randomNumber = rnd.nextInt(max - min) + min;
		return randomNumber;
	}

	private static void combAux120987(List<Integer> l, int k, int offset, List<Integer> partialComb, List<List<Integer>> result) {
		if (partialComb.size() == k) {
			result.add(new ArrayList<>(partialComb));
			return;
		}
		final int REMAINING = k - partialComb.size();
		int lg = l.size();
		for (int i = offset; i < lg && REMAINING < lg - i + 1; ++i) {
			Integer x = l.get(i);
			partialComb.add(x);
			combAux120987(l, k, i + 1, partialComb, result);
			partialComb.remove(partialComb.size() - 1);
		}
	}

	private static List<List<Integer>> comb120987(List<Integer> l, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> partialComb = new ArrayList<>();
		combAux120987(l, k, 0, partialComb, result);
		return result;
	}

	private static Integer chooseBestSum120987(int t, int k, List<Integer> ls) {
		List<List<Integer>> res = comb120987(ls, k);
		int mx = -1;
		for (int i = 0; i < res.size(); i++) {
			List<Integer> s = res.get(i);
			int sm = 0;
			for (Integer n : s) {
				sm += n;
			}
			if ((sm >= mx) && (sm <= t)) {
				mx = sm;
			}
		}
		if (mx != -1)
			return new Integer(mx);
		else
			return null;
	}

	// ----------------
 
    @Test
    public void BasicTests1() {
        System.out.println("****** Basic Tests small numbers******");
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(163, n);
        ts = new ArrayList<>(Arrays.asList(50));
        Integer m = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(null, m);      
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        n = SumOfK.chooseBestSum(230, 3, ts);
        assertEquals(228, n);
		n = SumOfK.chooseBestSum(331, 2, ts);
		assertEquals(178, n);
		n = SumOfK.chooseBestSum(331, 4, ts);
		assertEquals(331, n);
		m = SumOfK.chooseBestSum(331, 5, ts);
		assertEquals(null, m);
		n = SumOfK.chooseBestSum(331, 1, ts);
		assertEquals(91, n);
		m = SumOfK.chooseBestSum(700, 8, ts);
		assertEquals(null, m);
    }

	@Test
	public void BasicTests2() {
		System.out.println("****** Basic Tests bigger numbers******");
		List<Integer> ts = new ArrayList<>(Arrays.asList(100, 76, 56, 44, 89, 73, 68, 56, 64, 123, 2333, 144, 50, 132, 123, 34, 89));
		int n = SumOfK.chooseBestSum(230, 4, ts);
		assertEquals(230, n);
		n = SumOfK.chooseBestSum(430, 5, ts);
		assertEquals(430, n);
		Integer m = SumOfK.chooseBestSum(430, 8, ts);
		assertEquals(null, m);
		n = SumOfK.chooseBestSum(880, 8, ts);
		assertEquals(876, n);
		n = SumOfK.chooseBestSum(2430, 15, ts);
		assertEquals(1287, n);
		n = SumOfK.chooseBestSum(100, 2, ts);
		assertEquals(100, n);
		n = SumOfK.chooseBestSum(276, 3, ts);
		assertEquals(276, n);
		n = SumOfK.chooseBestSum(3760, 17, ts);
		assertEquals(3654, n);
		m = SumOfK.chooseBestSum(3760, 40, ts);
		assertEquals(null, m);
		n = SumOfK.chooseBestSum(50, 1, ts);
		assertEquals(50, n);
		m = SumOfK.chooseBestSum(1000, 18, ts);
		assertEquals(null, m);
		ts = new ArrayList<>(Arrays.asList(100, 64, 123, 2333, 144, 50, 132, 123, 34, 89));
		m = SumOfK.chooseBestSum(230, 4, ts);
		assertEquals(null, m);
		n = SumOfK.chooseBestSum(230, 2, ts);
		assertEquals(223, n);
		n = SumOfK.chooseBestSum(2333, 1, ts);
		assertEquals(2333, n);
		n = SumOfK.chooseBestSum(2333, 8, ts);
		assertEquals(825, n);
		ts = new ArrayList<>(Arrays.asList(1000, 640, 1230, 2333, 1440, 500, 1320, 1230, 340, 890, 732, 1346));
		n = SumOfK.chooseBestSum(2300, 4, ts);
		assertEquals(2212, n);
		m = SumOfK.chooseBestSum(2300, 5, ts);
		assertEquals(null, m);
		n = SumOfK.chooseBestSum(2332, 3, ts);
		assertEquals(2326, n);
		n = SumOfK.chooseBestSum(23331, 8, ts);
		assertEquals(10789, n);
		m = SumOfK.chooseBestSum(331, 2, ts);
		assertEquals(null, m);
	}

	@Test
	public void RandomTests() {
		System.out.println("****** Random tests ******");
		Random rnd = new Random();
		for (int i = 0; i < 25; i++) {
			List<Integer> ts = new ArrayList<>();
			for (int j = 0; j < 20; j++) {
				int n = randint(rnd, 10, 500);
				ts.add(n);
			}
			int p = randint(rnd, 1, 5);
			int k = randint(rnd, 50, 2000);
			assertEquals(chooseBestSum120987(k, p, ts), SumOfK.chooseBestSum(k, p, ts));
		}
	}
}

















