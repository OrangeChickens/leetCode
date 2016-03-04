class Abc {
	static Abc obj = new Abd();
	private Abc() {

	}
	public static Abc getInstance() {
		return obj;
	}
}
// class Abc can only have one instance.


// builder pattern

