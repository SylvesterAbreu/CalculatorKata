package test;

import main.Calculator;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

	@Test
	public void shouldSumThreePlusFiveEqualsEight() throws Exception {
		final Calculator calculator = new Calculator();

		assertThat(calculator.sum(3, 5), is(equalTo(8)));
	}
}
