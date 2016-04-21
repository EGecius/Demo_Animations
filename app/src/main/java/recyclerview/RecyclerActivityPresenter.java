package recyclerview;

import java.util.ArrayList;
import java.util.List;

final class RecyclerActivityPresenter {

	private final RecyclerActivityInterface view;

	RecyclerActivityPresenter(final RecyclerActivityInterface view) {
		this.view = view;
	}

	public void onCreate() {

		ArrayList<Task> tasks = new ArrayList<>();
		tasks.add(new Task(1, "Task one", false));
		tasks.add(new Task(2, "Task two", false));
		tasks.add(new Task(3, "Task three", false));
		tasks.add(new Task(4, "Task four", false));
		tasks.add(new Task(5, "Task five", false));
		tasks.add(new Task(6, "Task six", false));
		tasks.add(new Task(7, "Task seven", false));

		view.showRecycler(tasks);
	}

	public void onTaskChecked(final int taskId, final boolean isChecked) {
		List<Task> unsortedInitialTasks = view.getRecyclerData();

		int indexInitial = getIndex(unsortedInitialTasks, taskId);
		List<Task> unsortedAmendedForCheckedTasks = setChecked(unsortedInitialTasks, taskId, isChecked);
		List<Task> sortedTasks = new Sorter().sortByCompleted(unsortedAmendedForCheckedTasks);
		int indexSorted = getIndex(sortedTasks, taskId);

		view.updateListWithAnimation(sortedTasks, indexInitial, indexSorted);
	}

	private int getIndex(final List<Task> tasks, final int taskId) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).id == taskId) {
				return i;
			}
		}
		throw new IllegalArgumentException("index not found taskId " + taskId);
	}

	private List<Task> setChecked(final List<Task> tasks, final int taskId, final boolean isChecked) {

		List<Task> amendedTasks = new ArrayList<>(tasks);
		for (final Task task : amendedTasks) {
			if (task.id == taskId) {
				task.isComplete = isChecked;

			}
		}
		return amendedTasks;
	}

}
