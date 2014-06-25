package main;

public class SingleValue {
	private final int value;

	public SingleValue(int value) {
		this.value = value;
	}

	public int fetch() {
		return value;
	}
}
