package recyclerview;

import java.util.ArrayList;

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


	public void onUpdateBtnClicked(final String input) {
		Task task = new Task(1, input, false);
		view.updateList(task);
	}

}
