package recyclerview;

import android.support.annotation.NonNull;

final class Task implements Comparable<Task> {

	final int id;
	final String title;
	boolean isComplete;

	public Task(final int id, final String title, boolean isComplete) {
		this.id = id;
		this.title = title;
		this.isComplete = isComplete;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public int compareTo(@NonNull final Task another) {

		if (isComplete && !another.isComplete) {
			return 1;
		} else if (!isComplete && another.isComplete) {
			return -1;
		}

		return 0;
	}
}
