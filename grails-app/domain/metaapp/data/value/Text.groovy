package metaapp.data.value

public class Text extends Value {

	String value

	@Override
	public void update(String value) {
		this.value = value
	}

	public String toString() {
		value
	}

}
