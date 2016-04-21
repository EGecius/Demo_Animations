package recyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * //todo
 */
final class RecyclerActivityPresenter {

	private final RecyclerActivityInterface view;

	RecyclerActivityPresenter(final RecyclerActivityInterface view) {
		this.view = view;
	}

	public void onSwapItemsBtnClicked() {

	}

	public void onCreate() {

		ArrayList<Task> tasks = new ArrayList<>();
		tasks.add(new Task(1, "Task one", false));
		tasks.add(new Task(2, "Task two", false));
		tasks.add(new Task(3, "Task three", false));

		view.showRecycler(tasks);
	}

	public void onTaskChecked(final int taskId, final boolean isChecked) {
		List<Task> unsortedInitialTasks = view.getRecyclerData();

		List<Task> unsortedAmmendedForCheckedlTasks = setChecked(unsortedInitialTasks, taskId, isChecked);

		List<Task> sortedTasks = new Sorter().sortByCompleted(unsortedAmmendedForCheckedlTasks);
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
