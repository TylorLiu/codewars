package codewars.kata;

import java.util.Arrays;

/**
 * ###Lyrics... Pyramids are amazing! Both in architectural and mathematical
 * sense. If you have a computer, you can mess with pyramids even if you are not
 * in Egypt at the time. For example, let's consider the following problem.
 * Imagine that you have a plane pyramid built of numbers, like this one here:
 * 
 * /3/ \7\ 4 2 \4\ 6 8 5 \9\ 3 Here comes the task...
 * 
 * Let's say that the 'slide down' is a sum of consecutive numbers from the top
 * to the bottom of the pyramid. As you can see, the longest 'slide down' is 3 +
 * 7 + 4 + 9 = 23
 * 
 * Your task is to write a function longestSlideDown (in ruby:
 * longest_slide_down) that takes a pyramid representation as argument and
 * returns its' longest 'slide down'. For example,
 * 
 * longestSlideDown [[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]] // => 23 ###By the
 * way... My tests include some extraordinarily high pyramides so as you can
 * guess, brute-force method is a bad idea unless you have a few centuries to
 * waste. You must come up with something more clever than that.
 * 
 * (c) This task is a lyrical version of the Problem 18 and/or Problem 67 on
 * ProjectEuler.
 * 
 * @author liubin10
 * @date 2017年9月26日 下午2:00:18
 */
public class LongestSlideDown {

	/**
	 * 逐层向上汇总
	 * 
	 * @author liubin10 2017年9月26日
	 * @param pyramid
	 * @return
	 */
	public static int longestSlideDown(int[][] pyramid) {
		
		for (int i = pyramid.length - 1; i >= 1; i--)
			for (int j = 0; j < i; j++)
				pyramid[i - 1][j] += Math.max(pyramid[i][j], pyramid[i][j + 1]);


		// if (pyramid.length > 1) {
		// for (int i = pyramid.length - 2; i >= 0; i--) {
		// for (int j = 0; j < pyramid[i].length; j++) {
		// pyramid[i][j] += Math.max(pyramid[i + 1][j], pyramid[i + 1][j + 1]);
		// }
		// }
		// }

		return pyramid[0][0];
	}


	/**
	 * 迭代 --- 耗时久
	 * 
	 * @author liubin10 2017年9月26日
	 * @param pyramid
	 * @return
	 */
	public static int longestSlideDownItr(int[][] pyramid) {

		int result = pyramid[0][0];
		if (pyramid.length == 1) {
			return result;
		}
		int[][] child1 = new int[pyramid.length-1][];
		int[][] child2 = new int[pyramid.length - 1][];
		
		if (pyramid.length > 1) {

			for (int i = 1; i < pyramid.length; i++) {
				child1[i - 1] = new int[pyramid[i].length - 1];
				System.arraycopy(pyramid[i], 0, child1[i - 1], 0, pyramid[i].length - 1);
				child2[i - 1] = new int[pyramid[i].length - 1];
				System.arraycopy(pyramid[i], 1, child2[i - 1], 0, pyramid[i].length - 1);
			}
		}
		result +=Math.max(longestSlideDown(child1), longestSlideDown(child2));

		return result;
	}
}