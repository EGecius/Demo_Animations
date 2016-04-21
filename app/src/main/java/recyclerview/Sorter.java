package recyclerview;

import java.util.ArrayList;
import java.util.List;

final class Sorter {

	public List<Task> sortByCompleted(final List<Task> unsortedTasks) {

		ArrayList<Task> completed = new ArrayList<>();
		ArrayList<Task> notCompleted = new ArrayList<>();

		for (final Task task : unsortedTasks) {
			if (task.isComplete) {
				completed.add(task);
			} else {
				notCompleted.add(task);
			}
		}

		ArrayList<Task> sorted = new ArrayList<>();
		sorted.addAll(completed);
		sorted.addAll(notCompleted);

		return sorted;
	}

}
