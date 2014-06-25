package main;

import clover.org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

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

	public String add(String values) {
		if (StringUtils.isBlank(values)){
			return "0";
		}
		return getSum(values);
	}

	private String getSum(String values) {
		final String[] valuesForSum = StringUtils.split(values, ',');
		if (valuesForSum.length == 1) {
			final String stringValue = valuesForSum[0];
			return stringValue;
		}

		List<SingleValue> singleValueList = new ArrayList<>();
		for (String stringValue: valuesForSum){
			int integerValue = Integer.parseInt(stringValue);
			final SingleValue singleValue = new SingleValue(integerValue);
			singleValueList.add(singleValue);
		}

		int sum = 0;
		for(SingleValue singleValue: singleValueList){
			sum += singleValue.fetch();
		}


		return sum + "";
	}
}
