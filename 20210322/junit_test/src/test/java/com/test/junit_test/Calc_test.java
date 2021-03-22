package com.test.junit_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Calc_test {
	@Test
	public void test() {
		Calc c= new Calc();
		assertEquals(3+4, c.calc(3, 4));
		
	}
}
