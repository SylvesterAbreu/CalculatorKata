package test;

import main.Calculator;
import main.Sum;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

	@Test
	public void returns_sum_zero_when_empty_string_is_added(){
		Calculator calculator = new Calculator();
		Sum value = calculator.add("");

		assertThat(value.fetch(), is(equalTo(0)));
	}

	@Test
	public void returns_same_number_when_only_one_is_added(){
		Calculator calculator = new Calculator();
		Sum value = calculator.add("8");

		assertThat(value.fetch(), is(equalTo(8)));
	}

	@Test
	public void returns_sum_of_multiple_numbers_added() {
		Calculator calculator = new Calculator();
		Sum value = calculator.add("12,9");

		assertThat(value.fetch(), is(equalTo(21)));
	}

	@Test
	public void shouldSumThreePlusFiveEqualsEight() throws Exception {
		final Calculator calculator = new Calculator();

		assertThat(calculator.sum(3, 5), is(equalTo(8)));
	}

	@Test
	public void shouldSubtractTenByFourIsSix() throws Exception {
		final Calculator calculator = new Calculator();

		assertThat(calculator.subtract(10, 4), is(equalTo(6)));

	}

	@Test
	public void shouldDivideTenByTwoEqualsFive() throws Exception {
		final Calculator calculator = new Calculator();

		assertThat(calculator.divide(10, 2), is(equalTo(5)));
	}
}