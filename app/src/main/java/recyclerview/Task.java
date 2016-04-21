package recyclerview;

final class Task {

	final int id;
	final String title;
	boolean isComplete;

	public Task(final int id, final String title, boolean isComplete) {
		this.id = id;
		this.title = title;
		this.isComplete = isComplete;
	}
}
