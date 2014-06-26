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

	public Sum add(String values) {
		if (StringUtils.isBlank(values)){
			return new Sum(0);
		}
		return getSum(values);
	}

	private Sum getSum(String values) {
		final String[] valuesForSum = StringUtils.split(values, ',');
		if (valuesForSum.length == 1) {
			return getSumOfSingleValue(valuesForSum[0]);
		}
		return getSumOfMultipleValues(valuesForSum);
	}

	private Sum getSumOfSingleValue(String s) {
		final int integerValue = Integer.parseInt(s);
		return new Sum(integerValue);
	}

	private Sum getSumOfMultipleValues(String[] valuesForSum) {
		List<SingleValue> singleValueList = getListOfSingleValues(valuesForSum);

		return sumAllValues(singleValueList);
	}

	private List<SingleValue> getListOfSingleValues(String[] valuesForSum) {
		List<SingleValue> singleValueList = new ArrayList<>();
		for (String stringValue: valuesForSum){
			int integerValue = Integer.parseInt(stringValue);
			final SingleValue singleValue = new SingleValue(integerValue);
			singleValueList.add(singleValue);
		}
		return singleValueList;
	}

	private Sum sumAllValues(List<SingleValue> singleValueList) {
		int sum = 0;
		for(SingleValue singleValue: singleValueList){
			sum += singleValue.fetch();
		}

		return new Sum(sum);
	}
}
