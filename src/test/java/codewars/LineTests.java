package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.runners.JUnit4;

import codewars.kata.Line;

public class LineTests {
	@Test
	public void test1() {
		assertEquals("YES", Line.Tickets(new int[] { 25, 25, 50 }));
	}

	@Test
	public void test2() {
		assertEquals("NO", Line.Tickets(new int[] { 25, 100 }));
	}

	@Test
	public void test3() {
		assertEquals("NO", Line.Tickets(new int[] { 25, 50, 25, 50, 100 }));
	}
}
