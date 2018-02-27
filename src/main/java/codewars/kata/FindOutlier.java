package codewars.kata;

import java.util.Arrays;

/**
 * You are given an array (which will have a length of at least 3, but could be
 * very large) containing integers. The array is either entirely comprised of
 * odd integers or entirely comprised of even integers except for a single
 * integer N. Write a method that takes the array as an argument and returns N.
 * 
 * For example:
 * 
 * [2, 4, 0, 100, 4, 11, 2602, 36]
 * 
 * Should return: 11
 * 
 * [160, 3, 1719, 19, 11, 13, -21]
 * 
 * Should return: 160
 * 
 * @author liubin10
 * @date 2017年9月21日 下午4:25:08
 */
public class FindOutlier {
	public static int find(int[] integers) {

		int sum = Arrays.stream(integers).limit(3).map(i -> Math.abs(i) % 2).sum();
		int mod = (sum > 1) ? 1 : 0;
		return Arrays.stream(integers).parallel()// 并行提速
				.filter(i -> Math.abs(i) % 2 != mod).findFirst().getAsInt();
	}
}
