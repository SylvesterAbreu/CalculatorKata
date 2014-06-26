package main;

import clover.org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SumCalculator {

	private final String values;

	public SumCalculator(String values) {
		this.values = values;
	}


	public Sum sum() {
		final String[] valuesForSum = StringUtils.split(values, ',');
		if (valuesForSum.length == 1) {
			return sumOfSingleValue(valuesForSum[0]);
		}
		return sumOfMultipleValues(valuesForSum);
	}

	private Sum sumOfSingleValue(String stringValue) {
		final int integerValue = Integer.parseInt(stringValue);

		return new Sum(integerValue);
	}

	private Sum sumOfMultipleValues(String[] valuesForSum) {
		List<SingleValue> singleValueList = getListOfSingleValues(valuesForSum);

		return sumAllValues(singleValueList);
	}

	private List<SingleValue> getListOfSingleValues(String[] valuesForSum) {
		List<SingleValue> singleValueList = new ArrayList<>();

		for (String stringValue: valuesForSum){
			final SingleValue singleValue = getSingleValue(stringValue);
			singleValueList.add(singleValue);
		}
		return singleValueList;
	}

	private SingleValue getSingleValue(String stringValue) {
		int integerValue = Integer.parseInt(stringValue);
		return new SingleValue(integerValue);
	}

	private Sum sumAllValues(List<SingleValue> singleValueList) {
		int sum = 0;
		for(SingleValue singleValue: singleValueList){
			sum += singleValue.fetch();
		}

		return new Sum(sum);
	}
}