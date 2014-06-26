package main;

import clover.org.apache.commons.lang.StringUtils;

public class Calculator {

	public Integer sum(int value, int anotherValue) {
		return value + anotherValue;
	}

	public Integer subtract(int value, int anotherValue) {
		return value - anotherValue;
	}

	public Integer divide(int value, int anotherValue) {
		return value / anotherValue;
	}

	public Sum add(String values) {
		if (StringUtils.isBlank(values)){
			return new Sum(0);
		}
		final SumCalculator sumCalculator = new SumCalculator(values);
		return sumCalculator.sum();
	}
}
